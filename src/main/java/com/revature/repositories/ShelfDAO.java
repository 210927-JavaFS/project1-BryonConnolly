package com.revature.repositories;

import java.util.List;

import com.revature.models.Shelf;

public interface ShelfDAO {
	
	public List<Shelf> getAll();
	public Shelf getShelf(int shelfNumber);
	public void insert(Shelf shelf);
	public void update(Shelf shelf);
	public void delete(Shelf shelf);

}
