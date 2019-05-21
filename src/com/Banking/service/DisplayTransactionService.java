package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.Dao.Connections;

public class DisplayTransactionService extends Connections {
	
	Connection conn = super.toConnect(); //connecting to database
	
	public ResultSet Display(String CustID) throws SQLException {
		
		String sql = "SELECT * FROM bankAccount WHERE customerID = '"+CustID+"' ";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		
		return rslt;	
	}
	
	public ResultSet DisplayTransaction(String AccNo) throws SQLException {
		String sql = "SELECT * FROM transactions WHERE senderAccNo = '"+AccNo+"' ";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		return rslt;
	}

}
