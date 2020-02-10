package com.ht.common.util;

import com.ht.common.dto.UserDto;
import com.ht.common.model.User;


public class BeanUtils {

	
	public static User dto2Model(UserDto dto){
//		throw new UnsupportedOperationException(" not yet implemented");
		
		User user = new User();
		user.setFname("Testx");
		user.setLname("Testx");
		user.setUsername("testx");
		user.setPassword("terex");
		user.setEmail("test@test.comx");
		user.setRole("testerx");
		return user;
	}
	
	public static UserDto model2Dto(User model){
//		throw new UnsupportedOperationException(" not yet implemented");
		
		UserDto dto = new UserDto();
		dto.setFname(model.getFname());
		dto.setLname(model.getLname());
		dto.setUsername(model.getUsername());
		dto.setPassword(model.getPassword());
		dto.setEmail(model.getEmail());
		dto.setRole(model.getRole());
		return dto;
	
	}
}
