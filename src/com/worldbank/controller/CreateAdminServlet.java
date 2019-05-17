package com.worldbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldbank.dao.CreateAdmin;

/**
 * Servlet implementation class CreateAdminServlet
 */
@WebServlet("/CreateAdminServlet")
public class CreateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdminServlet() {
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
		try {

			CreateAdmin adminACCOUNT = new CreateAdmin();

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

			response.sendRedirect("admin/admins.jsp");
			
		}catch(Exception e) {
			System.out.println(e);
		
		}
	}

}
