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

@WebServlet("/searchCustomer")
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		String search = request.getParameter("search");
		UserDetails details = new UserDetails();
		ResultSet rs; // variable to catch the return resultSet
		try {
			rs = details.customerSearch(search); // get customer details
			request.setAttribute("result", rs);  // set request attribute 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(request.getParameter("submitBanker") != null) {
			RequestDispatcher rd=request.getRequestDispatcher("Banker/customers.jsp");  
	        rd.forward(request, response);  
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("Admin/customers.jsp");  
	        rd.forward(request, response); 
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
