package com.ht.common.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String email;
	private String role;
}
