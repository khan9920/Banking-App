package com.worldbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	protected String url = "jdbc:mysql://localhost:4200/world_bank";
	protected String username = "root";
	protected String password = "";
	protected Connection conn;

	public Connection toConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:4200/world_bank","root","");
			} catch(Exception e) {
				System.out.println(e);
		}
		return conn;
	}
}
