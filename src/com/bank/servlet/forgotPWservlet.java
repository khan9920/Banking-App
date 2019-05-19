package com.bank.servlet;

//import all the necessery packages
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.service.*;


@WebServlet("/forgotPWservlet")
public class forgotPWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public forgotPWservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        
		try {
			//create a object from the Authentication class
			Authentication Fpassword = new Authentication();
		
			Fpassword.setUserId(request.getParameter("USERid")); //call the methoed for set userID 
			Fpassword.setDigits(); //call the methoed for generate digits
			Fpassword.setUserEmail(); //call the methoed for get user's email from database
			Fpassword.sendEmail(); //call the methoed for send the email with the digits
			
			//convert the generated digits to string & store it in the variable
			String digits = Integer.toString(Fpassword.getDigits());
			//store th user id in the "id" variable
			String id = request.getParameter("USERid");
			
			//create a session & store the Digit & userId
			HttpSession session = request.getSession();
			session.setAttribute("DIGITS", digits);
			session.setAttribute("customerID", id);

			//redirect the file to new-password page
			response.sendRedirect("new-password.jsp");
		
		}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
