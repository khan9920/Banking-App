package com.Banking.Dao;

import java.sql.DriverManager;
import java.sql.Connection;


public class Connections {
	/*
	 * Connections class gets inherited by all the classes of the dao package 
	 * Connections class is setting up the connection to the database 
	 */
	protected String url = "jdbc:mysql://localhost:4200/world_bank";
	protected String username = "root";
	protected String password = "";
	protected Connection conn;

	public Connection toConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}