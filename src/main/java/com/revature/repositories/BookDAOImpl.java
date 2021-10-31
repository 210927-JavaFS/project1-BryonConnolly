package com.revature.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Book;
import com.revature.utils.HibernateUtil;

public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		Session session = HibernateUtil.getSession();
		
		List<Book> list;
		
		CriteriaBuilder critBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Book> query = critBuilder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		CriteriaQuery<Book> allBooks = query.select(root);
		TypedQuery<Book> typed = session.createQuery(allBooks);

		list = typed.getResultList();
		return list;
	}

	@Override
	public Book getBookByISBN(int ISBN) {
		Session session = HibernateUtil.getSession();
		Book book = session.get(Book.class, ISBN);
		return book;
	}

	@Override
	public void insert(Book book) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(book);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void update(Book book) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(book);
		tx.commit();
		//HibernateUtil.closeSession();
		
		

	}

	@Override
	public void delete(Book book) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(book);
		tx.commit();
		HibernateUtil.closeSession();
	}

	

}
