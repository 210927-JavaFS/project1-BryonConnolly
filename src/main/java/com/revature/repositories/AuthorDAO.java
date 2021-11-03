package com.revature.repositories;

import java.util.List;

import com.revature.models.Author;

public interface AuthorDAO {
	
	public List<Author> findAll();
	public Author findById(int id);
	public boolean updateAuthor(Author author);
	public Author findByName(Author author);
	public boolean insert(Author author);

}
