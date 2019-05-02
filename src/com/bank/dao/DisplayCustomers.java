package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayCustomers extends Connections{
	Connection con = super.toConnect();
	public ResultSet Display(String date) throws SQLException {
		String sql = "SELECT * FROM customer WHERE createDate ='" + date + "'";
//		String sql = "SELECT * FROM customer";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

}
