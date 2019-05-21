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
import javax.servlet.http.HttpSession;

import com.Banking.service.*;
import com.Banking.*;

@WebServlet("/CustDetailServlet")
public class CustDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * CustDetailServlet gets called from the customer.jsp in Admin and Bankers folder
		 * In the servlet it create an object of UserDetails
		 * Calls customerDetails method to get the required details of customers details from the database
		 * And sends the data to the correct page using request dispatcher 
		 * */

		response.setContentType("text/html"); 
		UserDetails details = new UserDetails(); // method creation 
		ResultSet rs; // variable to catch the return resultSet
		
		
		try {
			rs = details.customerDetails(); // get customer details
			request.setAttribute("result", rs);  // set request attribute 
				
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(request.getParameter("adminCust") != null) { // check if the request is from the admin page 
			RequestDispatcher rd=request.getRequestDispatcher("Admin/customers.jsp");  // send response
			rd.forward(request, response);  
			
		}
		else if(request.getParameter("bankerCust") != null){ // check if the request is from banker page
			RequestDispatcher rd=request.getRequestDispatcher("Banker/customers.jsp");   // send response
			rd.forward(request, response);  
		}
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
