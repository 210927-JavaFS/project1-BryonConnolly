package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.UserWAS;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAOImplementation implements ReimbursementDAO{

	@Override
	public List<Reimbursement> findAll() {
		Session session = HibernateUtil.getSession();
		List<Reimbursement> list = session.createQuery("FROM Reimbursement").list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public Reimbursement findById(int id) {
		Session session = HibernateUtil.getSession();
		Reimbursement reimbursement = session.get(Reimbursement.class, id);
		HibernateUtil.closeSession();
		return reimbursement;
	}


	@Override
	public List<Reimbursement> findByStatus(Reimbursement reimbursement) {
		Session session = HibernateUtil.getSession();
		 Query query = session.createQuery("FROM Reimbursement WHERE statusNumber = ?");
		 query.setParameter(1, reimbursement.getType());
		 List<Reimbursement> list	=	query.list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public List<Reimbursement> findByType(Reimbursement reimbursement) {
		Session session = HibernateUtil.getSession();
		 Query query = session.createQuery("FROM Reimbursement WHERE typeNumber = ?");
		 query.setParameter(1, reimbursement.getType());
		 List<Reimbursement> list	=	query.list();
		HibernateUtil.closeSession();
		return list;
	}

	
	public ReimbursementType getReimbursementType(int id) {
		Session session = HibernateUtil.getSession();
		ReimbursementType reimbursementType = session.get(ReimbursementType.class, id);
		HibernateUtil.closeSession();
		return reimbursementType;
	}
	
	public ReimbursementStatus getReimbursementStatus(int id) {
		Session session = HibernateUtil.getSession();
		ReimbursementStatus reimbursementStatus = session.get(ReimbursementStatus.class, id);
		HibernateUtil.closeSession();
		return reimbursementStatus;
	}
	
	
	
	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reimbursement);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(reimbursement);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(reimbursement);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}
