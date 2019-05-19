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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  

		String bid = request.getParameter("bId");
		String pass = request.getParameter("pass");
		char fLetter = bid.charAt(0);
		UserLogin login = new UserLogin(bid, pass);
		boolean status;
		HttpSession session;
		
		try {
			if(fLetter == 'C') {
				status = login.custLogin();
				if(status) {
//					 rd=request.getRequestDispatcher("dashboard.jsp");  
//			         rd.forward(request, response);  
			         session = request.getSession(); 
 					 session.setAttribute("bankID", bid);
 					 session.setAttribute("type", 'c');
 					 session.setAttribute("name", login.getName());
 					 session.setAttribute("acc", login.getAccNo());
 					 session.setAttribute("bal", login.getBal());
 					response.sendRedirect("dashboard.jsp");
				}else {
					response.sendRedirect("login.jsp");
				}
			}
			else if(fLetter == 'E') {
				status = login.empLogin();
				if(status) {
//					 rd=request.getRequestDispatcher("/Banker/bankerDashboard.jsp");  
//					 rd.forward(request, response);  
			         session = request.getSession(); 
 					 session.setAttribute("bankID", bid);
 					 session.setAttribute("type", 'e');
 					 session.setAttribute("name", login.getName());
 					 response.sendRedirect("Banker/bankerDashboard.jsp");
				}else {
					response.sendRedirect("login.jsp");
				}
			}
			else if(fLetter == 'A') {
				status = login.adminLogin();
				if(status) {
//					rd=request.getRequestDispatcher("Admin/adminDashboard.jsp");  
//					 rd.forward(request, response);  
			         session = request.getSession(); 
					 session.setAttribute("bankID", bid);
					 session.setAttribute("type", 'a');
					 session.setAttribute("name", login.getName());
					response.sendRedirect("Admin/adminDashboard.jsp");
				}else {
					response.sendRedirect("login.jsp");
				}
			}	else {
				response.sendRedirect("login.jsp");
			}
		}catch(Exception e) {
			System.out.println("Exception");
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
