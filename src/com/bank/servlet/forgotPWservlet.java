package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.service.*;


/**
 * Servlet implementation class forgotPWservlet
 */
@WebServlet("/forgotPWservlet")
public class forgotPWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public forgotPWservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        
		try {
			Authentication Fpassword = new Authentication();
			
			System.out.println("test 1 working");
			
			//Fpassword.setUserId(request.getParameter("USERid"));
			Fpassword.sendEmail();
			//session will be created at the authentication to store the digits that send via email
			
			System.out.println("test 2 working");
			
			response.sendRedirect("new-password.jsp");
		
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
