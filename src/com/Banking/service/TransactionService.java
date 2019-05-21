package com.Banking.service;

import java.sql.*;

import com.Banking.Dao.*;

public class TransactionService {
	
	private String custDAOID;
	private double calcualtedBalance;
	private double calculatedRecAmount;
	private double transferAmount;
	private int senderAccountNumber; 
	private int recAccountNumber;
	private String traDate;
	private String senderRemark;
	private String benRemark;
	
	
	public void setCustID(String CustID) {
		this.custDAOID = CustID;
	}
	
	public void setSenderRemark(String SenderRemark) {
		this.senderRemark = SenderRemark;
	}
	
	public void setBenRemark(String BenRemark) {
		this.benRemark = BenRemark;
	}
	
	public void setCalculatedBalance(double CalculatedBalance) {
		this.calcualtedBalance = CalculatedBalance;
	}
	
	public void setCalculatedRecAmount(double CalculatedRecAmount) {
		this.calculatedRecAmount = CalculatedRecAmount;
	}
	
	public void setTransferAmount(double TraAmount) {
		this.transferAmount = TraAmount;
	}
	
	public void setSenderAccount(int SendAcc) {
		this.senderAccountNumber = SendAcc;
	}
	
	public void setRecAccount(int RecAcc) {
		this.recAccountNumber = RecAcc;
	}
	
	public void setTranDate(String TraDate) {
		this.traDate = TraDate;
	}

	Connections con = new Connections();
	Connection conn = con.toConnect();
	
	public ResultSet getBankBalance() throws SQLException {
		System.out.println("Pringing from transaction service : " + this.custDAOID);
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	public ResultSet getBankAccountNumber() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT accountNo FROM bankAccount WHERE customerID = '"+this.custDAOID+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	public ResultSet getRecBankAccountNumber() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT accountNo FROM bankAccount WHERE accountNo = '"+this.recAccountNumber+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	public ResultSet getRecBankBalance() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " SELECT cBalance FROM bankAccount WHERE accountNo = '"+this.recAccountNumber+"'";
		ResultSet rslt = st.executeQuery(sql);
		return rslt;
	}
	
	public void updateSenderDB() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " UPDATE bankAccount SET cBalance = '"+this.calcualtedBalance+"' WHERE customerID='"+this.custDAOID+"'";
		st.executeUpdate(sql);
	}
	
	public void updateReceiverDB() throws SQLException {
		Statement st = conn.createStatement();
		String sql = " UPDATE bankAccount SET cBalance = '"+this.calculatedRecAmount+"' WHERE accountNo='"+this.recAccountNumber+"'";
		st.executeUpdate(sql);
	}
	
	public void updateTransactionDB() throws SQLException{
		Statement st = conn.createStatement();
		String sql = "INSERT INTO transactions (recieverAccNo, senderAccNo, transactionDate, amount, senderRem, recRemark) VALUES ('"+this.recAccountNumber+"', '"+this.senderAccountNumber+"', '"+this.traDate+"', '"+this.transferAmount+"', '"+this.senderRemark+"', '"+this.benRemark+"')";                     
		st.executeUpdate(sql);
	}
}
