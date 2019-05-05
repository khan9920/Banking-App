package com.worldbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayBanker extends DbConnection {

	Connection conn = super.toConnect(); //connecting to database
	
	public ResultSet Display() throws SQLException {
		
		String sql = "SELECT * FROM Employee";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		
		return rslt;	
	}
}
