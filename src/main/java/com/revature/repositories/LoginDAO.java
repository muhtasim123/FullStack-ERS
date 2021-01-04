package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Credential;
import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

public class LoginDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
			
	public User getUser(Credential c) {
		Connection conn = cf.getConnection();
		
		String sql = "select * from \"ers_users\" where \"ers_username\" = ? and \"ers_password\" = ?;";
		
		try {
			PreparedStatement login = conn.prepareStatement(sql);
			login.setString(1, c.getUsername());
			login.setString(2, c.getPassword());
			
			ResultSet res = login.executeQuery();
			User u = new User();
			
			while(res.next()) {
				u.setErs_users_id(res.getInt("ers_users_id"));
				u.setErs_username(res.getString("ers_username"));
				u.setErs_password(res.getString("ers_password"));
				u.setUser_first_name(res.getString("user_first_name"));
				u.setUser_last_name(res.getString("user_last_name"));
				u.setUser_email(res.getString("user_email"));
				u.setUser_role_id(res.getInt("user_role_id"));
			}
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
