package com.Banking.model;

public class makepaymentModel {

	private String category;
	private String option;
	private String accountNo;
	private double amount;
	
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category=category;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option=option;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo=accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	
	
}
