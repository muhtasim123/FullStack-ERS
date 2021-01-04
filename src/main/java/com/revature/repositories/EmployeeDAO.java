package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

public class EmployeeDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<Reimbursement> getReimb(User u){
		
		List<Reimbursement> listReimb = new ArrayList<Reimbursement>();
		
		Connection conn = cf.getConnection();
		
		String sql = "select * from \"ers_reimbursement\" where \"reimb_author\" = ?;";
		
		try {
			PreparedStatement allReimb = conn.prepareStatement(sql);
			allReimb.setInt(1, u.getErs_users_id());
			
			ResultSet res = allReimb.executeQuery();
			
			while(res.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setReimb_id(res.getInt("reimb_id"));
				reimb.setReimb_amount(res.getInt("reimb_amount"));
				reimb.setReimb_submitted(res.getString("reimb_submitted"));
				reimb.setReimb_resolved(res.getString("reimb_resolved"));
				reimb.setReimb_description(res.getString("reimb_description"));
				reimb.setReimb_receipt(res.getString("reimb_receipt"));
				reimb.setReimb_author(res.getInt("reimb_author"));
				reimb.setReimb_resolver(res.getInt("reimb_resolver"));
				reimb.setReimb_status_id(res.getInt("reimb_status_id"));
				reimb.setReimb_type_id(res.getInt("reimb_type_id"));
				
				listReimb.add(reimb);
			}
			
			return listReimb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void insertReimb(Reimbursement r) {
		Connection conn = cf.getConnection();
		
		String sql = "insert into \"ers_reimbursement\" (\"reimb_amount\", \"reimb_submitted\", \"reimb_description\", \"reimb_status_id\", \"reimb_type_id\", \"reimb_author\")"
				+ "	values (?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement insert = conn.prepareStatement(sql);
			
			insert.setInt(1, r.getReimb_amount());
			insert.setString(2, r.getReimb_submitted());
			insert.setString(3, r.getReimb_description());
			insert.setInt(4, 3);
			insert.setInt(5, r.getReimb_type_id());
			insert.setInt(6, r.getReimb_author());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

}
