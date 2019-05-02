package com.bank.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bank.dao.*;
import com.bank.model.*;
/**
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet("/searchCustomer")
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = (String) request.getParameter("search");
		System.out.println(search);
		if(search != "") {
		Searchcust result = new Searchcust();
		try {
			ResultSet rs = (ResultSet)result.searchResult(search);
				request.setAttribute("search", rs);
				RequestDispatcher rd = request.getRequestDispatcher("customers.jsp");
				rd.forward(request, response);
		}catch(Exception e) {
		}
			
		} else {
			response.sendRedirect("Admin/customers.jsp");
		}
	}

}
