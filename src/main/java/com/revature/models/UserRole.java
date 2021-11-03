package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRole {
	
	@Id
	private int id;
	private String name;
	public UserRole(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UserRole() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return id == other.id && Objects.equals(name, other.name);
	}
	
	
	
	
}
