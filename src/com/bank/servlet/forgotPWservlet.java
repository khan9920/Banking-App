package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.service.*;


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
			
			Fpassword.setUserId(request.getParameter("USERid"));
			Fpassword.setDigits();
			Fpassword.sendEmail();
			
			String digits = Integer.toString(Fpassword.getDigits());
			String id = request.getParameter("USERid");
			
			HttpSession session = request.getSession();
			session.setAttribute("DIGITS", digits);
			session.setAttribute("customerID", id);

			response.sendRedirect("new-password.jsp");
		
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
