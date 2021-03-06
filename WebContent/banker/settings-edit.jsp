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
    <title>World Bank | Banker</title>
    
    <!-- Google fonts Montserrat 200, 400, 600, 700 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600,700" rel="stylesheet">

    <!-- Bootstrap CSS Framework 4.3.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link  rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/dashboard.css"> 
    <link rel="stylesheet" href="../css/dashboard/settings.css">
</head>
<body>
    
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-icon-wrapper">
                	<form action="LogoutServlet" method="POST">
                		<a href="settings.jsp"><img src="../assets/icons/icon_settings.png" alt="Settings Icon"></a>
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
								<li class="active"><a href="dashboard.jsp">							
									<img src="../assets/icons/icon_dashboard.png" alt="Dashboard Icon">
									Dashboard
								</a></li>
								<li><a href="transactions.jsp">
									<img src="../assets/icons/icon_admin_transaction.png" alt="Transactions Admin Icon">
									Transactions
								</a></li>
								<li><a href="customers.jsp">
									<img src="../assets/icons/icon_admin_customers.png" alt="Customers Admin Icon">
									Customers
								</a></li>
								<li><a href="support.jsp">
									<img src="../assets/icons/icon_admin_support.png" alt="Support Admin Icon">
									Support
								</a></li>
							</ul>
						</div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="../assets/icons/icon_dashboard_settings.png" alt="Settings Header Icon">
                    <h6>SETTINGS</h6>
                </div>

                <div class="row dash-body">
                    <div class="settings-wrapper">
                        <div class="col-md-12">
                            <form action="settings.jsp" method="POST">
                                <h6 class="dash-title">PERSONAL INFORMATION</h6>
                                <input type="text" value="Shafkhan Mohamed" placeholder="Full name">
                                <input type="text" value="24 Melford Crescent Dehiwela" placeholder="Address">
                                <input type="text" value="+94775867889" placeholder="Mobile">
                                <button class="btn-red">CANCEL</button>
                                <button type="submit" class="btn-orange">UPDATE</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>