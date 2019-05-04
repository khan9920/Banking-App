package com.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.bank.service.*;

 // Servlet implementation class addAdmin
 
@WebServlet("/addAdmin")
public class addAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addAdmin() {
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

			CreateAdminAcc adminACCOUNT = new CreateAdminAcc();

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
			adminACCOUNT.setCreateDate();
			adminACCOUNT.createUserID();
			adminACCOUNT.updateDB();

			response.sendRedirect("test.jsp");
			
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}

		
	}

}



		