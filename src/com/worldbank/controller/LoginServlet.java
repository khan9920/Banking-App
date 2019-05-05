package com.worldbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldbank.dao.LoginAdmin;
import com.worldbank.dao.LoginCustomer;
import com.worldbank.dao.LoginEmployee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		String bankID = request.getParameter("bankID"); //assigning form data to variable
		String password = request.getParameter("password"); //assigning form data to variable
		
		char fLetter = bankID.charAt(0); // variable to get the first letter of bankID
		
		HttpSession session; 
		LoginAdmin login1 = new LoginAdmin();
		LoginEmployee login2 = new LoginEmployee();
		LoginCustomer login3 = new LoginCustomer();
		
		
		try {
			if( fLetter == 'E' ) {
				if(login2.checkEmp(bankID, password)) {
					session = request.getSession(); 
					session.setAttribute("bankID", bankID); 
					session.setAttribute("role", "e");
					response.sendRedirect("banker/dashboard.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			} else if ( fLetter == 'A') {
				if(login1.checkAdmin(bankID, password)) {
					session = request.getSession(); 
					session.setAttribute("bankID", bankID);
					session.setAttribute("role", "a");
					response.sendRedirect("admin/dashboard.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			} else if ( fLetter == 'C' ) {
				if(login3.checkCust(bankID, password)) {
					session = request.getSession(); 
					session.setAttribute("bankID", bankID);
					session.setAttribute("role", "c");
					response.sendRedirect("dashboard.jsp");	
				} else {
					response.sendRedirect("index.jsp");
				}
			} else {
				response.sendRedirect("index.jsp");
			}			
		} catch (Exception e ) {
			System.out.print(e);
		}
	}
}
