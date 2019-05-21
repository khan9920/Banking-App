package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Banking.Dao.Connections;


public class DeleteCustomerService {
private String customerID;
	
	public void setCustomerID(String custID) {
		this.customerID = custID;
	}
	
	public void updateDB() {
		
		try {
			Connections con = new Connections();
			Connection conn = con.toConnect();
			
			Statement st = conn.createStatement();
			
			String sql = "DELETE FROM customer WHERE custID = '" + this.customerID + "'";
			
			ResultSet rslt = st.executeQuery(sql); 
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
