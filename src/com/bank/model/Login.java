package com.bank.model;

public class Login {

	private String bankID;
	private String password;
	
	public void setBankID(String bid) {
		this.bankID = bid;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getBankID() {
		return this.bankID;
	}
	
	public String getPassword() {
		return this.password;
	}
	
}
