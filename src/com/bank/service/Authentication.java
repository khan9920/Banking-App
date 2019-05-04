package com.bank.service;

import java.sql.Connection;
import java.sql.Statement;
import java.io.IOException;
import java.util.Properties;
/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
*/
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
	
	public void sendEmail() {
		//send the old password via email
		
		final String username = "bankPassword@gmail.com";
		final String password = "password";
		//should get email from the database
		String fromEmail = "bankPassword@gmail.com";
		String toEmail = "toEmail@example.com";
		
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
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Subject Line");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("My multipart text");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
