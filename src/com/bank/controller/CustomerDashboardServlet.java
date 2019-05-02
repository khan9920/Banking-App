package com.bank.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bank.dao.*;
import com.bank.model.*;
/**
 * Servlet implementation class CustomerDashboardServlet
 */
@WebServlet("/cDashboard")
public class CustomerDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String bankID = (String)session.getAttribute("bankID");
		/* variable decleration to hold the database values*/
		int accNo;
		double balance;
		String name;
		
		CustomerDetail customer = new CustomerDetail();
		try {
			
			ResultSet rs = customer.custDetails(bankID);
			while(rs.next()) {
				accNo = Integer.parseInt(rs.getString("accountNo"));
				balance = Double.parseDouble(rs.getString("cBalance"));
				name = rs.getString("fullName");
				Customer cust = new Customer(name, accNo, balance, bankID);

				request.setAttribute("name", cust.getName());
				request.setAttribute("accNo", cust.getAccountNo());
				request.setAttribute("bal", cust.getBalance());
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
