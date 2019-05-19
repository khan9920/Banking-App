package com.Banking.service;

import java.sql.*;

import com.Banking.Dao.*;

public class TransactionService {
	
	private String custDAOID;
	private double calcualtedBalance;
	
	public void setCustID(String CustID) {
		this.custDAOID = CustID;
	}
	
	public void setCalculatedBalance(double CalculatedBalance) {
		this.calcualtedBalance = CalculatedBalance;
	}

	Connections con = new Connections();
	Connection conn = con.toConnect();
	
	public ResultSet getBankBalance() throws SQLException {
		
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	public void updateSenderDB() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " UPDATE bankAccount SET cBalance = '"+this.calcualtedBalance+"' WHERE customerID='"+this.custDAOID+"'";
		st.executeUpdate(sql);
	}
	
	public void updateTransactionDB() throws SQLException{
		Statement st = conn.createStatement();
		String sql = "INSERT INTO payments "
	}
	
}
