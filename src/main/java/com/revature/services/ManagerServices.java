package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ManagerDAO;

public class ManagerServices {
	
	ManagerDAO mdao = new ManagerDAO();
	
	public List<Reimbursement> allReimb(){
		return mdao.allReimb();
	}
	
	public void approveReimb(Reimbursement r, User u) {
		mdao.approveReimb(r, u);
	}
	
	public void rejectReimb(Reimbursement r) {
		mdao.rejectReimb(r);
	}
	
	public Reimbursement reimb(Reimbursement r) {
		return mdao.reimb(r);
	}
}
