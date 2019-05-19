package com.Banking.service;
import java.sql.*;

import com.Banking.util.DBconnection;

public class cBankLogin {
	
	
public boolean checkBankLog(String bankID, String pass) throws SQLException{
	    Connection conn = DBconnection.createConnection();
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
