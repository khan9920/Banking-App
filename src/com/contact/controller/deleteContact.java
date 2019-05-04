package com.contact.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.contact.model.*;
import com.contact.dao.*;


@WebServlet("/deleteContact")
public class deleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteContact() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		ContactDao cd = new ContactDao();
		Contactus cu = new Contactus();
	/*	Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebank","root","");*/
		
		request.getParameter("d");
		String customerContact = cd.delete(request.getParameter("d"));
		response.sendRedirect("support.jsp");
		
		
		 
		 if(customerContact.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("Success.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
		
		
	
		
		
		
		/*System.out.println("Hello");*/
	/*	String sid = request.getParameter("d");
		int id = Integer.parseInt(sid);
		ContactDao cd = new ContactDao();
		String customerContact= cd.delete(sid);
		response.sendRedirect("support");
		

		 if(customerContact.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("Success.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
	}*/
		
		/*String cs = request.getParameter("d");
		 String firstname = request.getParameter("firstname");
		 String lastname = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String subject = request.getParameter("subject");
		 
		 		 
		 Contactus contactus = new Contactus();
		 
		 contactus.setCustomerId(cs);*/
		/*contactus.setfirstname(firstname);
		 contactus.setlastname(lastname);
		 contactus.setemail(email);
		 contactus.setsubject(subject);
		 
		 ContactDao contactDao = new ContactDao();
		 
		 String cd = contactDao.delete(contactus);
	
		 
		
		 if(cd.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("Success.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
		 */
		
		
		
	}

}
