package com.revature.repos;

import java.util.List;

import com.revature.models.UserWAS;

public interface UserDAO {

	public List<UserWAS> findAll();
	public UserWAS findById(int id);
	public UserWAS findByUsername(String username);
	public UserWAS findByUsername(UserWAS user);

	
	boolean addUser(UserWAS user);
	boolean updateUser(UserWAS user);
	boolean deleteUser(UserWAS user);
	
	
}
