package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeServices;

public class ListAllController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("currUser");
		
		EmployeeServices es = new EmployeeServices();
		List<Reimbursement> reimbList = es.getReimb(u);
		resp.setStatus(200);
		resp.getWriter().write(om.writeValueAsString(reimbList));
		
	}
}
