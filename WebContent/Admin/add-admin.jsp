<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</head>
<body>
    <div class="dashboard">
        <div class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="header-icon-wrapper">
                            <a href="settings.jsp"><img src="../assets/icons/icon_settings.png" alt="Settings Icon"></a>
                            <a href="#"><img src="../assets/icons/icon_logout.png" alt="Logout Icon"></a>
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
                                    <h6>Administrator <br>Jon Snow</h6>
                                    <%    Date dNow = new Date( );
                                    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy");
                                    out.print( "<p>" + ft.format(dNow) + "</p>"); %>
                                </div>
                            
                                <div class="sidepanel-nav">
                                    <h6>BANKING OPTIONS</h6>
                                    <ul>
                                        <li><a href="dashboard.jsp">
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

                                <div class="sidepanel-nav">
                                    <h6>EMPLOYEE OPTIONS</h6>
                                    <ul>
                                        <li><a href="bankers.jsp">
                                            <img src="../assets/icons/icon_admin_bankers.png" alt="Bankers Admin Icon">
                                            Bankers
                                        </a></li>
                                        <li class="active"><a href="admins.jsp">
                                            <img src="../assets/icons/icon_admin_admins.png" alt="Admin Icon">
                                            Admins
                                        </a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 col-dash-body">

                        <div class="dash-header">
                            <img src="../assets/icons/icon_dashboard_admin_transaction.png" alt="Transactions Header Icon">
                            <h6>ADD ADMIN</h6>
                        </div>

                        <div class="row dash-body">
                            <form action="addAdmin" method="POST">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h6 class="dash-title">PERSONAL INFO</h6>
                                    </div>
                                    <div class="col-md-6">
                                        <label>Full Name :</label>
                                        <input type="text" name="fullname" id="fullnameid" placeholder="Full Name">
                                        
                                        <label>Initials:</label>
                                        <input type="text" name="nameWithInitials" id="Initialsid" placeholder="Name with Initials">
                                        
                                        <label>NIC No :</label>
                                        <input type="text" name="NICno" id="nicNOid" placeholder="NIC No">

                                        <label>Address :</label>
                                        <input type="text" name="address" id="addressid" placeholder="Address">
                                                                                
                                        <label>City :</label>
                                        <input type="text" name="city" id="cityid" placeholder="City">
                                        
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label class="birthday">Birthday :</label>
                                        <input type="text" name="birthday" id="birthdayid" placeholder="dd/mm/yy">
                                            
                                        <label>Gender :</label>
                                        <input type="radio" name="gender" id="genderMale" value="male" checked>Male
                                        <input type="radio"  name="gender" id="genderFemale" value="female">Female
										<br>
                                        <label class="contact">Contact :</label>
                                        <input type="text" name="contact" id="contactid" placeholder="Telephone Number">

                                        <label>Postal Code :</label>
                                        <input type="text" name="pcode" id="pcodeid" placeholder="Postal Code">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <h6 class="dash-title">ACCOUNT INFORMATION</h6>
                                    </div>
                                    <div class="col-md-6">
                                        <label>Email :</label>
                                        <input type="email" name="email" id="emailid" placeholder="Email">
                                        
                                        <label>Password :</label>
                                        <input type="password" name="password" id="passwordid" placeholder="Password">
                                        
                                        <label>Confirm Password :</label>
                                        <input type="password" name="cpassword" id="cpasswordid" placeholder="Confirm Password">
                                    </div>
                                    <div class="col-md-12">
                                        <button class="btn-orange"  type="submit" name="btnSubmit">Create Account</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>