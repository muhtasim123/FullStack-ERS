package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ManagerServices;

public class ApproveController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper om = new ObjectMapper();
		
		ManagerServices ms = new ManagerServices();
		
		Reimbursement r = new Reimbursement();
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("currUser");
		
		r = om.readValue(req.getInputStream(), Reimbursement.class);
		
		ms.approveReimb(r, u);
	}

}
