package com.revature.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.revature.models.Author;
import com.revature.models.Book;
import com.revature.models.Genre;
import com.revature.models.Language;

public class DaoTest {
	
	public static BookDAO bookDao = new BookDAOImpl();
	public static AuthorDAO authorDao = new AuthorDAOImpl();

	public static void main(String[] args) {
		
		Author ray = new Author("not ray", "Bradbury", 1920, new Language(1, "English"), null);
		
		Author author = authorDao.findByName(ray);
		
		System.out.println(author);
//		Language lang = bookDao.getLanguage(1);
//		System.out.println(lang);
//		author.setNativeLanguage(lang);
//		author.setFirstName("not ray");
//		authorDao.updateAuthor(author);
		
		
		//bookDao.insert(new Book(author, new Genre(1, "Sci-fi"), "Fahrenheit 451", 
		//		Timestamp.valueOf(LocalDateTime.now()), new Language(1, "English")));

	}

}
