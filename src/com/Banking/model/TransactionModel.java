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
	
	//constructor
	public TransactionModel(String CustID, double TransferAmount, String SenderRemark, String BeneficiaryRemark, int RecAccNo) {
		this.custID = CustID;
		this.transferAmount = TransferAmount;
		this.senderRemark = SenderRemark;
		this.beneficiaryRemark = BeneficiaryRemark;
		this.recAccNo = RecAccNo;
	}
	
	//set current customer ID
	public void setCustomerID(String CustID) {
		this.custID = CustID;
	}
	
	//get current customer ID
	public String getCustomerID() {
		return this.custID;
	}
	
	//set current customer bank balance
	public void setBankBalance(double BankBalance) {
		this.bankBalance = BankBalance;
	}
	
	//set current customer bank balance
	public double getBankBalance() {
		return this.bankBalance;
	}
	
	//set receiver's account number
	public void setRecAccNo(int RecAccNo) {
		this.recAccNo = RecAccNo;
	}
	
	//get receiver's account number
	public int getRecAccNo() {
		return this.recAccNo;
	}
	
	//set receiver's bank balance
	public void setRecBankBalance(double RecBankBalance) {
		this.recBankBalance = RecBankBalance;
	}
	
	//set transferring amount
	public void setTransferAmount(double TransferAmount) {
		this.transferAmount = TransferAmount;
	}
	
	//set sender's remarks
	public void setSenderRemark(String SendRemark) {
		this.senderRemark = SendRemark;
	}
	
	//set beneficiary's remark
	public void setBeneficiaryRemark(String BenRemark) {
		this.beneficiaryRemark = BenRemark;
	}
	
	//get calculated final balance to be updated on sender account
	public double getCalculatedBalance() {
		return this.total = this.bankBalance - this.transferAmount;
	}
	
	//get calculated final balance to be updated on receiver account
	public double calculateReceiveBalance() {
		return this.totalTransfer = this.recBankBalance + this.transferAmount;
	}
	
	//set transaction date
	public void setTransactionDate() {
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("yyyy.mm.dd hh:mm:ss");
        this.transactionDate = format.format(date);
	}
	
	//get transaction date
	public String getTransactionDate() {
		return this.transactionDate;
	}
}
