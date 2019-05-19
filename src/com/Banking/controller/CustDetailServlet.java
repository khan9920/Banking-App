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
import com.Banking.*;

@WebServlet("/CustDetailServlet")
public class CustDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html"); 
		UserDetails details = new UserDetails();
		ResultSet rs; // variable to catch the return resultSet
		System.out.println("called servlet");
		if(request.getParameter("custDash") != null) {
			RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");  
	        rd.forward(request, response);  
		}else {
			
			try {
				rs = details.customerDetails(); // get customer details
				request.setAttribute("result", rs);  // set request attribute 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(request.getParameter("adminCust") != null) {
					RequestDispatcher rd=request.getRequestDispatcher("Admin/customers.jsp");  
			        rd.forward(request, response);  
			
			}
			else if(request.getParameter("bankerCust") != null){
					RequestDispatcher rd=request.getRequestDispatcher("Banker/customers.jsp");  
			        rd.forward(request, response);  
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
