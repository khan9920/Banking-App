package com.worldbank.dao;
import java.sql.Connection;


import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.worldbank.model.*;
import com.worldbank.util.*;

public class ContactDao {

	public String contactcustomer(Contactus contactus) 
	{

		String CustomerId = contactus.getCustomerId();
		String firstname = contactus.getfirstname();
		String lastname = contactus.getlastname();
		String email = contactus.getemail();
		String subject = contactus.getsubject();
		
		Connection  con = null;
		PreparedStatement preparedStatement = null;
		
		 try
		 {
		 con = DBconnection.createConnection();
	
		 String query = "insert into contactus(CustomerId,FirstName,LastName,Email,subject) values (?,?,?,?,?)"; //Insert user details into the table 'contactus'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, CustomerId);
		 preparedStatement.setString(2, firstname);
		 preparedStatement.setString(3, lastname);
		 preparedStatement.setString(4, email);
		 preparedStatement.setString(5, subject);
		 
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
		
	
	
	public String delete(String CustomerId) {
	
		
		try {
			Connection con = DBconnection.createConnection();
			
			PreparedStatement ps= con.prepareStatement("DELETE FROM contactus WHERE CustomerId ='"+CustomerId+"'");
			/*ps.setString(1,CustomerId);*/
			/*ps.executeUpdate();*/
			
		
			 int i= ps.executeUpdate();
			 
			 if (i!=0)  //Just to ensure data has been inserted into the database
				
				 return "SUCCESS"; 
			 }
			 catch(SQLException e)
			 {
			 e.printStackTrace();
			 }
			 
			 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
			 }
		




	public ResultSet DisplayContact()throws Exception {
		Connection con = DBconnection.createConnection();
		
		String qry = "select * from contactus";  
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}

}
		
	/*	String CustomerId = contactus.getCustomerId();
		String firstname = contactus.getfirstname();
		String lastname = contactus.getlastname();
		String email = contactus.getemail();
		String subject = contactus.getsubject();
		
		Connection  con = null;
		PreparedStatement preparedStatement = null;
		
		 try
		 {
		 con = DBconnection.createConnection();
	
		 String query = ("delete from contactus where id='"+CustomerId+"'");
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, CustomerId);
		 preparedStatement.setString(2, firstname);
		 preparedStatement.setString(3, lastname);
		 preparedStatement.setString(4, email);
		 preparedStatement.setString(5, subject);
		 
		 int i= ps.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
			
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a
	}*/

	
