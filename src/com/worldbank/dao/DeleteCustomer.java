package com.worldbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteCustomer {

	private String customerID;
	
	public void setCustomerID(String custID) {
		this.customerID = custID;
	}
	
	public void updateDB() {
		
		try {
			DbConnection con = new DbConnection();
			Connection conn = con.toConnect();
			
			Statement st = conn.createStatement();
			
			String sql = "DELETE FROM customer WHERE custID = '" + this.customerID + "'";
			
			ResultSet rslt = st.executeQuery(sql); 
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
