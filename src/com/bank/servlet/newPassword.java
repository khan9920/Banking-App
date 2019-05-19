package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.service.*;


/**
 * Servlet implementation class newPassword
 */
@WebServlet("/newPassword")
public class newPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newPassword() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		try {
			//create object from the Authentication class
			Authentication Fpassword = new Authentication();
			
			//call the method for set values
			Fpassword.setUdigits(Integer.parseInt(request.getParameter("digits")));
			Fpassword.setNewPw(request.getParameter("newPass"));
			
			//get the Digits & customer id using session
			HttpSession session = request.getSession();
			String digits = (String) session.getAttribute("DIGITS");
			String userID = (String) session.getAttribute("customerID");
			
			//call the methoeds for the values of the Fpassword object
			Fpassword.setUserId(userID);
			
			System.out.println(digits);
			
			//comparing user enterd digits and digits that send using email
			if(digits.equals(request.getParameter("digits"))) { //if both digits are the same
				Fpassword.updateDB(); //update the password
				response.sendRedirect("index.jsp"); //redirect to the login page
			}else {//if digits are different
				response.sendRedirect("new-password.jsp"); //redirect to the new-password page for re-enter digits
				System.out.println("Invalid Digits.Try again");
			}
			
			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
