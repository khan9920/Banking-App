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

 // Servlet implementation class addEmpolyee
 
@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addEmployee() {
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

			//creating a object from CreateEmployeeAcc
			CreateEmployeeAcc empACCOUNT = new CreateEmployeeAcc();

			//set value to the object using methoes & the details
			empACCOUNT.setName(request.getParameter("fullname"));
			empACCOUNT.setInitials(request.getParameter("nameWithInitials"));
			empACCOUNT.setNIC(request.getParameter("NICno"));
            empACCOUNT.setAddress(request.getParameter("address"));
            empACCOUNT.setCity(request.getParameter("city"));
            empACCOUNT.setBday(request.getParameter("birthday"));
            empACCOUNT.setGender(request.getParameter("gender"));
            empACCOUNT.setContact(Integer.parseInt(request.getParameter("contact")));
            empACCOUNT.setPcode(Integer.parseInt(request.getParameter("pcode")));
            empACCOUNT.setEmail(request.getParameter("email"));
            empACCOUNT.setPassword(request.getParameter("password"));
			empACCOUNT.setCreateDate(); //call the method for generate "create date & time"
			empACCOUNT.createUserID(); //call the method for generate unique user id
			empACCOUNT.updateDB(); //insert a new user to the database

			//redirect page to the dashboard after creating new user
			response.sendRedirect("Admin/adminDashboard.jsp");

			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}

	}

}



		