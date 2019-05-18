<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.worldbank.dao.*" %>   
    <%@page import="java.sql.DriverManager" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.Statement" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>World Bank | Make a Payment</title>
    
    <!-- Google fonts Montserrat 200, 400, 600, 700 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600,700" rel="stylesheet">

    <!-- Bootstrap CSS Framework 4.3.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link  rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/dashboard.css"> 
    <link rel="stylesheet" href="css/dashboard/make-a-payment.css">
<title>Insert title here</title>
</head>
<body>

    
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-icon-wrapper">
                    <a href="settings.html"><img src="assets/icons/icon_settings.png" alt="Settings Icon"></a>
                    <a href="#"><img src="assets/icons/icon_logout.png" alt="Logout Icon"></a>
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
                            <h6>Shafkhan Mohamed</h6>
                            <p>Friday, 12 April 2019</p>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>BANKING OPTIONS</h6>
                            <ul>
                                <li><a href="dashboard.html">
                                    <img src="assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                    Dashboard
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>ACTIONS</h6>
                            <ul>
                                <li><a href="transfer-money.html">
                                    <img src="assets/icons/icon_transfer_money.png" alt="Transfer Monoey Icon">
                                    Transfer Money
                                </a></li>
                                <li class="active"><a href="make-a-payment.html">
                                    <img src="assets/icons/icon_make_a_payment.png" alt="Make a Payment Icon">
                                    Make a Payment
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>SUPPORT</h6>
                            <ul>
                                <li><a href="contactus.jsp">
                                    <img src="assets/icons/icon_contact_us.png" alt="Contact Us Icon">
                                    Contact Us
                                </a></li>
                                <li><a href="help.html">
                                    <img src="assets/icons/icon_help.png" alt="Help Icon">
                                    Help
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_make_a_payment.png" alt="Make a Payment Header Icon">
                    <h6>MAKE A PAYMENT</h6>
                </div>
                <div class="dash-body">
                    <div class="payment-category">
                        <form action="makePaymentdropdown" method="POST">
                            <h6 class="dash-title">Select from available payees</h6>
                            <select name="category" id="payees">
                                <option value="0">Select category</option>
                                <option value="Education">Education</option>
                                <option value="Electricity">Electricity</option>
                                <option value="Higher Education">Higher Education Institutes</option>
                                <option value="Internet">Internet</option>
                                <option value="Telephone">Telephone</option>
                                <option value="water Board">Water Board</option>

                            </select>
                            <select name="payeeOption" id="payees">
                                <option value="1">op1</option>
                                <option value="2">op2</option>
                                <option value="3">op3</option>
                                <option value="4">op4</option>
                            </select>
                    <button type="submit"  class="btn-orange">Make Payment</a>
              
                               
                        </form>
                    </div>

                    <div class="payments-hisroy">
                        <h6 class="dash-title">PAYMENT HISTORY</h6>
                        <table>
                            <tr>
                                <th>Category</th>
                                <th>Paid to</th>
                                <th>Account No</th>
                                <th>Amount</th>
                                <th>Date</th>
                            </tr>
                          
                                		<%
                                		makepaymentDao mk = new makepaymentDao();
                                		
                                 		ResultSet rs= mk.DisplayPayments(); 
                                    	while(rs.next())
                                    	{
                                    	%>	
                                   
                                        <tr>
                                        <td><%=rs.getString("v.name") %> </td>
                                        <td><%=rs.getString("v.options") %> </td>
                                        <td><%=rs.getString("vf.accountNo") %> </td>
                                        <td><%=rs.getString("vf.amount") %> </td>
                                        <td><%=rs.getString(5) %> </td>
                                     
                            			</tr>
                            			<% 
                                    	}
                                    	%>
                               
                        </table>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>