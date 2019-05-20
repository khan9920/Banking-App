package com.Banking.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Banking.service.*;

@WebServlet("/AdminDetailServlet")
public class AdminDetailServlet extends HttpServlet {


	/*
	 * AdminDetailServlet gets called from the admin.jsp in Admin and Bankers folder
	 * In the servlet it create an object of UserDetails
	 * Calls adminDetailServlet method to get the required details of customers details from the database
	 * And sends the data to the correct page using request dispatcher 
	 * */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		UserDetails details = new UserDetails(); // method creation 
		ResultSet rs; // variable to catch the return resultSet
		
		try {
			rs = details.adminDetail(); // get customer details
			request.setAttribute("result", rs);  // set request attribute 
			RequestDispatcher rd=request.getRequestDispatcher("Admin/admins.jsp");  
		    rd.forward(request, response);  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
