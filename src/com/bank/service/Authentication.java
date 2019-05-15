package com.bank.service;

import java.sql.Connection;
import java.sql.Statement;
import java.io.IOException;
import java.util.Properties;
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

	public void setuDigits(int digit){
		uDigits = digit;
	}

	public void setNewPw(String nPW){
		newPW = nPW;
	}
	
	public void sendEmail(){
	
		final String username = "xxxxxxxx@gmail.com";
		final String password = "xxxx ";
		
		String fromEmail = "xxxxxxxxx@gmail.com";
		String toEmail = "dhanushkanuwan24@gmail.com";
		
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
		
		
		System.out.println("test 1.1 working");
		
		//Start mail message
		MimeMessage msg = new MimeMessage(session);
		
		System.out.println("test 1.2 working");
		
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("My first email using java");
			msg.setText("Msg sent sucessfully");
			
			System.out.println("test 1.3 working");
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
