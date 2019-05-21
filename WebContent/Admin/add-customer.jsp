<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
    

<!DOCTYPE html>
<html lang="en">
<head>
    
    <jsp:include page="../views/tags.jsp"></jsp:include>	
    
</head>
<body>
    <div class="dashboard">
        
        <jsp:include page="../views/header.jsp"></jsp:include>

        <div class="section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3 col-sidepanel">
                        
                        <jsp:include page="../views/sidePanal.jsp"></jsp:include>
                      
                    </div>
                    <div class="col-md-9 col-dash-body">

                        <div class="dash-header">
                            <img src="../assets/icons/icon_dashboard_admin_transaction.png" alt="Transactions Header Icon">
                            <h6>ADD CUSTOMER</h6>
                        </div>

                        <div class="row dash-body">
                            <form action="../addCustomer" onsubmit="return formValidation()" method="POST">
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