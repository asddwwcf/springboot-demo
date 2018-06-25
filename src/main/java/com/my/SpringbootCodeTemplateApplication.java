package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
@EnableAutoConfiguration
public class SpringbootCodeTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCodeTemplateApplication.class, args);
	}

}
