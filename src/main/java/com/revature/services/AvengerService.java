package com.revature.services;

import java.util.List;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;
import com.revature.repositories.AvengerDAOImpl;

public class AvengerService {
	
	private AvengerDAO avengerDao = new AvengerDAOImpl();
	
	public List<Avenger> getAllAvengers() {
		return avengerDao.findAllAvengers();
	}

	public Avenger getAvenger(int id) {
		Avenger avenger = avengerDao.findById(id);
		if (avenger != null) {
			return avenger;
		}else {
			return new Avenger();
		}
	}
	
	public boolean addAvenger(Avenger avenger) {
		return avengerDao.addAvenger(avenger);
	}
	
	public boolean updateAvenger(Avenger avenger) {
		return avengerDao.updateAvenger(avenger);
	}
	
	public boolean deleteAvenger(int id) {
		Avenger avenger = getAvenger(id);
		return avengerDao.deleteAvenger(avenger);
	}

}
