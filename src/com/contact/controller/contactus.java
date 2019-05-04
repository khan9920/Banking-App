package com.contact.controller;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.model.*;
import com.contact.dao.*;
/**
 * Servlet implementation class contactus
 */
@WebServlet("/contactus")
public class contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public contactus() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String CustomerId = request.getParameter("CustomerId");
		 String firstname = request.getParameter("firstname");
		 String lastname = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String subject = request.getParameter("subject");
		 
		 		 
		 Contactus contactus = new Contactus();
		 
		 contactus.setCustomerId(CustomerId);
		 contactus.setfirstname(firstname);
		 contactus.setlastname(lastname);
		 contactus.setemail(email);
		 contactus.setsubject(subject);
		 
		 ContactDao contactDao = new ContactDao();
		 
		 String customerContact = contactDao.contactcustomer(contactus);
	
		 
		 
		 if(customerContact.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("Success.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
	}

}
