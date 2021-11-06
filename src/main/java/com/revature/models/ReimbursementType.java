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
public class ReimbursementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeNumber;
	private String name;
//	@OneToMany(mappedBy="type", fetch=FetchType.EAGER)/*mappedBy determines the field that is representing the relationship	 fetch determines if the object is pulled direction (EAGER) or if a proxy is returned first (LAZY).*/
	private List<Reimbursement> reimbursements;
	
public ReimbursementType(int typeNumber, String name, List<Reimbursement> reimbursements) {
	super();
	this.typeNumber = typeNumber;
	this.name = name;
	this.reimbursements = reimbursements;
}

public ReimbursementType(String name, List<Reimbursement> reimbursements) {
	super();
	this.name = name;
	this.reimbursements = reimbursements;
}

public ReimbursementType() {
	super();
}

public int getTypeNumber() {
	return typeNumber;
}

public void setTypeNumber(int typeNumber) {
	this.typeNumber = typeNumber;
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
	return Objects.hash(name, reimbursements, typeNumber);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ReimbursementType other = (ReimbursementType) obj;
	return Objects.equals(name, other.name) && Objects.equals(reimbursements, other.reimbursements)
			&& typeNumber == other.typeNumber;
}

@Override
public String toString() {
	return "ReimbursementType [typeNumber=" + typeNumber + ", name=" + name + ", reimbursements=" + reimbursements
			+ "]";
}

	
	
}
