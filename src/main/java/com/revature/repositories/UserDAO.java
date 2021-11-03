package com.revature.repositories;

import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.User;

public interface UserDAO {

	public List<User> findAll();
	public User findById(int id);
	public User findByUsername(String username);
	public User findByUsername(User user);

	
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	
	
}
