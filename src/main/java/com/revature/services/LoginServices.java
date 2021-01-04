package com.revature.services;

import com.revature.models.Credential;
import com.revature.models.User;
import com.revature.repositories.LoginDAO;

public class LoginServices {
	LoginDAO ldao = new LoginDAO();
	
	public User getUser(Credential c) {
		User u = ldao.getUser(c);
		return u;
	}
}
