package com.Banking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Banking.model.*;


@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	
	/*
	 * In the program below it 
	 * First take the bank id and password from the login page 
	 * Create an object of Userlogin in model
	 * And check bank id's first letter to check if it is an admin, customer or a banker 
	 * Call the required methods of UserLogin for each user 
	 * Set session variables 
	 * Redirects to the dashboard pages of each user 
	 * */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  

		String bid = request.getParameter("bId"); // get BankID 
		String pass = request.getParameter("pass"); // get Password 
		char fLetter = bid.charAt(0); 				// get the first letter of bankID 
		UserLogin login = new UserLogin(bid, pass); // create object of login class 
		boolean status; 							
		HttpSession session;						// initialize session
		
		try {
			if(fLetter == 'C') { 			// check the first letter ( Customer )
				status = login.custLogin(); // call method of UserLogin
				if(status) { 				
			         session = request.getSession();  
			         /* Set Session variables */
 					 session.setAttribute("bankID", bid); 
 					 session.setAttribute("type", 'c');
 					 session.setAttribute("name", login.getName());
 					 session.setAttribute("acc", login.getAccNo());
 					 session.setAttribute("bal", login.getBal());
 					 
 					response.sendRedirect("dashboard.jsp"); // send redirect to dashboard 
				}else {
					response.sendRedirect("index.jsp"); 
				}
			}
			else if(fLetter == 'E') {		// check the first letter ( Employee / Banker )
				status = login.empLogin();  // call method of UserLogin
				if(status) {
			         session = request.getSession(); 
			         /* Set Session variables */
 					 session.setAttribute("bankID", bid);
 					 session.setAttribute("type", 'e');
 					 session.setAttribute("name", login.getName());
 					 response.sendRedirect("Banker/bankerDashboard.jsp"); // send redirect to dashboard 
				}else {
					response.sendRedirect("index.jsp");
				}
			}
			else if(fLetter == 'A') {		 // check the first letter ( Administrator )
				status = login.adminLogin(); // call method of UserLogin
				if(status) {
			         session = request.getSession(); 
			         /* Set Session variables */
					 session.setAttribute("bankID", bid);
					 session.setAttribute("type", 'a');
					 session.setAttribute("name", login.getName());
					response.sendRedirect("Admin/adminDashboard.jsp"); // send redirect to dashboard 
				}else {
					response.sendRedirect("index.jsp");
				}
			}	else {
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) { // exception 
			System.out.println("Exception");
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
