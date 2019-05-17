package com.worldbank.dao;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteBanker {
	
	private String bankerID;
	
	public void setBankerID(String bankID) {
		this.bankerID = bankID;
	}
	
	public void updateDB() {
		
		try {
			DbConnection con = new DbConnection();
			Connection conn = con.toConnect();
			
			Statement st = conn.createStatement();
			
			String sql = "DELETE FROM Employee WHERE EmpID = '" + this.bankerID + "'";
			
			st.executeUpdate(sql);
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
