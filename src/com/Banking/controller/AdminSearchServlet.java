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

@WebServlet("/adminSearch")
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");  
		String search = request.getParameter("search");
		UserDetails details = new UserDetails();
		ResultSet rs; // variable to catch the return resultSet
		try {
			rs = details.adminSearch(search); // get customer details
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
