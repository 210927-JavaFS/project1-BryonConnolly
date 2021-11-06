package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Avenger;
import com.revature.utils.HibernateUtil;

public class AvengerDAOImpl implements AvengerDAO{
	
	@Override
	public List<Avenger> findAllAvengers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM Avenger").list();
	}

	@Override
	public Avenger findById(int id) {
		Session session = HibernateUtil.getSession();
		return session.get(Avenger.class, id);
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(avenger);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAvenger(Avenger avenger) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(avenger);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAvenger(Avenger avenger) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(avenger);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
