package com.oguzhanakduman.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oguzhanakduman.model.User;
import com.oguzhanakduman.services.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		UserService userService = new UserService();
		List<User> userList = new ArrayList<>();
		userList.add(new User("Oğuzhan"));
		userList.add(new User("Ömer"));
		userService.setUserList(userList);
		return userService;
	}

}
