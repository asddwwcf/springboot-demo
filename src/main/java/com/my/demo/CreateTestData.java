package com.my.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.my.demo.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * 增加测试数据 （上线时候需要删除掉）
 */
@Component
@Slf4j
public class CreateTestData implements CommandLineRunner {

  @Autowired
  UserDao userDao;

  @Override
  public void run(String... args) throws Exception {
  }

  public void createUsers() {

  }

  public void createConfigs() {
    log.error("---addTestData---");

      }
    }



