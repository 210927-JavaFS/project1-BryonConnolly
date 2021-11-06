package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.revature.models.User;
import com.revature.models.UserDTO;

public class NewUserService {
	
	private UserDAO userDao = new UserDAO();
	
	private static Logger log = LoggerFactory.getLogger(NewUserService.class.getName());

	public boolean createUser(UserDTO userDto) {
		
		User existing_user = userDao.getByUsername(userDto.username);
		
		if(existing_user!=null) {
			log.error("Username "+userDto.username+" Not Available");
			return false;
		}

		User new_user = new User(;)
		
	}
	
	public String encryptPassword(String password) {
		log.debug("In LoginService.encryptPassword(String password)");
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder.encode(password);
		
	}
		
	
}
