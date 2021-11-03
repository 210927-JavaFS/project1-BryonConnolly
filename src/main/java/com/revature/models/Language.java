package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language {
	
	@Id
	private int id;
	private String name;
	
	
	public Language(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Language() {
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
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Language)) {
			return false;
		}
		Language other = (Language) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
	
	

}
