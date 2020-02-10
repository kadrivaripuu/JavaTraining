package com.ht.common.dto;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String email;
	private String role;
}

