<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.ResultSet" %> 
    <%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>World Bank | Admin</title>
    
    <!-- Google fonts Montserrat 200, 400, 600, 700 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600,700" rel="stylesheet">

    <!-- Bootstrap CSS Framework 4.3.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link  rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/dashboard.css">
    <link rel="stylesheet" href="css/admin/customers.css" type = "text/css">

</head>
<body>
<% if(session.getAttribute("bankID") == null){
	response.sendRedirect("../login.jsp");
	}
	
	%>

<div class="dashboard">
    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="header-icon-wrapper">
                        <a href="settings.html"><img src="assets/icons/icon_settings.png" alt="Settings Icon"></a>
                        <a href="logout"><img src="assets/icons/icon_logout.png" alt="Logout Icon"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="section">
        <div class="container-fluid">
            <div class="row">
            <div class="col-md-3 col-sidepanel">

                    <div class="sidepanel">
                        <div class="sidepanel-wrapper">
                            <div class="userprofile-wrapper">
                                <h6>Administrator <br><%= session.getAttribute("name") %></h6>
                                <p><%    Date dNow = new Date( );
                                    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy");
                                    out.print( "<p>" + ft.format(dNow) + "</p>"); %></p>
                            </div>
                        
                            <div class="sidepanel-nav">
                                <h6>BANKING OPTIONS</h6>
                                <ul>
                                    <li class="active">
                                        <a href="Admin/adminDashboard.jsp">
                                        <img src="assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                        Dashboard
                                    </a>
                                    </li>
                                    <li><a href="transactions.html">
                                        <img src="assets/icons/icon_admin_transaction.png" alt="Transactions Admin Icon">
                                        Transactions
                                    </a></li>
                                    <li>
                                    	<form id="customer" action="CustDetailServlet" method="post">
                                    		<img src="assets/icons/icon_admin_customers.png" alt="Customers Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="adminCust" value="customer" />
    										<a href="#" onclick="document.getElementById('customer').submit();">Customers</a>
										</form>
                                        
                                    </li>
                                    <li><a href="support.html">
                                        <img src="assets/icons/icon_admin_support.png" alt="Support Admin Icon">
                                        Support
                                    </a></li>
                                </ul>
                            </div>

                            <div class="sidepanel-nav">
                                <h6>EMPLOYEE OPTIONS</h6>
                                <ul>
                                    <li><form id="employee" action="BankDetailServlet" method="post">
                                    		<img src="assets/icons/icon_admin_bankers.png" alt="Bankers Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="someName" value="helloworld" />
    										<a href="#" onclick="document.getElementById('employee').submit();">Bankers</a>
										</form>
                                   </li>
                                    <li><form id="admin" action="AdminDetailServlet" method="post">
                                    		<img src="assets/icons/icon_admin_admins.png" alt="Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="someName" value="helloworld" />
    										<a href="#" onclick="document.getElementById('admin').submit();">Admins</a>
										</form>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>