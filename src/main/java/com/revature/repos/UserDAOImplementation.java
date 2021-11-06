package com.revature.repos;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserDAOImplementation implements UserDAO{

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSession();
		List<User> list = session.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public User findById(int id) {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, id);
		HibernateUtil.closeSession();
		return user;
	}


	@Override
	public User findByUsername(String username) {
		Session session = HibernateUtil.getSession();
		 Query query = session.createQuery("FROM User WHERE username = ?");
		 query.setParameter(1, username);
		 List<User> list	=	query.list();
		HibernateUtil.closeSession();
		return list.get(0);    //Todo this is from example but maybe should ensure no duplicate usernames and give error if so
	}

	@Override
	public User findByUsername(User user) {
		Session session = HibernateUtil.getSession();
		 Query query = session.createQuery("FROM User WHERE username = ?");
		 query.setParameter(1, user.getUsername());
		 List<User> list	=	query.list();
		user = list.get(0);    //Todo this is from example but maybe should ensure no duplicate usernames and give error if so
		HibernateUtil.closeSession();
		return user;
	}

	
	public UserRole getUserRole(int id) {
		Session session = HibernateUtil.getSession();
		UserRole role = session.get(UserRole.class, id);
		HibernateUtil.closeSession();
		return role;
	}
		
	
	
	@Override
	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(user);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	

}
