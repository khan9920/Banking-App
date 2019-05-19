package com.Banking.model;

public class TransactionModel {
	//sender details
	private String custID;
	private double bankBalance;
	private double transferAmount;
	private double total;
	private String senderRemark;
	
	//beneficiary details
	private String transferingCustID;
	private String beneficiaryRemark;
	
	public void setCustomerID(String CustID) {
		this.custID = CustID;
	}
	
	public String getCustomerID() {
		return this.custID;
	}
	
	public void setBankBalance(double BankBalance) {
		this.bankBalance = BankBalance;
	}
	
	public void setTransferringCustID(String TransferringCustID) {
		this.transferingCustID = TransferringCustID;
	}
	
	public void setTransferAmount(double TransferAmount) {
		this.transferAmount = TransferAmount;
	}
	
	public void setSenderRemark(String SendRemark) {
		this.senderRemark = SendRemark;
	}
	
	public void setBeneficiaryRemark(String BenRemark) {
		this.beneficiaryRemark = BenRemark;
	}
	
	public double getCalculatedBalance() {
		return this.total = this.bankBalance - this.transferAmount;
	}
	
	public double calculateReceiveBalance() {
		return this.bankBalance = bankBalance + transferAmount;
	}
	
	public void printTransactionDetails() {
		System.out.println("From custID : " + this.getCustomerID());
		System.out.println("To custID : " + this.transferingCustID);
		
		System.out.println("From bank balance : " + this.bankBalance);
		System.out.println("Transfer amount : " + this.transferAmount);
		System.out.println("Total : " + this.getCalculatedBalance());
	}
	
}
