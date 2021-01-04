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

public class ManagerDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<Reimbursement> allReimb(){
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		
		Connection conn = cf.getConnection();
		
		String sql = "select * from \"ers_reimbursement\" where \"reimb_status_id\" = 3";

		try {
			PreparedStatement selectAll = conn.prepareStatement(sql);
			
			ResultSet res = selectAll.executeQuery();
			
			while(res.next()) {
				Reimbursement r = new Reimbursement();
				
				r.setReimb_id(res.getInt("reimb_id"));
				r.setReimb_amount(res.getInt("reimb_amount"));
				r.setReimb_submitted(res.getString("reimb_submitted"));
				r.setReimb_resolved(res.getString("reimb_resolved"));
				r.setReimb_description(res.getString("reimb_description"));
				r.setReimb_receipt(res.getString("reimb_receipt"));
				r.setReimb_author(res.getInt("reimb_author"));
				r.setReimb_resolver(res.getInt("reimb_resolver"));
				r.setReimb_status_id(res.getInt("reimb_status_id"));
				r.setReimb_type_id(res.getInt("reimb_type_id"));
				
				all.add(r);
			}
			
			return all;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void approveReimb(Reimbursement r, User u) {
		
		Connection conn = cf.getConnection();
		
		String sql = "update \"ers_reimbursement\" set \"reimb_status_id\" = 1, \"reimb_resolver\" = ? where \"reimb_id\" = ?;";
		
		try {
			PreparedStatement approve = conn.prepareStatement(sql);
			
			approve.setInt(1, u.getErs_users_id());
			approve.setInt(2, r.getReimb_id());
			
			approve.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rejectReimb(Reimbursement r) {
		
		Connection conn = cf.getConnection();
		
		String sql = "update \"ers_reimbursement\" set \"reimb_status_id\" = 2 where \"reimb_id\" = ?;";
		
		try {
			PreparedStatement approve = conn.prepareStatement(sql);
			
			approve.setInt(1, r.getReimb_id());
			
			approve.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Reimbursement reimb(Reimbursement r) {
		
		Connection conn = cf.getConnection();
		
		String sql = "select * from \"ers_reimbursement\" where \"reimb_id\" = ?;";
		
		try {
			
			PreparedStatement find = conn.prepareStatement(sql);
			
			find.setInt(1, r.getReimb_id());
			
			ResultSet res = find.executeQuery();

			Reimbursement newR = new Reimbursement();
			
			while(res.next()) {
				
				newR.setReimb_id(res.getInt("reimb_id"));
				newR.setReimb_amount(res.getInt("reimb_amount"));
				newR.setReimb_submitted(res.getString("reimb_submitted"));
				newR.setReimb_resolved(res.getString("reimb_resolved"));
				newR.setReimb_description(res.getString("reimb_description"));
				newR.setReimb_receipt(res.getString("reimb_receipt"));
				newR.setReimb_author(res.getInt("reimb_author"));
				newR.setReimb_resolver(res.getInt("reimb_resolver"));
				newR.setReimb_status_id(res.getInt("reimb_status_id"));
				newR.setReimb_type_id(res.getInt("reimb_type_id"));
			}

			return newR;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
