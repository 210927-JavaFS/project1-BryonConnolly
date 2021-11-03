package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImplementation;

public class UserService {
	
	private UserDAO userDao = new UserDAOImplementation();
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User getUser(int id) {
		User user = userDao.findById(id);
		if (user != null) {
			return user;
		}else {
			return new User();
		}
	}
	
	public User getUser(User user) {
		User founduser = userDao.findByUsername(user.getUsername());
		if (founduser != null) {
			return founduser;
		}else {
			return new User();
		}
	}
	
	public User getUser(String username) {
		User user = userDao.findByUsername(username);
		if (user != null) {
			return user;
		}else {
			return new User();
		}
	}
	
	
	
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}
	
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	public boolean deleteUser(int id) {
		User user = getUser(id);
		return userDao.deleteUser(user);
	}
	
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}
	
	public boolean deleteUser(String username) {
		User user = getUser(username);
		return userDao.deleteUser(user);
	}
	
	
}
