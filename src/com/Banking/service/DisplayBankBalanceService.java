package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.Dao.Connections;

public class DisplayBankBalanceService extends Connections {
	
	private String custID;
	
	public void setCustomerID(String CustID) {
		this.custID = CustID;
	}
	
	
	Connection conn = super.toConnect(); //connecting to database
	
	public ResultSet Display() throws SQLException {
		
		String sql = "SELECT * FROM bankAccount WHERE customerID = 'C458983' ";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		
		return rslt;	
	}

}
