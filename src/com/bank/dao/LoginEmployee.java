package com.bank.dao;

import java.sql.*;



public class LoginEmployee{
	
	Connections con = new Connections();
	Connection conn = con.toConnect();

	public boolean checkEmp(String bankID, String pass) throws SQLException{
		
		Statement st = conn.createStatement();
		String sql = "SELECT empID, password FROM Employee";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) { // loop through the results of the query
			if(bankID.equals(rs.getString("empID")) && pass.equals(rs.getString("password"))) {
				return true;
				
			}else {
				return false;
		}
	}
		return false;
	}
}