package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> findAll();
	public Reimbursement findById(int id);
	public boolean updateReimbursement(Reimbursement reimbursement);
	public Reimbursement findByStatus(Reimbursement reimbursement);
	public Reimbursement findByType(Reimbursement reimbursement);	
	public boolean insert(Reimbursement reimbursement);
	
	
}
