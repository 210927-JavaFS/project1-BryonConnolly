package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Home;
import com.revature.utils.HibernateUtil;

public class HomeDAOImpl implements HomeDAO {

	@Override
	public List<Home> findAllHomes() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM Home").list();
	}

	@Override
	public Home findByName(String name) {
		Session session = HibernateUtil.getSession();
		return session.get(Home.class, name);
	}

	@Override
	public boolean addHome(Home home) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(home);
			tx.commit();
			//HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateHome(Home home) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(home);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteHome(Home home) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(home);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
