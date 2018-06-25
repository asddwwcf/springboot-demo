package com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.model.User;
import com.my.dao.UserDao;

/**
 * 用户相关处理类，目前是模拟数据
 */
@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public User findUser(String username) {
		return userDao.findByName(username);
	}

	public User login(String username,String password) {
		User user = new User();
		user.setName("111");
		return user;
	}

}
