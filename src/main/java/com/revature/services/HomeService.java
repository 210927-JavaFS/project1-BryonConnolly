package com.revature.services;

import java.util.List;

import com.revature.models.Home;
import com.revature.repos.HomeDAO;
import com.revature.repos.HomeDAOImpl;

public class HomeService {

	private HomeDAO homeDao = new HomeDAOImpl();

	public List<Home> getAllHomes() {
		return homeDao.findAllHomes();
	}

	public Home getHome(String name) {
		Home home = homeDao.findByName(name);
		if (home != null) {
			return home;
		}else {
			return new Home();
		}
	}
	
	public boolean addHome(Home home) {
		return homeDao.addHome(home);
	}
	
	public boolean updateHome(Home home) {
		return homeDao.updateHome(home);
	}
	
	public boolean deleteHome(String name) {
		Home home = getHome(name);
		return homeDao.deleteHome(home);
	}

}
