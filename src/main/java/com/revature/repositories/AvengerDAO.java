package com.revature.repositories;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerDAO {
	
	List<Avenger> findAllAvengers();
	Avenger findById(int id);
	boolean addAvenger(Avenger avenger);
	boolean updateAvenger(Avenger avenger);
	boolean deleteAvenger(Avenger avenger);

}
