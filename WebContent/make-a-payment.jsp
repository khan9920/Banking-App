<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- Check whether session is set -->

    <%
    	if(session.getAttribute("bankID") == null ) {
    		response.sendRedirect("index.jsp");
    	}
    %>
    
    <!-- session check ends -->

<!DOCTYPE html>
<html lang="en">
<head>
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
</head>
<body>
    
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-icon-wrapper">
                	<form action="LogoutServlet" method="POST">
                		<a href="settings.jsp"><img src="assets/icons/icon_settings.png" alt="Settings Icon"></a>
                		<button type="submit" class="btn-logout"></button>
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
                            <h6>Shafkhan Mohamed</h6>
                            <p>Friday, 12 April 2019</p>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>BANKING OPTIONS</h6>
                            <ul>
                                <li><a href="dashboard.jsp">
                                    <img src="assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                    Dashboard
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>ACTIONS</h6>
                            <ul>
                                <li><a href="transfer-money.jsp">
                                    <img src="assets/icons/icon_transfer_money.png" alt="Transfer Monoey Icon">
                                    Transfer Money
                                </a></li>
                                <li class="active"><a href="make-a-payment.jsp">
                                    <img src="assets/icons/icon_make_a_payment.png" alt="Make a Payment Icon">
                                    Make a Payment
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>SUPPORT</h6>
                            <ul>
                                <li><a href="contact-us.jsp">
                                    <img src="assets/icons/icon_contact_us.png" alt="Contact Us Icon">
                                    Contact Us
                                </a></li>
                                <li><a href="help.jsp">
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
                        <form action="make-a-payment-form.jsp" method="POST">
                            <h6 class="dash-title">Select from available payees</h6>
                            <select name="payees" id="payees">
                                <option value="0">Select category</option>
                                <option value="1">Education</option>
                                <option value="2">Electricity</option>
                                <option value="3">Higher Education Institutes</option>
                                <option value="4">Internet</option>
                                <option value="5">Telephone</option>
                                <option value="6">Water Board</option>

                            </select>
                            <select name="payee-option" id="payees">
                                <option value="1">op1</option>
                                <option value="2">op2</option>
                                <option value="3">op3</option>
                                <option value="4">op4</option>
                            </select>
                            <button type="submit" class="btn-orange">Make Payment</a>
                        </form>
                    </div>

                    <div class="payments-hisroy">
                        <h6 class="dash-title">PAYMENT HISTORY</h6>
                        <table>
                            <tr>
                                <th>Category</th>
                                <th>Paid to</th>
                                <th>Date</th>
                                <th>Amount</th>
                            </tr>
                            <tr>
                                <td>Telehpone</td>
                                <td>Dialog Axiata</td>
                                <td>23.04.2019</td>
                                <td>1500.00 LKR</td>
                            </tr>
                            <tr>
                                <td>Telehpone</td>
                                <td>Dialog Axiata</td>
                                <td>23.04.2019</td>
                                <td>1500.00 LKR</td>
                            </tr>
                        </table>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>