package com.worldbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.worldbank.dao.DbConnection;

public class LoginCustomer {
	DbConnection con = new DbConnection();
	Connection conn = con.toConnect();
	
	public boolean checkCust(String bankID, String pass) throws SQLException{
		
		Statement st = conn.createStatement();
		String sql = "SELECT custID, password FROM customer";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) { // loop through the results of the query
			if(bankID.equals(rs.getString("custID")) && pass.equals(rs.getString("password"))) {
				return true;
				}
		}
		return false;
	}
}
