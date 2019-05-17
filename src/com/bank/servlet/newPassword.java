package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			Authentication Fpassword = new Authentication();
			
			Fpassword.setUdigits(Integer.parseInt(request.getParameter("digits")));
			Fpassword.setNewPw(request.getParameter("newPass"));
			//session will be created at the authentication to store the digits that send via email
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("");
			dispatcher.forward(request, response);
		
			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
