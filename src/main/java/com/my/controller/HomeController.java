package com.my.controller;

import javax.servlet.http.HttpSession;

import com.my.model.ResultBean;
import com.my.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.User;

@RestController
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PostMapping("/login")
	public ResultBean<User> login(HttpSession session, String username) {
		logger.info("login user:" + username);

		// TODO 只是模拟登陆
		User user = new User();

		user.setId(1000L);
		user.setName("admin");
		user.setNick("管理员");
		user.setRole("admin");

		session.setAttribute(UserUtil.KEY_USER, user);

		return new ResultBean<User>(user);
	}

}
