package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class UserWAS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(nullable=false)
	private String username;
	private String encrypted_password;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private UserRole role;
	@OneToMany(mappedBy="shelf", fetch=FetchType.EAGER)/*mappedBy determines the field that is representing the relationship
	 fetch determines if the object is pulled direction (EAGER) or if a proxy is returned first (LAZY).*/
	private List<Reimbursement> reimbursements;
	
	
	// Setup and begin Logging
	private static final String CLASS_NAME 			= UserWAS.class.getName();
	private static final String CLASS_SIMPLE_NAME	= UserWAS.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	
	public UserWAS() {
		super();
	}


	public UserWAS(String username, String encrypted_password, UserRole role) {
		super();
		this.username = username;
		this.encrypted_password = encrypted_password;
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEncrypted_password() {
		return encrypted_password;
	}


	public void setEncrypted_password(String encrypted_password) {
		this.encrypted_password = encrypted_password;
	}


	public UserRole getRole() {
		return role;
	}


	public void setRole(UserRole role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(encrypted_password, role, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserWAS other = (UserWAS) obj;
		return encrypted_password == other.encrypted_password && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", encrypted_password=" + encrypted_password + ", role=" + role + "]";
	}


	

}