package com.Banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		
		if(request.getParameter("re-logout") != null) {
			request.getRequestDispatcher("login.jsp").include(request, response);  
		}else {
			request.getRequestDispatcher("login.jsp").include(request, response); 
		}
          
        HttpSession session=request.getSession();  
        session.invalidate();  
	}

}
