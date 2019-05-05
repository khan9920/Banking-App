package com.worldbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAdmin extends DbConnection {
	
	Connection conn = super.toConnect();
	
	public ResultSet Display() throws SQLException {
		
		String sql = "SELECT * FROM admin";
		Statement st = conn.createStatement();
		ResultSet rslt = st.executeQuery(sql); 
		
		return rslt;	
	}	
}
