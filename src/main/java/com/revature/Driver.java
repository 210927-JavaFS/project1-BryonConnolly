package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.Controller;
import com.revature.controllers.UserController;
import com.revature.controllers.LoginController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class Driver {
	
	private static Logger log = LoggerFactory.getLogger(Driver.class.getName());
	
	static {
		log.debug("Class Driver loaded into memory");
	}
	
	private static Javalin app;
	
//	private static ShelfDAO shelfDao = new ShelfDAOImpl();
//	private static BookDAO bookDao = new BookDAOImpl();
	
	public static void main(String[] args) {

		log.debug("in main");
	
//		    Javalin app = Javalin.create().start(7000);
//		    app.get("/", ctx -> ctx.result("Hello World"));

		
		//We first need to create a Javalin object and run the start method to start listening for HTTP requests.
		//start takes the port number as a param
//ok		app = Javalin.create().start(8080);
		

		
//		/*
//		 * This .get method will map GET requests to the endpoint that is given as the first Param to be handled
//		 * by the handler. There are methods for any of the HTTP methods/verbs. 
//		 */
//		app.get("/hello", (ctx)->{ctx.result("Hello Javalin! It's good to meet you on /hello "
//				+ "with a GET request");});
//		
//		app.get("/html", ctx->ctx.html("<h1>Hello Javalin! This should be HTML</h1>"));
//		
//		app.post("/hello", (ctx)->{ctx.result("Hello Javalin! It's good to meet you on /hello "
//				+ "with a POST request");
//				ctx.status(203);});
	
		
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		
		configure(new UserController(), new LoginController());
		
		app.start(8081);

		
		
		
		
		
/********		
		
		
		Shelf shelf = new Shelf("brown", 25, new ArrayList<Book>());
		
		
		//shelf = shelfDao.getAll().get(0);
		
		Book book1 = new Book(1233425268, "Java for Dummies", "Tim G.", "fiction", 9001, null);
		Book book2 = new Book(4123, "Using Your Left Hand for Right-Handed People", 
				"Sir Lefty", "self-help", 9, null);
		
		bookDao.insert(book1);
		bookDao.insert(book2);
		shelfDao.insert(shelf);

		
//		List<Book> bookList = bookDao.getAllBooks();
		List<Shelf> shelves = shelfDao.getAll();
		
//		Book book3 = bookList.get(0);
//		book3.setShelf(shelves.get(0));
		
//		bookDao.update(book3);
		
//		bookList = bookDao.getAllBooks();
		shelves = shelfDao.getAll();
//		System.out.println(bookList);
		System.out.println(shelves);
		
//		bookDao.delete(book3); //CASCADES to delete
		
//		bookList = bookDao.getAllBooks();
		shelves = shelfDao.getAll();
//		System.out.println(bookList);
//		System.out.println(shelves);
		
		
		******/
		
	}//end main

	private static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}
	
}
