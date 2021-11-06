package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ReimbursementStatus {

	@Id
	private String name;

public ReimbursementStatus(String name) {
	super();
	this.name = name;
}

public ReimbursementStatus() {
	super();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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
	ReimbursementStatus other = (ReimbursementStatus) obj;
	return Objects.equals(name, other.name);
}

@Override
public String toString() {
	return "ReimbursementStatus [name=" + name + "]";
}
	
	
	
	
	
}
