package com.revature.models;

import java.util.List;

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
	@OneToMany(mappedBy="status", fetch=FetchType.EAGER)/*mappedBy determines the field that is representing the relationship
	 fetch determines if the object is pulled direction (EAGER) or if a proxy is returned first (LAZY).*/
	private List<Reimbursement> reimbursements;
	
	
}
