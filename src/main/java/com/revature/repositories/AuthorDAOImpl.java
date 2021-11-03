package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Author;
import com.revature.utils.HibernateUtil;

public class AuthorDAOImpl implements AuthorDAO {

	@Override
	public List<Author> findAll() {
		Session session = HibernateUtil.getSession();
		List<Author> list = session.createQuery("FROM Author").list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public Author findById(int id) {
		Session session = HibernateUtil.getSession();
		Author author = session.get(Author.class, id);
		HibernateUtil.closeSession();
		return author;
	}

	@Override
	public boolean updateAuthor(Author author) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(author);
			tx.commit();
			return true;
		}catch (HibernateException e) {
			return false;
		}finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public Author findByName(Author author) {
		Session session = HibernateUtil.getSession();
		 Query query = session.createQuery("FROM Author WHERE firstName = ?1 AND lastName = ?2");
		 query.setParameter(1, author.getFirstName());
		 query.setParameter(2, author.getLastName());
		 List<Author> list	=	query.list();
		author = list.get(0);
		HibernateUtil.closeSession();
		return author;
	}

	@Override
	public boolean insert(Author author) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(author);
			tx.commit();
			return true;
		}catch (HibernateException e) {
			return false;
		}finally {
			HibernateUtil.closeSession();
		}
	}

}
