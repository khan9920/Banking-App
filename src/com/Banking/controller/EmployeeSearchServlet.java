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

@WebServlet("/searchEmployee")
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * EmplyeeerSearchServlet gets called from the Bankers.jsp page 
	 * This servlet is used for customer search
	 * Gets the search value as the request 
	 * Create an object of UserDetails
	 * Call the customerSearch method passing the search value 
	 * And call the corresponding page according to the request 
	 * */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		
		String search = request.getParameter("search"); // get the search value 
		UserDetails details = new UserDetails(); // creates an object 
		ResultSet rs; // variable to catch the return resultSet
		try {
			rs = details.empSearch(search); // get customer details
			request.setAttribute("result", rs);  // set request attribute 
			RequestDispatcher rd=request.getRequestDispatcher("Admin/bankers.jsp");  
	        rd.forward(request, response);  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
