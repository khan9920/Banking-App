package com.bank.service;

import java.sql.Connection;
import java.sql.Statement;

import com.bank.dao.*;

public class Authentication {
	
	private String userId;
	private String newPW;
	
	public void setUserId(String user) {
		userId = user;
	}
	
	public void sendEmail() {
		
		
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
