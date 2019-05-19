package com.Banking.model;

//import all the necessery packages
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.Banking.Dao.*;

//implementing Authentication class
public class Authentication {
	
	//create variables
	private String userId;
	private String newPW;
	private int Digits;
	private int uDigits;
	private String userEmail;

	//set value to userID
	public void setUserId(String user) {
		userId = user;
	}

	//Generate a random number for send via email
	public void setDigits(){
		Random rand = new Random();
    	this.Digits = rand.nextInt((999999 - 100000) + 1) + 100000;
	}
	
	//set value to uDigits 
	public void setUdigits(int digits) {
		uDigits = digits;
	}

	//set value to newPW
	public void setNewPw(String nPW){
		newPW = nPW;
	}
	
	//get email from the database according to the userID
	public void setUserEmail() {
		
		try {
		//set the connection
		Connections con = new Connections();
        Connection conn = con.toConnect();

        Statement st = conn.createStatement();
		
		//get the users's email from the database
		String sql = "SELECT email FROM customer WHERE custID = '"+userId+"'";
    	ResultSet rs = st.executeQuery(sql);
    	    while(rs.next()) { // loop through the results of the query
                    this.userEmail = rs.getString("email");
            }
    	    conn.close(); //close the connetion
    	    
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//send Digits
	public int getDigits() {
		return Digits;
	}
	
	//sending the email using bank email
	public void sendEmail(){
	
		final String username = "@gmail.com"; //bank email
		final String password = ""; //email password
		
		String fromEmail = "mail.com"; //senders email(bank email)
		String toEmail = this.userEmail; //Reciient's email address
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		//Start mail message
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			
			InternetAddress[] address = {new InternetAddress(toEmail)};
	        msg.setRecipients(Message.RecipientType.TO, address);
	        
			msg.setSubject("Update Account Password"); //email Subject
			//email body with the randomly generated digits
			msg.setText("To change the password use this digits :" + this.Digits); 
			
			Transport.send(msg); //send the email
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update the new password
	public void updateDB() {
		
		try {
	    	//set the database connetion
	        Connections con = new Connections();
	        Connection conn = con.toConnect();
	        
	        Statement st = conn.createStatement();
			
	        String sql = "UPDATE customer SET password = '"+newPW+"' WHERE custID = '"+userId+"'";
	  					
	        st.executeUpdate(sql);
	  
			conn.close(); //close the connetion
	    	}catch(Exception e) {
	    		System.out.println(e);
	    		
	    	}
		
		
	}

}
