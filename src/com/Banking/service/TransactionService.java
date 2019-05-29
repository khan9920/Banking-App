package com.Banking.service;

import java.sql.*;

import com.Banking.Dao.*;

public class TransactionService {
	
	//crate variables to hold values
	private String custDAOID;
	private double calcualtedBalance;
	private double calculatedRecAmount;
	private double transferAmount;
	private int senderAccountNumber; 
	private int recAccountNumber;
	private String traDate;
	private String senderRemark;
	private String benRemark;
	
	
	//set customer ID
	public void setCustID(String CustID) {
		this.custDAOID = CustID;
	}
	
	//send senders remark 
	public void setSenderRemark(String SenderRemark) {
		this.senderRemark = SenderRemark;
	}
	
	//set beneficiary remark
	public void setBenRemark(String BenRemark) {
		this.benRemark = BenRemark;
	}
	
	//set calculated balance
	public void setCalculatedBalance(double CalculatedBalance) {
		this.calcualtedBalance = CalculatedBalance;
	}
	
	//set calculated receiver amount
	public void setCalculatedRecAmount(double CalculatedRecAmount) {
		this.calculatedRecAmount = CalculatedRecAmount;
	}
	
	//set transferring amount
	public void setTransferAmount(double TraAmount) {
		this.transferAmount = TraAmount;
	}
	
	//set sender's bank account number 
	public void setSenderAccount(int SendAcc) {
		this.senderAccountNumber = SendAcc;
	}
	
	//set receiver's bank account number
	public void setRecAccount(int RecAcc) {
		this.recAccountNumber = RecAcc;
	}
	
	//set transaction date and time
	public void setTranDate(String TraDate) {
		this.traDate = TraDate;
	}

	//create object of connection class
	Connections con = new Connections();
	Connection conn = con.toConnect();
	
	//get current bank balance of the user from DB
	public ResultSet getBankBalance() throws SQLException {
		System.out.println("Pringing from transaction service : " + this.custDAOID);
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	//get bank account of the current user from DB
	public ResultSet getBankAccountNumber() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT accountNo FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	//get receiver's bank account number
	public ResultSet getRecBankAccountNumber() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT accountNo FROM bankAccount WHERE accountNo = '"+this.recAccountNumber+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	//get receiver's bank balance
	public ResultSet getRecBankBalance() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE accountNo = '"+this.recAccountNumber+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	//update sender's bank balance
	public void updateSenderDB() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " UPDATE bankAccount SET cBalance = '"+this.calcualtedBalance+"' WHERE customerID='"+this.custDAOID+"'";
		st.executeUpdate(sql);
	}
	
	//update receiver's bank balance
	public void updateReceiverDB() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " UPDATE bankAccount SET cBalance = '"+this.calculatedRecAmount+"' WHERE accountNo='"+this.recAccountNumber+"'";
		st.executeUpdate(sql);
	}
	
	//update transaction table
	public void updateTransactionDB() throws SQLException{
		Statement st = conn.createStatement();
		String sql = "INSERT INTO transactions (recieverAccNo, senderAccNo, transactionDate, amount, senderRem, recRemark) VALUES ('"+this.recAccountNumber+"', '"+this.senderAccountNumber+"', '"+this.traDate+"', '"+this.transferAmount+"', '"+this.senderRemark+"', '"+this.benRemark+"')";                     
		st.executeUpdate(sql);
	}
}
