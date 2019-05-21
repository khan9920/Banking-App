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

 // Servlet implementation class addAdmin
 
@WebServlet("/addAdmin")
public class addAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addAdmin() {
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

			//creating a object from CreateAdminAcc
			CreateAdminAcc adminACCOUNT = new CreateAdminAcc();

			//set value to the object using methoes & the details
			adminACCOUNT.setName(request.getParameter("fullname"));
			adminACCOUNT.setInitials(request.getParameter("nameWithInitials"));
			adminACCOUNT.setNIC(request.getParameter("NICno"));
            adminACCOUNT.setAddress(request.getParameter("address"));
            adminACCOUNT.setCity(request.getParameter("city"));
            adminACCOUNT.setBday(request.getParameter("birthday"));
            adminACCOUNT.setGender(request.getParameter("gender"));
            adminACCOUNT.setContact(Integer.parseInt(request.getParameter("contact")));
            adminACCOUNT.setPcode(Integer.parseInt(request.getParameter("pcode")));
            adminACCOUNT.setEmail(request.getParameter("email"));
            adminACCOUNT.setPassword(request.getParameter("password"));
			adminACCOUNT.setCreateDate(); //call the method for generate "create date & time"
			adminACCOUNT.createUserID(); //call the method for generate unique user id
			adminACCOUNT.updateDB(); //insert a new user to the database

			//redirect page to the dashboard after creating new user
			response.sendRedirect("Admin/adminDashboard.jsp");
			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}

		
	}

}



		