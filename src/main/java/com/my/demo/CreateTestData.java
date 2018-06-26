package com.my.demo;

import com.my.demo.service.ConfigService;
import com.my.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.my.demo.model.Config;
import com.my.demo.model.User;
import com.my.demo.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * 增加测试数据 （上线时候需要删除掉）
 * 
 * @author 晓风轻
 *
 */
@Component
@Slf4j
public class CreateTestData implements CommandLineRunner {

  @Autowired
  ConfigService configService;

  @Autowired
  UserDao userDao;

  @Override
  public void run(String... args) throws Exception {
    // 用户不存在则创建测试数据
    if (userDao.findByName("xwjie") == null) {
      log.error("创建测试数据.....");

      createUsers();
      createConfigs();

      log.error("创建测试数据完毕");
    }
  }

  public void createUsers() {

    log.error("---addUser---");

    User user = new User();

    user.setName("admin");
    user.setNick("管理员");
    user.setRole("admin");

    userDao.save(user);

    for (int i = 1; i <= 10; i++) {
      User u = new User();

      u.setName("user" + i);
      u.setNick("测试用户" + i);
      u.setRole("user");

      userDao.save(u);
    }
  }

  public void createConfigs() {
    log.error("---addTestData---");

    for (int i = 1; i <= 10; i++) {
      User user = userDao.findByName("user" + i);

      UserUtil.setUser(user);

      for (int j = 0; j < 6; j++) {
        Config config = new Config();

        config.setName("测试数据：" + i + ":" + j);
        System.out.println("测试数据：" + i + ":" + j);
        config.setValue("https://github.com/xwjie");
        config.setDescription("管理员：" + i + ":" + j);

        // 创建记录的用户
        config.setCreator(user);

        configService.add(config);
      }
    }
  }

}
