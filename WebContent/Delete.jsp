<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.DriverManager" %>
  
    <%@page import="java.sql.Statement" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>
<body>


<%
try{

String id=request.getParameter("d");
/*int no = Integer.parseInt(id);*/
Class.forName("com.mysql.jdbc.Driver");

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebank","root","");
Statement st = conn.createStatement();

st.executeUpdate("DELETE FROM contactus WHERE CustomerId = '"+id+"'");
response.sendRedirect("admin/support.jsp");

System.out.println("Data Deleted Successfully!");

}catch(Exception e){
	out.print(e.getMessage());
}
%>




</body>
</html>