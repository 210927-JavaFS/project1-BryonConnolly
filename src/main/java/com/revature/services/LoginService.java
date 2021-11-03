package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.revature.Driver;
import com.revature.models.User;
import com.revature.models.UserDTO;

public class LoginService {
	
	private UserDAO userDao = new UserDAO();
	
	private static Logger log = LoggerFactory.getLogger(LoginService.class.getName());

	public boolean login(UserDTO userDto) {
		User user = userDao.getByUsername(userDto.username);
		
//		if(user!=null && (userDto.password.hashCode()==user.getPassword())) {
//			return true;
//		}
		
		if(user!=null && checkPassword(user, userDto.password)) {
			return true;
		}
		
		return false;
	}
	
	
	boolean checkPassword(User user, String password) {
		
		log.debug("In LoginService.checkPassword(User,Password)");
		log.debug("user.getEncryptedPassword() = "+user.getEncrypted_password());
		log.debug("parameter arg password is : "+password);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
				
		if(encoder.matches(password, user.getEncrypted_password()))
			return true;
		else {
			System.out.println("password does not match");
			return false;
		}
	}//end checkPassword
	
	String encryptPassword(String password) {
		log.debug("In LoginService.encryptPassword(String password)");
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder.encode(password);
		
	}
	
	
	
}
