package com.worldbank.dao;

import java.sql.*;

public class DisplayBankBalance extends DbConnection {
	
	private String custID;
	
	public void setCustomerID(String CustID) {
		this.custID = CustID;
	}
	
	
	Connection conn = super.toConnect(); //connecting to database
	
	public ResultSet Display() throws SQLException {
		
		String sql = "SELECT * FROM customer WHERE custID = 'C122972' ";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		
		return rslt;	
	}
}