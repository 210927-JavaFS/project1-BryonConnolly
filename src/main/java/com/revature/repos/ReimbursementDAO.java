package com.revature.repos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.UserWAS;
import com.revature.utils.HibernateUtil;

public interface ReimbursementDAO {

	public List<Reimbursement> findAll();
	public Reimbursement findById(int id);
	public List<Reimbursement> findByStatus(Reimbursement reimbursement);
	public List<Reimbursement> findByType(Reimbursement reimbursement);	
	public ReimbursementType getReimbursementType(int id);
	public ReimbursementStatus getReimbursementStatus(int id);
	
	
	boolean addReimbursement(Reimbursement reimbursement);
	boolean updateReimbursement(Reimbursement reimbursement);
	boolean deleteReimbursement(Reimbursement reimbursement);
	
}
