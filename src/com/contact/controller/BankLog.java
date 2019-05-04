package com.contact.controller;

import java.io.IOException;
import com.contact.dao.*;
import com.contact.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BankLog
 */
@WebServlet("/BankLog")
public class BankLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankLog() {
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
	
		String bankID = request.getParameter("id");
		String Password = request.getParameter("password");
		HttpSession session; 
		
		cBankLogin blog = new cBankLogin();
		makepaymentDao md= new makepaymentDao();
		makepaymentModel mp = new makepaymentModel();
	
		String category =  mp.getcategory();
		String option = mp.getOption();
		int amount = mp.getAmount();
		String accountNo = mp.getAccountNo();
		
	try {	
		if(blog.checkBankLog(bankID, Password)) {
			session = request.getSession(); 
			session.setAttribute("bankID", bankID); 
			
			response.sendRedirect("make-a-payment.jsp");
		
			

		}
		else {
			response.sendRedirect("make-a-payment-summary.jsp");
		}		

	}
		catch(Exception e) {
			System.out.print(e.getMessage());{
		}
	}
}

}

