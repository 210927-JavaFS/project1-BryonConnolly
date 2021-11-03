package com.revature.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.services.LoginService;

/*import com.revature.models.Author;
import com.revature.models.Book;
import com.revature.models.Genre;
import com.revature.models.Language;*/

public class DaoTest {
	

	public static UserDAO userDAO = new UserDAOImplementation();
	public static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImplementation();



	public static void main(String[] args) {
		
		UserRole role = new UserRole(0,"Employee");
		UserRole roleX = new UserRole(1, "Finance Manager");		
		
		String username = "employee1";
		String encrypted_password = new LoginService().encryptPassword("password"); 
		
		User user = new User(username, encrypted_password, role);
		System.out.println(user);
		
		userDAO.updateUser(user);
		
		
		reimbursementDAO.insert(new Reimbursement(1,1,1));
		
		
		
//		Author ray = new Author("not ray", "Bradbury", 1920, new Language(1, "English"), null);
		
//		Author author = authorDao.findByName(ray);
		
//		System.out.println(author);
//		Language lang = bookDao.getLanguage(1);
//		System.out.println(lang);
//		author.setNativeLanguage(lang);
//		author.setFirstName("not ray");
//		authorDao.updateAuthor(author);
		
		
		//bookDao.insert(new Book(author, new Genre(1, "Sci-fi"), "Fahrenheit 451", 
		//		Timestamp.valueOf(LocalDateTime.now()), new Language(1, "English")));

	}

}
