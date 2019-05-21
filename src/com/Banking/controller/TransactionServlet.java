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
import com.Banking.service.DisplayTransactionService;
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
		
		//Access session in order to get the current user's bankID
		HttpSession session = request.getSession(true);

		String custID = (String)session.getAttribute("bankID");	//assign bank id to variable
		double senderBankBalance = 0.0;				//initiate current users's bank balance
		
		double amount;			//declare variable to store transfer amount								
		String senderRemark;	//declare variable to store sender's remark
		String beneficiaryRemark;	//declare variable to store beneficiary remark
		int recAccNumber;	//declare variable to store reveiver's bank account number
		int sendAccNo = 0;	// declare variable to store current user's account number
		int recAccNoDB = 0;	// declare variable to store receivers bank account number retrieved from DB
		double recBankBalance = 0.0; //declare variable to store receiver's bank balance
		
		
		try {
			//Retrieve data from the transfer form and store in respective variables
			amount = Double.parseDouble(request.getParameter("amount"));
			senderRemark = request.getParameter("senderRemark");
			beneficiaryRemark = request.getParameter("beneficiaryRemark");
			recAccNumber = Integer.parseInt(request.getParameter("accountNumber"));
			
			//Assign data to the model using constructor
			TransactionModel transaction = new TransactionModel(custID, amount, senderRemark, beneficiaryRemark, recAccNumber);
			transaction.setTransactionDate();
			
			//Getting bank balance using using transaction service
			TransactionService traDao = new TransactionService();
			traDao.setCustID(transaction.getCustomerID());
			traDao.setRecAccount(transaction.getRecAccNo());
			
			//get senders's bank balance
			ResultSet rt1 = traDao.getBankBalance();
			while(rt1.next()) {
				senderBankBalance = rt1.getDouble("cBalance"); 
			}
			
			if ( amount >= senderBankBalance) {
				response.sendRedirect("error/transaction-amount-error.jsp");
			} else {
				//get sender bank account number
				ResultSet rt2 = traDao.getBankAccountNumber();
				while(rt2.next()) {
					sendAccNo = rt2.getInt("accountNo");
				}
				
				//get receiver's bank balance
				ResultSet rt3 = traDao.getRecBankBalance();
				while(rt3.next()) {
					recBankBalance = rt3.getDouble("cBalance");
				}
				
				ResultSet rt4 = traDao.getRecBankAccountNumber();
				while(rt4.next()) {
					recAccNoDB = rt4.getInt("accountNo");
				}
				
				if ( recAccNumber != recAccNoDB ) {
					response.sendRedirect("error/transaction-account-error.jsp");
				} else {
					//Updating senders table
					transaction.setBankBalance(senderBankBalance);
					
					//Calculate and update senders credit status on bankAccount table
					traDao.setCalculatedBalance(transaction.getCalculatedBalance());
					traDao.updateSenderDB();
					
					//Calculate and update receivers status on bankAccount table
					transaction.setRecBankBalance(recBankBalance);
					traDao.setCalculatedRecAmount(transaction.calculateReceiveBalance());
					traDao.updateReceiverDB();
					
					//update transaction table
					traDao.setRecAccount(recAccNumber);
					traDao.setSenderAccount(sendAccNo);
					traDao.setTranDate(transaction.getTransactionDate());
					traDao.setTransferAmount(amount);
					traDao.setSenderRemark(senderRemark);
					traDao.setBenRemark(beneficiaryRemark);
					traDao.updateTransactionDB();
					
					response.sendRedirect("dashboard.jsp");
				}
			}
			
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
