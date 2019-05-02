package com.bank.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Searchcust extends Connections{

	
	Connection con = super.toConnect();
	public ResultSet searchResult(String search) throws SQLException {
		String sql = "SELECT * FROM customer WHERE fullname LIKE '%" + search + "%'";
//		String sql = "SELECT * FROM customer";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		return rs;
	}
	
}
