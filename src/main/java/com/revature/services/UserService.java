package com.revature.services;

import java.util.List;

import com.revature.models.UserWAS;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImplementation;

public class UserService {
	
	private UserDAO userDao = new UserDAOImplementation();
	
	public List<UserWAS> getAllUsers() {
		return userDao.findAll();
	}

	public UserWAS getUser(int id) {
		UserWAS user = userDao.findById(id);
		if (user != null) {
			return user;
		}else {
			return new UserWAS();
		}
	}
	
	public UserWAS getUser(UserWAS user) {
		UserWAS founduser = userDao.findByUsername(user.getUsername());
		if (founduser != null) {
			return founduser;
		}else {
			return new UserWAS();
		}
	}
	
	public UserWAS getUser(String username) {
		UserWAS user = userDao.findByUsername(username);
		if (user != null) {
			return user;
		}else {
			return new UserWAS();
		}
	}
	
	
	
	public boolean addUser(UserWAS user) {
		return userDao.addUser(user);
	}
	
	public boolean updateUser(UserWAS user) {
		return userDao.updateUser(user);
	}
	
	public boolean deleteUser(int id) {
		UserWAS user = getUser(id);
		return userDao.deleteUser(user);
	}
	
	public boolean deleteUser(UserWAS user) {
		return userDao.deleteUser(user);
	}
	
	public boolean deleteUser(String username) {
		UserWAS user = getUser(username);
		return userDao.deleteUser(user);
	}
	
	
}
