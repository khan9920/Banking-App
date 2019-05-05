package com.worldbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldbank.dao.DeleteBanker;

/**
 * Servlet implementation class DeleteBankerServlet
 */
@WebServlet("/DeleteBankerServlet")
public class DeleteBankerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBankerServlet() {
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

		String bankerID = request.getParameter("deleteBankID");
		
		try {
			DeleteBanker deleteBanker = new DeleteBanker();
			
			deleteBanker.setBankerID(bankerID);
			deleteBanker.updateDB();
			
			response.sendRedirect("admin/bankers.jsp");
			
		} catch(Exception e) {
			System.out.print(e);
		}
	}

}