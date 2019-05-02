package com.bank.model;

import java.util.ArrayList;

public class Customer {

	public String custName;
	private int accNo;
	private double balance;
	private String bankID;
	private ArrayList<String> al = new ArrayList<String>();
	
//	public void setCustName(String name) {
//		this.custName = name;
//	}
//	public void setAccNo(int acc) {
//		this.accNo = acc;
//	}
//	public void setBalance(double bal) {
//		this.balance = bal;
//	}
//	public void setBankID(String bid) {
//		this.bankID = bid;
//	}

	public Customer(String name, int acc, double bal, String bid) {
		this.custName = name;
		this.accNo = acc;
		this.balance = bal;
		this.bankID = bid;
	}
	
	public String getName() {
		return this.custName;
	}
	public String getBankID() {
		return this.bankID;
	}
	public int getAccountNo() {
		return this.accNo;
	}
	public double getBalance() {
		return this.balance;
	}


	
}
