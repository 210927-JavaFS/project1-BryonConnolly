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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusNumber;
	private String name;
//	@OneToMany(fetch=FetchType.EAGER)/*mappedBy determines the field that is representing the relationship fetch determines if the object is pulled direction (EAGER) or if a proxy is returned first (LAZY).*/
	private List<Reimbursement> reimbursements;
	
public ReimbursementStatus(int statusNumber, String name, List<Reimbursement> reimbursements) {
	super();
	this.statusNumber = statusNumber;
	this.name = name;
	this.reimbursements = reimbursements;
}

public ReimbursementStatus(String name, List<Reimbursement> reimbursements) {
	super();
	this.name = name;
	this.reimbursements = reimbursements;
}

public ReimbursementStatus() {
	super();
}

public int getStatusNumber() {
	return statusNumber;
}

public void setStatusNumber(int statusNumber) {
	this.statusNumber = statusNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Reimbursement> getReimbursements() {
	return reimbursements;
}

public void setReimbursements(List<Reimbursement> reimbursements) {
	this.reimbursements = reimbursements;
}

@Override
public int hashCode() {
	return Objects.hash(name, reimbursements, statusNumber);
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
	return Objects.equals(name, other.name) && Objects.equals(reimbursements, other.reimbursements)
			&& statusNumber == other.statusNumber;
}

@Override
public String toString() {
	return "ReimbursementStatus [statusNumber=" + statusNumber + ", name=" + name + ", reimbursements=" + reimbursements
			+ "]";
}
	
	
	
	
	
}
