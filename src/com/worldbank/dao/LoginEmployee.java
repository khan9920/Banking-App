package com.worldbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginEmployee {
	DbConnection con = new DbConnection();
	Connection conn = con.toConnect();

	public boolean checkEmp(String bankID, String pass) throws SQLException{
		
		Statement st = conn.createStatement();
		String sql = "SELECT empID, password FROM Employee";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) { // loop through the results of the query
			if(bankID.equals(rs.getString("empID")) && pass.equals(rs.getString("password"))) {
				return true;
				} else {
					return false;
					}
			}
		return false;
	}
}
