package com.revature.repositories;

import java.util.List;

import com.revature.models.Home;

public interface HomeDAO {
	
	List<Home> findAllHomes();
	Home findByName(String name);
	boolean addHome(Home home);
	boolean updateHome(Home home);
	boolean deleteHome(Home home);

}
