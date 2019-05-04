package com.contact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.model.*;
import com.contact.dao.*;
/**
 * Servlet implementation class makePaymentForm
 */
@WebServlet("/makePaymentForm")
public class makePaymentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makePaymentForm() {
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
	
		int amount = Integer.parseInt(request.getParameter("amount"));
		String accountNo = request.getParameter("account");
		
		makepaymentDao md = new makepaymentDao();
		makepaymentModel mp = new makepaymentModel();
		mp.setAccountNo(accountNo);
		mp.setAmount(amount);
		
		 
		 String customerContact = md.insert(mp);
	
		 
		 
		 if(customerContact.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("make-a-payment-summary.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {

		 request.setAttribute("errMessage", customerContact);
		 request.getRequestDispatcher("error.jsp").forward(request, response);
		 }
	}

}
		
	

