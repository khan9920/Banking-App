//package com.addDB;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
///*import java.sql.SQLException;*/
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class addToDb
// */
//@WebServlet("/addToDb")
//public class addToDb extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public addToDb() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//doGet(request, response);
//		
//		PrintWriter out = response.getWriter();
//		String uname = request.getParameter("uname");
//		String email = request.getParameter("email");
//	
//	try {
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
//		Statement st = conn.createStatement();
//		
//		String sql = "INSERT INTO contactsus (name, email) VALUES ('"+uname+"', '"+email+"')";
//		String sql2 = "SELECT * FROM contactsus";
//				
//		st.executeUpdate(sql);
//		ResultSet rs = st.executeQuery(sql2);
//		ArrayList <String> name = new ArrayList<String>();
//		while(rs.next())
//		 {
//		 name.add(rs.getString("name"));
//		}
//		for(int i = 0, size = name.size(); i < size; i ++)
//		{
//		   System.out.println("At index " + i + " our text is: " + name.get(i));
//		}
//		
//		}catch(Exception e) {
//		out.print(e.getMessage());
//	
//	}
//	}
//
//}
