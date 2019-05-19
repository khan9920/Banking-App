package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.Dao.*;

public class UserDetails extends Connections{

	Connection con = super.toConnect();
	private Statement st;
	private String sql;
	private ResultSet rs;
	
	public ResultSet customerDetails() throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM customer c, bankAccount b where c.custID = b.customerID";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet empDetail() throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM Employee";
		rs = st.executeQuery(sql);
		return rs;
	}
	public ResultSet adminDetail() throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM admin";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet customerSearch(String search) throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM customer c, bankAccount b where c.custID = b.customerID and c.fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet empSearch(String search) throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM Employee where fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet adminSearch(String search) throws SQLException {
		
		st = conn.createStatement();
		sql = "SELECT * FROM admin where fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
}
