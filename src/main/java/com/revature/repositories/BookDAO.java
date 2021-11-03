package com.revature.repositories;

import java.util.List;

import com.revature.models.Book;
import com.revature.models.Language;

public interface BookDAO {
	
	public List<Book> findAll();
	public Book findById(int id);
	public boolean updateBook(Book book);
	public boolean insert(Book book);
	public Language getLanguage(int id);

}
