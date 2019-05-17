package com.bank.service;

import java.sql.Connection;
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
import com.bank.dao.*;

public class Authentication {
	
	private String userId;
	private String newPW;
	private int Digits;
	private int uDigits;

	public void setUserId(String user) {
		userId = user;
	}

	public void setDigits(){
		Random rand = new Random();
    	this.Digits = rand.nextInt((999999 - 100000) + 1) + 100000;
    	System.out.println(this.Digits);
	}
	
	public void setUdigits(int digits) {
		uDigits = digits;
	}

	public void setNewPw(String nPW){
		newPW = nPW;
	}
	
	public void sendEmail(){
	
		final String username = "@gmail.com";
		final String password = "";
		
		String fromEmail = "@gmail.com";
		String toEmail = "@gmail.com";
		
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
	        
			msg.setSubject("Update Account Password");
			msg.setText("To change the password use this digits :" + this.Digits);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateDB() {
		
		try {
	    	
	        dbConnection con = new dbConnection();
	        Connection conn = con.toConnect();
	        

	        Statement st = conn.createStatement();
				
	        String sql = "INSERT INTO xxxx(  ) VALUES ('"+newPW+"')";
						
	        st.executeUpdate(sql);
	    	
	    	}catch(Exception e) {
	    		
	    	}
		
		
	}

}
