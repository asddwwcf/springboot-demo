package com.my.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan
@EnableAutoConfiguration
//mybatis配置
@MapperScan("com.my.demo.dao.**")
//jpa配置
@ComponentScan(basePackages="com.my.demo")
@EntityScan(basePackages="com.my.demo.model")
@EnableJpaRepositories(basePackages="com.my.demo.dao")
public class SpringbootCodeTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCodeTemplateApplication.class, args);
	}

}
