package com.Banking.service;

import java.sql.*;

import com.Banking.Dao.*;

public class TransactionService {
	
	private String custDAOID;
	
	public void setCustID(String CustID) {
		this.custDAOID = CustID;
	}

	Connections con = new Connections();
	Connection conn = con.toConnect();
	
	public ResultSet getBankBalance() throws SQLException {
		
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}	
}
