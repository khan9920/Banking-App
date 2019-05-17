package com.worldbank.dao;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteAdmin {

	private String adminID;
	
	public void setAdminID(String adID) {
		this.adminID = adID;
	}
	
	public void updateDB() {
		try {
			DbConnection con = new DbConnection();
			Connection conn = con.toConnect();
			
			Statement st = conn.createStatement();
			
			String sql = "DELETE FROM admin WHERE adminID = '" + this.adminID + "'";
			
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	
}
