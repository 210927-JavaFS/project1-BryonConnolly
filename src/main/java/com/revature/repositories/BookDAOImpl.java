package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Book;
import com.revature.models.Language;
import com.revature.utils.HibernateUtil;

public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> findAll() {
		Session session = HibernateUtil.getSession();
		List<Book> list = session.createQuery("FROM Book").list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public Book findById(int id) {
		Session session = HibernateUtil.getSession();
		Book book = session.get(Book.class, id);
		HibernateUtil.closeSession();
		return book;
	}

	@Override
	public boolean updateBook(Book book) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(book);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean insert(Book book) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(book);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public Language getLanguage(int id) {
		Session session = HibernateUtil.getSession();
		Language lang = session.get(Language.class, id);
		HibernateUtil.closeSession();
		return lang;
	}

}
