package com.worldbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if ( bankID.equals("WB001") && password.equals("Loft1024")) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("bankID", bankID); //assigning session variable
			session.setAttribute("userFirstName", "Shafkhan"); //assigning session variable
			session.setAttribute("userLastName", "Mohamed"); //assigning session variable
			response.sendRedirect("admin/dashboard.jsp"); //redirecting to dashboard
			
		} else {
			response.sendRedirect("index.jsp"); //redirecting to dashboard when credentials false
		}
		
	}

}
