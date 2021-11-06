package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String username;
	private String encrypted_password;
	private UserRole userRole;
	
	public User(String username, String encrypted_password, UserRole userRole) {
		super();
		this.username = username;
		this.encrypted_password = encrypted_password;
		this.userRole = userRole;
	}

	public String getEncryptedPassword() {
		return encrypted_password;
	}

	public User(int id, String username, String encrypted_password, UserRole userRole) {
		super();
		this.id = id;
		this.username = username;
		this.encrypted_password = encrypted_password;
		this.userRole = userRole;
	}


	public User(String username, String encrypted_password) {
		super();
		this.username = username;
		this.encrypted_password = encrypted_password;
		this.userRole = UserRole.getDefaultRole();
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEncryptedPassword(String encrypted_password) {
		this.encrypted_password = encrypted_password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, encrypted_password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(encrypted_password, other.encrypted_password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", encrypted_password=" + encrypted_password + ", role=" + role + "]";
	}


	
	

}
