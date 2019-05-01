package com.bank.controller;

import java.io.IOException;
import com.bank.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    	
    			/* In the code entered below 
    			 * 1. Get the from the user 
    			 * 2. Get the first letter of the bankID to the fLetter variable 
    			 * 3. Initialize session variable 
    			 * 4. Create objects of 3 classes which includes the logic of the login 
    			 */
    	
    			String bankID = request.getParameter("bId"); // get bankID
    			String password = request.getParameter("pass"); // get password 
    			char fLetter = bankID.charAt(0); // variable to get the first letter of bankID
    			HttpSession session; 
    			LoginAdmin login1 = new LoginAdmin();
    			LoginEmployee login2 = new LoginEmployee();
    			LoginCustomer login3 = new LoginCustomer();
    			
    		try {
//    			Class.forName("com.mysql.jdbc.Driver");
    			if(fLetter == 'E') { // check the first letter 
    				if(login2.checkEmp(bankID, password)) {
    					session = request.getSession(); 
    					session.setAttribute("bankID", bankID); 
    					response.sendRedirect("Admin/bankers.jsp");
    				}
    				else {
        				response.sendRedirect("login.jsp");
        			}
    			}
    			
    			else if(fLetter == 'A') { // check the first letter 
    				if(login1.checkAdmin(bankID, password)) {
    					session = request.getSession(); 
    					session.setAttribute("bankID", bankID); 
    					response.sendRedirect("Admin/admins.jsp");
    				}
    				else {
        				response.sendRedirect("login.jsp");
        			}
    			}
    			else if(fLetter == 'C') {
    				if(login3.checkCust(bankID, password)) {
    					session = request.getSession(); 
    					session.setAttribute("bankID", bankID); 
    					response.sendRedirect("dashboard.jsp");
    				}
    				else {
        				response.sendRedirect("login.jsp");
        			}
    			}
    			else {
    				response.sendRedirect("login.jsp");
    			}
    		}
    		catch(Exception e) {
    			System.out.print(e.getMessage());{
			}
		}
	}

}
