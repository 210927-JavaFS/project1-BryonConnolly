package com.revature.services;

import com.revature.models.User;

public class UserDAO {
	
	public User getByUsername(String username) {
		if(username.equals("pcoulson")) {
			return new User("pcoulson", "capRocks".hashCode(), "Agent");
		}
		return null;
	}

}
