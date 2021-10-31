package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Shelf;
import com.revature.utils.HibernateUtil;

public class ShelfDAOImpl implements ShelfDAO{

	@Override
	public List<Shelf> getAll() {
		Session session = HibernateUtil.getSession();
		
		List<Shelf> shelves = session.createQuery("FROM Shelf").list(); //HQL
		
		
		return shelves;
	}

	@Override
	public Shelf getShelf(int shelfNumber) {
		Session session = HibernateUtil.getSession();
		Shelf shelf = session.get(Shelf.class, shelfNumber);
		return shelf;
	}

	@Override
	public void insert(Shelf shelf) {
		Session session = HibernateUtil.getSession();
		session.save(shelf);
		HibernateUtil.closeSession();
	}

	@Override
	public void update(Shelf shelf) {
		Session session = HibernateUtil.getSession();
		session.merge(shelf);
		HibernateUtil.closeSession();
	}

	@Override
	public void delete(Shelf shelf) {
		Session session = HibernateUtil.getSession();
		session.delete(shelf);
		HibernateUtil.closeSession();		
	}

}
