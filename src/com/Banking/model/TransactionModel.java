package com.Banking.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionModel {
	//sender
	private String custID;
	private double bankBalance;
	private double transferAmount;
	private double total;
	private String senderRemark;
	private String transactionDate;
	
	//beneficiary
	private int recAccNo;
	private double recBankBalance;
	private String beneficiaryRemark;
	private double totalTransfer;	
	
	public void setCustomerID(String CustID) {
		this.custID = CustID;
	}
	
	public String getCustomerID() {
		return this.custID;
	}
	
	public void setBankBalance(double BankBalance) {
		this.bankBalance = BankBalance;
	}
	
	public double getBankBalance() {
		return this.bankBalance;
	}
	
	public void setRecAccNo(int RecAccNo) {
		this.recAccNo = RecAccNo;
	}
	
	public int getRecAccNo() {
		return this.recAccNo;
	}
	
	public void setRecBankBalance(double RecBankBalance) {
		this.recBankBalance = RecBankBalance;
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
		return this.totalTransfer = this.recBankBalance + this.transferAmount;
	}
	
	public void setTransactionDate() {
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("yyyy.mm.dd hh:mm:ss");
        this.transactionDate = format.format(date);
	}
	
	public String getTransactionDate() {
		return this.transactionDate;
	}
}
