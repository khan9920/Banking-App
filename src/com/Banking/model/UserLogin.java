package com.Banking.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Banking.service.*;

public class UserLogin {
	private String bid;
	private String password;
	private String name;
	private String accountNo;
	private String bal;
	private ResultSet rs;
	Login login = new Login();
	
	public UserLogin(String bid, String password) {
		this.bid = bid;
		this.password = password;
	}
	
	
	public String getBid() {
		return bid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAccNo() {
		return this.accountNo;
	}
	
	public String getBal() {
		return this.bal;
	}

	public boolean custLogin() throws SQLException {
		rs = login.custLogin();
		while(rs.next()) {
			if(bid.equals(rs.getString("custID")) && password.equals(rs.getString("password"))) {
				this.name = rs.getString("fullName");
				this.accountNo = rs.getString("accountNo");
				this.bal = rs.getString("cBalance");
				return true;
			}
		}
		return false;
		
	}
	
	public boolean empLogin() throws SQLException {
		rs = login.empLogin();
		while(rs.next()) {
			if(bid.equals(rs.getString("empID")) && password.equals(rs.getString("password"))) {
				this.name = rs.getString("fullName");
				return true;
			}
		}
		
		return false;
	}
	
	public boolean adminLogin() throws SQLException {
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

