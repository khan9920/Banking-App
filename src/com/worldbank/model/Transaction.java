package com.worldbank.model;

public class Transaction {
	private String cusID;
	private double currentBalance;
	
	public void setCurrentBalance(double currentBal) {
		this.currentBalance = currentBal;
	}
	
	public double getCurrentBalance() {
		return this.currentBalance;
	}
	
	public void setCustomerID(String cusID) {
		this.cusID = cusID;
	}
	
	public String getCustomerID() {
		return this.cusID;
	}
	
}
