package com.Banking.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Banking.model.*;

@WebServlet("/update")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*UpdateCustomerServlet gets called from the updateCustomer.jsp
	 * It gets the session value bankID
	 * It an object of the UpdateCustomer 
	 * call the updateDetail method of UpdateCustomer
	 * */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session; // session 
		session = request.getSession();  
		
		String id =  (String)session.getAttribute("bankID");  // get the session variable 
		
		/*Get value from request*/
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int pcode =Integer.parseInt(request.getParameter("pcode"));
		String city = request.getParameter("city");
		
		UpdateCustomer cust = new UpdateCustomer(id); // create object 
		try {
			cust.updateDetails(address, email, city, pcode); // call method
			response.sendRedirect("dashboard.jsp"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}



}
