<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Banking.model.*, javax.servlet.ServletException" %> 
    <%@page import="com.Banking.service.*" %>   
    <%@page import="java.sql.DriverManager" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.Statement" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>World Bank | Dashboard</title>
    
    <!-- Google fonts Montserrat 200, 400, 600, 700 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600,700" rel="stylesheet">

    <!-- Bootstrap CSS Framework 4.3.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link  rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="../css/dashboard/make-a-payment.css">
    <link rel="stylesheet" href="../css/dashboard/make-a-payment-form.css">
     <link rel="stylesheet" href="../css/contact-us.css">
</head>
<body>

<% if(session.getAttribute("bankID") == null){
	response.sendRedirect("index.jsp");
}
%>

<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-icon-wrapper">
                    <a href="settings.jsp"><img src="../assets/icons/icon_settings.png" alt="Settings Icon"></a>
                    <!-- Call the servlet for logout -->
                    <a href="logout"><img src="../ssets/icons/icon_logout.png" alt="Logout Icon"></a> 
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
                            <h6><%= session.getAttribute("name") %> </h6>
                            <p>Friday, 12 April 2019</p>
                        </div>
                        <div class="sidepanel-nav">
                            <h6>BANKING OPTIONS</h6>
                            <ul><li>
								<a href="dashboard.jsp">
                                    <img src="../assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                    Dashboard
                                </a>
								</li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>ACTIONS</h6>
                            <ul>
                                <li><a href="transfer-money.jsp">
                                    <img src="../assets/icons/icon_transfer_money.png" alt="Transfer Monoey Icon">
                                    Transfer Money
                                </a></li>
                                <li><a href="make-a-payment.jsp">
                                    <img src="../assets/icons/icon_make_a_payment.png" alt="Make a Payment Icon">
                                    Make a Payment
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>SUPPORT</h6>
                            <ul>
                                <li><a href="contact-us.jsp">
                                    <img src="../assets/icons/icon_contact_us.png" alt="Contact Us Icon">
                                    Contact Us
                                </a></li>
                                <li><a href="help.jsp">
                                    <img src="../assets/icons/icon_help.png" alt="Help Icon">
                                    Help
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="../assets/icons/icon_dashboard_header.png" alt="Dashboard Header Icon">
                    <h6>Transfer Money</h6>
                </div>

                <div class="row dash-body">
                    <div class="col-md-12">
                        <div class="balance-wrapper">
                            <h4 style="color: red; text-align: left; font-size: 14px; font-weight: 600">No such account number exists, please try again</h4>
                            <button type="button" class="btn-orange"  onclick="location.href = '../transfer-money.jsp';" >Try again</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>