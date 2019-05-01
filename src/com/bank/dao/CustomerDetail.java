package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CustomerDetail{

	public ResultSet custDetails(String bankID) throws SQLException {
		Connections connect = new Connections();
		Connection conn = connect.toConnect();
		String sql = "SELECT accountNo, cBalance, fullname FROM bankAccount, customer WHERE customerID = '" + bankID + "' and custID = '" + bankID + "'";
//		String sql = "SELECT * FROM bankAccount WHERE customerID = '?'";
//		String sql = "SELECT  accountNo, cBalance from bankAccount WHERE customerID =" + bankID;
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);
		return rs;
			
	}
}
