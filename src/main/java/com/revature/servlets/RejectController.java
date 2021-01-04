package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ManagerServices;

public class RejectController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper om = new ObjectMapper();
		
		ManagerServices ms = new ManagerServices();
		
		Reimbursement r = new Reimbursement();
		
		r = om.readValue(req.getInputStream(), Reimbursement.class);
		
		ms.rejectReimb(r);
	}

}
