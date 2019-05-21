package com.Banking.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Banking.service.*;

/*
 * This class is used by the LoginServlet 
 * This class contains 3 boolean methods that gets called on the required user
 * Each boolean method calls a method in Login class in the service package to get the sql query 
 * The result of those methods gets initialized to the the private variables
 * */

public class UserLogin { 
	/* Initialize Variablse */
	private String bid;
	private String password;
	private String name;
	private String accountNo;
	private String bal;
	private ResultSet rs; 
	Login login = new Login(); // create object of Login class 
	
	public UserLogin(String bid, String password) { // constructor, gets Bank ID and password as parameters 
		this.bid = bid;
		this.password = password;
	}
	
	public String getBid() { // getter for bankID 
		return bid;
	}
	
	public String getName() { // getter for name 
		return name;
	}
	 
	public String getAccNo() { // getter for account number 
		return this.accountNo; 
	}
	
	public String getBal() { // getter for balance
		return this.bal;
	}

	public boolean custLogin() throws SQLException { // Customer Login method, gets called on customer login
		rs = login.custLogin(); // call custLogin method of Login class 
		while(rs.next()) { 
			if(bid.equals(rs.getString("custID")) && password.equals(rs.getString("password"))) { // userName and password check 
				this.name = rs.getString("fullName");
				this.accountNo = rs.getString("accountNo");
				this.bal = rs.getString("cBalance");
				return true;  
			}
		}
		return false;
		
	}
	
	public boolean empLogin() throws SQLException { // Employee Login method, gets called on Employee login
		rs = login.empLogin();
		while(rs.next()) {
			if(bid.equals(rs.getString("empID")) && password.equals(rs.getString("password"))) {
				this.name = rs.getString("fullName");
				return true;
			}
		}
		
		return false;
	}
	
	public boolean adminLogin() throws SQLException { // Admin Login method, gets called on Admin login
		rs = login.adminLogin();
		while(rs.next()) {
			if(bid.equals(rs.getString("adminID")) && password.equals(rs.getString("password"))) {
				this.name = rs.getString("fullName");
				return true;
			}
		}
		return false;
	}
	
	
	
}

