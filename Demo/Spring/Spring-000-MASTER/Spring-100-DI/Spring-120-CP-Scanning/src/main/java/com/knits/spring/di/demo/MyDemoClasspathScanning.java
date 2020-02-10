package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ht.common.dto.UserDto;
import com.ht.common.services.UserService;
import com.knits.spring.common.utils.Mocks;

@Slf4j
public class MyDemoClasspathScanning {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo-beans.xml");


		UserService userService = context.getBean(UserService.class);
		
		UserDto mockUser = new UserDto();
		mockUser.setFname("Test");
		mockUser.setLname("Test");
		mockUser.setUsername("test");
		mockUser.setPassword("tere");
		mockUser.setEmail("test@test.com");
		mockUser.setRole("tester");
		
		
		userService.registerUser(mockUser);
		
		
		
	}

	
}
