package com.revature.repositories;

import java.util.List;

import com.revature.models.Book;

public interface BookDAO {
	
	public List<Book> getAllBooks();
	public Book getBookByISBN(int ISBN);
	public void insert(Book book);
	public void update(Book book);
	public void delete(Book book);

}
