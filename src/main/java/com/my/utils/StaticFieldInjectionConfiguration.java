package com.my.utils;

import com.my.filter.UserFilter;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 工具类的注入
 */
@Configuration
public class StaticFieldInjectionConfiguration {

	@Autowired
	MessageSource resources;

	@Autowired
	UserService userService;

	@PostConstruct
	private void init() {
		System.out.println("\n\n-----StaticFieldInjectionConfiguration----\n\n");
		CheckUtil.setResources(resources);
		UserFilter.setUserService(userService);
	}
}