package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Book;
import com.revature.models.Shelf;
import com.revature.repositories.BookDAO;
import com.revature.repositories.BookDAOImpl;
import com.revature.repositories.ShelfDAO;
import com.revature.repositories.ShelfDAOImpl;

public class Driver {
	
	private static ShelfDAO shelfDao = new ShelfDAOImpl();
	private static BookDAO bookDao = new BookDAOImpl();
	
	public static void main(String[] args) {

		
		Shelf shelf = new Shelf("brown", 25, new ArrayList<Book>());
		
		
		//shelf = shelfDao.getAll().get(0);
		
		Book book1 = new Book(1233425268, "Java for Dummies", "Tim G.", "fiction", 9001, null);
		Book book2 = new Book(4123, "Using Your Left Hand for Right-Handed People", 
				"Sir Lefty", "self-help", 9, null);
		
		bookDao.insert(book1);
		bookDao.insert(book2);
		shelfDao.insert(shelf);

		
		List<Book> bookList = bookDao.getAllBooks();
		List<Shelf> shelves = shelfDao.getAll();
		
		Book book3 = bookList.get(0);
		book3.setShelf(shelves.get(0));
		
		bookDao.update(book3);
		
		bookList = bookDao.getAllBooks();
		shelves = shelfDao.getAll();
		System.out.println(bookList);
		System.out.println(shelves);
		
		bookDao.delete(book3); //CASCADES to delete
		
		bookList = bookDao.getAllBooks();
		shelves = shelfDao.getAll();
		System.out.println(bookList);
		System.out.println(shelves);
		
	}

}
