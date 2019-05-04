package com.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import com.bank.service.*;

 // Servlet implementation class addCustomer
 
@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addCustomer() {
        super();
        // TODO Auto-generated constructor stub
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
		
			CreateCustomerAcc cusACCOUNT = new CreateCustomerAcc();

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
			cusACCOUNT.setCreateDate();
			cusACCOUNT.createUserID();
			cusACCOUNT.createAccNo();
			cusACCOUNT.updateDB();


		//	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("test.jsp");
		//	dispatcher.forward(request, response);

			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		
		}
	


	}

}



		