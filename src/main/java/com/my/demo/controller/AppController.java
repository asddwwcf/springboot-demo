package com.my.demo.controller;

import javax.servlet.http.HttpSession;

import com.my.demo.model.ResultBean;
import com.my.demo.service.UserService;
import com.my.demo.utils.UserUtil;
import com.my.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * app相关的controller，支持跨域
 */
@RequestMapping("/app")
@RestController
@CrossOrigin
public class AppController {
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
    UserService userService;

	 @PostMapping(value = "/login")
	 public ResultBean<User> login(HttpSession session, String username, String
	 password) {
	 logger.info("login user:" + username);

	 User user = userService.login(username, password);
	 session.setAttribute(UserUtil.KEY_USER, user);

	 return new ResultBean<User>(user);
	 }

	@PostMapping(value = "/logout")
	public ResultBean<Boolean> logout(HttpSession session) {
		session.invalidate();
		return new ResultBean<Boolean>(true);
	}
}
