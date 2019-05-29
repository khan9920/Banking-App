package com.Banking.controller;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Banking.service.*;
import com.Banking.model.*;

/**
 * Servlet implementation class makePaymentdropdown
 */
@WebServlet("/makePaymentdropdown")
public class makePaymentdropdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makePaymentdropdown() {
        super();
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
	
		String category = request.getParameter("category");
		String option = request.getParameter("payeeOption");
		
		makepaymentModel mp = new makepaymentModel();
		makepaymentDao md= new makepaymentDao();
		mp.setcategory(category);
		mp.setOption(option);
	
		 
		 String customerContact = md.insertdropdown(mp);
	
		 
		 
		 if(customerContact.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("make-a-payment-form.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
	}

}