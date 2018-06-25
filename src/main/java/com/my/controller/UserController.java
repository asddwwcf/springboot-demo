package com.my.controller;

import java.util.Arrays;
import java.util.List;

import com.my.model.ResultBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	/**
	 * 测试数据
	 */
	@GetMapping("/search")
	public ResultBean<List<User>> search(@RequestParam String keyword) {
		System.out.println("UserController.search()" + keyword);

		User user = new User();

		user.setId(1000L);
		user.setName("admin");
		user.setNick("管理员");
		user.setRole("admin");

		List<User> nodes = Arrays.asList(user);

		return new ResultBean<>(nodes);
	}

}
