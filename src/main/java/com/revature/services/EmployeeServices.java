package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.EmployeeDAO;

public class EmployeeServices {

	EmployeeDAO edao = new EmployeeDAO();
	
	public List<Reimbursement> getReimb(User u){
		return edao.getReimb(u);
	}
	
	public void insertReimb(Reimbursement r, User u) {
		//Timestamp date = new Timestamp(System.currentTimeMillis());
		//String d = date.toString();
		r.setReimb_author(u.getErs_users_id());
		//r.setReimb_submitted(d);
		edao.insertReimb(r);
	}
}
