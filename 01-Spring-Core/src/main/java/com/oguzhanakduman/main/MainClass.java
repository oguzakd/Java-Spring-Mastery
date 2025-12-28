package com.oguzhanakduman.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oguzhanakduman.config.AppConfig;
import com.oguzhanakduman.model.User;
import com.oguzhanakduman.services.UserService;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		for (User user : userService.getUserList()) {
			System.out.println(user);
		}
	}

}
