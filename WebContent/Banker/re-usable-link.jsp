<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Banking.model.*, javax.servlet.ServletException" %>
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
    <link  rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="../css/admin/bankers.css">
	
	<script src = "../js/validation.js"></script>
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
                            <a href="settings.jsp"><img src="../assets/icons/icon_settings.png" alt="Settings Icon"></a>
                            <form id="logout" action="../logout" method="post" style = "display:inline">
   								<input type="hidden" name="re-logout" value="logout" />
    							<a href="#" onclick="document.getElementById('logout').submit();"><img src="../assets/icons/icon_logout.png" alt="Logout Icon"></a>
							</form>
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
                                    <h6>Banker <br><%= session.getAttribute("name") %></h6>
                                    <%    Date dNow = new Date( );
                                    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy");
                                    out.print( "<p>" + ft.format(dNow) + "</p>"); %>
                                </div>
                            
                                <div class="sidepanel-nav">
                                    <h6>BANKING OPTIONS</h6>
                                    <ul>
                                        <li class="active"><a href="bankerDashboard.jsp">
                                        <img src="../assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                        Dashboard
                                    </a></li>
                                    	
                                        <li><a href="transactions.jsp">
                                            <img src="../assets/icons/icon_admin_transaction.png" alt="Transactions Admin Icon">
                                            Transactions
                                        </a></li>
                                        <li>
                                    	<form id="customer" action="../CustDetailServlet" method="post">
                                    		<img src="../assets/icons/icon_admin_customers.png" alt="Customers Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="bankerCust" value="customer" />
    										<a href="#" onclick="document.getElementById('customer').submit();">Customers</a>
										</form>
                                        
                                    	</li>
                                        <li><a href="support.html">
                                        <img src="../assets/icons/icon_admin_support.png" alt="Support Admin Icon">
                                        Support
                                    	</a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>