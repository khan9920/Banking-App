package com.Banking.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.Dao.*;

/*
 * UserDetails class extends Connections class which includes the database connection
 * User Details class is used by several Servlets including 
 * CustDetailsServlet, CustomerSearchServlet, BankDetailServlet, AdminDetailServlet, EmployeeSearchServlet and AdminSearchServlet
 * All the methods in the class are used to connect and retrieve data from the database 
 * All methods return a resultSet variable called rs that includes the search result
 * */

public class UserDetails extends Connections{

	Connection con = super.toConnect(); // call the method of super class 
	private Statement st; 
	private String sql;
	private ResultSet rs;
	
	public ResultSet customerDetails() throws SQLException { // gets called by the CustDetailServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM customer c, bankAccount b where c.custID = b.customerID";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet empDetail() throws SQLException { // gets called by the CustDetailServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM Employee";
		rs = st.executeQuery(sql);
		return rs;
	}
	public ResultSet adminDetail() throws SQLException { // gets called by the AdminDetailServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM admin";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet customerSearch(String search) throws SQLException { // gets called by the CustSearchServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM customer c, bankAccount b where c.custID = b.customerID and c.fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet empSearch(String search) throws SQLException { // gets called by the EmployeeSearchServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM Employee where fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet adminSearch(String search) throws SQLException { // gets called by the AdminSearchServlet
		
		st = conn.createStatement();
		sql = "SELECT * FROM admin where fullName like '%" + search + "%'";
		rs = st.executeQuery(sql);
		return rs;
	}
	
}
