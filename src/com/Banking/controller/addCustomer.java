package com.Banking.controller;

//import all the necessery packages
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.Banking.model.*;

 // Servlet implementation class addCustomer

@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addCustomer() {
        super();
    }

	
	//  @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

		
		try {
		
			//creating a object from CreateCustomerACC
			CreateCustomerAcc cusACCOUNT = new CreateCustomerAcc();

			//set value to the object using methoes & the details
			cusACCOUNT.setName(request.getParameter("fullname"));
			cusACCOUNT.setInitials(request.getParameter("nameWithInitials"));
			cusACCOUNT.setNIC(request.getParameter("NICno"));
            cusACCOUNT.setAddress(request.getParameter("address"));
            cusACCOUNT.setCity(request.getParameter("city"));
            cusACCOUNT.setBday(request.getParameter("birthday"));
            cusACCOUNT.setGender(request.getParameter("gender"));
            cusACCOUNT.setContact(Integer.parseInt(request.getParameter("contact")));
            cusACCOUNT.setPcode(Integer.parseInt(request.getParameter("pcode")));
            cusACCOUNT.setEmail(request.getParameter("email"));
            cusACCOUNT.setPassword(request.getParameter("password"));
			cusACCOUNT.setCreateDate(); //call the method for generate "create date & time"
			cusACCOUNT.createUserID(); //call the method for generate unique user id
			cusACCOUNT.createAccNo(); //call the method for generate unique account number
			cusACCOUNT.updateDB(); //insert a new user to the database

			//redirect page to the dashboard after creating new user
			response.sendRedirect("Admin/adminDashboard.jsp");

			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
	


	}

}



		