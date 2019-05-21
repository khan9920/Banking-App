package com.Banking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.Dao.Connections;
import com.Banking.util.DBconnection;

public class UpdateCustomer {

	private String id;
	private Statement st;
	private int rs;
	
	public UpdateCustomer(String id) {
		this.id = id;
	}
	
	
	public void updateDetails(String add, String email, String city, int postal) throws SQLException {
		Connections con = new Connections();
        Connection conn = con.toConnect();
		PreparedStatement preparedStatement = null;
		
		 
		 String query = "UPDATE customer SET address = ?, email = ?, city = ?, postalCode = ? where custID = ?";  // Query to update data 
		 preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch  of data
		 preparedStatement.setString(1, add);
		 preparedStatement.setString(2, email);
		 preparedStatement.setString(3, city);
		 preparedStatement.setInt(4, postal);
		 preparedStatement.setString(5, id);

		 
		 rs = preparedStatement.executeUpdate(); // Execute the update query
		 
		 conn.close();//close the database connetion

	}
}
