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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		UserDetails details = new UserDetails();
		ResultSet rs; // variable to catch the return resultSet
		
		if(request.getParameter("dashboard") != null) {
			RequestDispatcher rd=request.getRequestDispatcher("Admin/adminDashboard.jsp");  
	        rd.forward(request, response);  
		}
		else {
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
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
