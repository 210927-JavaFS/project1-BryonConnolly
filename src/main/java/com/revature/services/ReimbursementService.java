package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDAOImplementation;



public class ReimbursementService {

	private ReimbursementDAO reimbursementDao = new ReimbursementDAOImplementation();

	public List<Reimbursement> getAllReimbursements() {
		return reimbursementDao.findAll();
	}

	public Reimbursement getReimbursement(int id) {
		Reimbursement reimbursement = reimbursementDao.findById(id);
		if (reimbursement != null) {
			return reimbursement;
		}else {
			return new Reimbursement();
		}
	}
	
	public boolean addReimbursement(Reimbursement reimbursement) {
		return reimbursementDao.addReimbursement(reimbursement);
	}
	
	public boolean updateReimbursement(Reimbursement reimbursement) {
		return reimbursementDao.updateReimbursement(reimbursement);
	}
	
	public boolean deleteReimbursement(int id) {
		Reimbursement reimbursement = getReimbursement(id);
		return reimbursementDao.deleteReimbursement(reimbursement);
	}

}
