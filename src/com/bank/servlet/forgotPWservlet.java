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
 * Servlet implementation class forgotPWservlet
 */
@WebServlet("/forgotPWservlet")
public class forgotPWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotPWservlet() {
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
			
			Fpassword.setUserId(request.getParameter("USERid"));
			Fpassword.sendEmail();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("");
			dispatcher.forward(request, response);
		
			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
