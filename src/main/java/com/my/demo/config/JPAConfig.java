package com.my.demo.config;

import com.my.demo.utils.UserUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.my.demo.model.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
// 不指定bean也可以 @EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JPAConfig {
	@Bean
	public AuditorAware<User> auditorAware() {
		return new AuditorAware<User>() {

			@Override
			public Optional<User> getCurrentAuditor() {
				System.out.println("\n\nJPAConfig.auditorAware().new AuditorAware() {...}.getCurrentAuditor()");

				return Optional.ofNullable(UserUtil.getUser());
			}
		};
	}
}