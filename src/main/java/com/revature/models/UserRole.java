package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRole {
	
	@Id
	private String name;
	
	public UserRole(String name) {
		super();
		this.name = name;
	}
	public UserRole() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserRole [name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	
}
