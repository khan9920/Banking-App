package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.Banking.Dao.*;

public class Login extends Connections{
	
	Connection con = super.toConnect();
	private Statement st;
	private String sql;
	private ResultSet rs;
	
	public ResultSet adminLogin() throws SQLException{
		st = conn.createStatement();
		sql = "SELECT * FROM admin";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet custLogin() throws SQLException{
		st = conn.createStatement();
		sql = "SELECT * FROM customer c, bankAccount b where c.accountNumber = b.accountNo";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet empLogin() throws SQLException{
		st = conn.createStatement();
		sql = "SELECT * FROM Employee";
		rs = st.executeQuery(sql);
		return rs;
	}
}
