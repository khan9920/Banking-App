package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/login")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    			
    			String bankID = request.getParameter("bId");
    			String password = request.getParameter("pass");
    			char fLetter = bankID.charAt(0);
    			String sql;
    			boolean isTrue = false;
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			
    			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_app","root","");
    			Statement st = conn.createStatement();
    			
    			if(fLetter == 'A') {
    				sql = "SELECT * FROM admin";
    				ResultSet rs = st.executeQuery(sql);
    				while(rs.next()) {
        				if(bankID.equals(rs.getString("adminID")) && password.equals(rs.getString("password"))) {
        					isTrue = true;
        					System.out.println("fucks bro");
        				}else {
        					response.sendRedirect("login.jsp");
        					System.out.println("bitch");
        				}
        			}
    			}
    			else if(fLetter == 'C') {
    				sql = "SELECT * FROM customer";
    				ResultSet rs = st.executeQuery(sql);
    				while(rs.next()) {
        				if(bankID.equals(rs.getString("custID")) && password.equals(rs.getString("password"))) {
        					isTrue = true;
        					System.out.println("fucks bro");
        				}else {
        					response.sendRedirect("login.jsp");
        					System.out.println("bitch");
        				}
        			}
    			}
    			if(fLetter == 'E') {
    				sql = "SELECT * FROM Employee";
    				ResultSet rs = st.executeQuery(sql);
    				while(rs.next()) {
        				if(bankID.equals(rs.getString("empID")) && password.equals(rs.getString("password"))) {
        					isTrue = true;
        					System.out.println("fucks bro");
        				}else {
        					response.sendRedirect("login.jsp");
        					System.out.println("bitch");
        				}
        			}
    			}
    			
    			
    			
    		}
    		catch(Exception e) {
    			System.out.print(e.getMessage());{
    			
				
			}
		}
	}

}
