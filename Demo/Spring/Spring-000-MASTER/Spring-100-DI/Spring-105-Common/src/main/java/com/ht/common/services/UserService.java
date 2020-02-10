package com.ht.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.common.dao.UserDao;
import com.ht.common.dto.UserDto;
import com.ht.common.model.User;
import com.ht.common.util.BeanUtils;

import lombok.Setter;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	

	public void registerUser (UserDto userDto) {
				
		User userAsModel = BeanUtils.dto2Model(userDto);
		userDao.saveUser(userAsModel);
		
	}
	
	
	
	
}
