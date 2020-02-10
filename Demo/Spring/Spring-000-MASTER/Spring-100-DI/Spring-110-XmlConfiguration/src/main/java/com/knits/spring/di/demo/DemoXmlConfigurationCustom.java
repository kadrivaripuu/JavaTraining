package com.knits.spring.di.demo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ht.common.dao.UserDao;
import com.ht.common.dto.UserDto;
import com.ht.common.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoXmlConfigurationCustom {

	public static void main(String[] args) {

		demoApplicationContext();
		
	}

	private static void demoApplicationContext() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("demo-config.xml");
		DataSource ds = context.getBean(DataSource.class);
		testDatasource(ds);
		
		UserDao userDao = context.getBean(UserDao.class);
		userDao.findUser(2);
		
		
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


	
	private static void testDatasource(DataSource ds) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			log.info("Connection opened");
		

		} catch (Exception e) {
			log.error("Impossible to connect to Database", e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
					log.info("connection closed");
				} catch (Exception e) {
					/* ignore close errors */ }
			}
		}
	}
}
