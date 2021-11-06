package com.revature.models;

public class User {
	
	private String username;
	private String password;
	private String role;
	
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	
	

}
