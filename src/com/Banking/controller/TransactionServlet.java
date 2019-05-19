package com.Banking.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Banking.model.TransactionModel;
import com.Banking.service.TransactionService;
import com.Banking.service.UserDetails;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
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
		
		HttpSession session = request.getSession(true);
		
		String custID = (String)session.getAttribute("bankID");
		double senderBankBalance = 0.0;
		
		double amount;
		String senderRemark;
		String beneficiaryRemark;
		String accountNumber;
		
		
		try {
			
			amount = Integer.parseInt(request.getParameter("amount"));
			senderRemark = request.getParameter("senderRemark");
			beneficiaryRemark = request.getParameter("beneficiaryRemark");
			accountNumber = request.getParameter("accountNumber");
			
			TransactionModel transaction = new TransactionModel();
			
			transaction.setCustomerID(custID);
//			transaction.setBankBalance(senderBankBalance);
			transaction.setTransferAmount(amount);
			transaction.setSenderRemark(senderRemark);
			transaction.setBeneficiaryRemark(beneficiaryRemark);
//			transaction.setTransferringCustID(accountNumber);
						
			TransactionService traDao = new TransactionService();
			traDao.setCustID(custID);
			
			ResultSet rt = traDao.getBankBalance();
			while(rt.next()) {
				senderBankBalance = rt.getDouble("cBalance"); 
			}
			
			transaction.setBankBalance(senderBankBalance);
			
			transaction.printTransactionDetails();
			
			response.sendRedirect("dashboard.jsp");
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
