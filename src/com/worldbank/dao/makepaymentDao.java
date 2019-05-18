package com.worldbank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.worldbank.model.*;
import com.worldbank.util.DBconnection;

public class makepaymentDao {

	
	public String insert(makepaymentModel mp) {
		double amount = mp.getAmount();
		String accountNo = mp.getAccountNo();
		
		
		Connection  con = null;
		PreparedStatement preparedStatement = null;
		
		 try
		 {
		 con = DBconnection.createConnection();
	
		 String query = "insert into vendorform(amount,accountNo) values (?,?)"; //Insert user details into the table 'contactus'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setDouble(1, amount);
		 preparedStatement.setString(2, accountNo);
		
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
			
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		 }
		
	
	
	public String insertdropdown(makepaymentModel mp) {
		String category = mp.getcategory();
		String option = mp.getOption();
		
		
		Connection  con = null;
		PreparedStatement preparedStatement = null;
		
		 try
		 {
		 con = DBconnection.createConnection();
	
		 String query = "insert into vendor(name,options) values (?,?)"; //Insert user details into the table 'contactus'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, category);
		 preparedStatement.setString(2, option);
		
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
			
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		 }
		
	
	//display recently payment Details on payment page
	
	public ResultSet DisplayPayments()throws Exception {
		Connection con = DBconnection.createConnection();
		
		String qry = "select v.options,v.name,vf.amount,vf.accountNo,vf.Date from vendor v,vendorform vf where v.id= vf.vid";  
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}
	
	
	//display recently current balance on payment page
	public ResultSet DisplaycurrentBalance()throws Exception {
		Connection con = DBconnection.createConnection();
		
		String qry = "select cBalance from  bankaccount";  
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}
	

	public String Insert(String option, String category, String accountNo, int amount) {
	
		Connection  con = null;
		PreparedStatement preparedStatement = null;
		
		 try
		 {
		 con = DBconnection.createConnection();
	
		 String query = "insert into payments(option,vendorId,customerAcc,amount) values (?,?,?,?)"; //Insert user details into the table 'contactus'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, option);
		 preparedStatement.setString(2, category);
		 preparedStatement.setString(3, accountNo);
		 preparedStatement.setInt(4, amount);
		
		 
 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
			
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		 }
}

