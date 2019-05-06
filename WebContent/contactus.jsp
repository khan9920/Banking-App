<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>World Bank | Contact Us</title>
    
     <!-- Fontawesome -->
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!-- Google fonts Montserrat 200, 400, 600, 700 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600,700" rel="stylesheet">

    <!-- Bootstrap CSS Framework 4.3.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link  rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/dashboard.css"> 
    <link rel="stylesheet" href="css/contact-us.css">

<script type="text/javascript"> 
function validation()
{ 
var CustomerId = document.form.CustomerId.value;	
 var Firstname = document.form.firstname.value;
 var Lastname = document.form.lastname.value;
 var email = document.form.email.value; 
 var subject= document.form.subject.value;
 
 
 if (CustomerId==null || CustomerId=="")
 { 
 alert("CustomerID can't be blank"); 
 return false; 
 }
 else if (Firstname==null || Firstname=="")
 { 
 alert("firstname can't be blank"); 
 return false; 
 }
 else if (Lastname==null || Lastname=="")
 { 
 alert("last can't be blank"); 
 return false; 
 }
 else if(email==null || email=="")
 { 
 alert("please enter email address"); 
 return false; 
 } 
 else if (subject==null || subject=="null")
 { 
 alert("please write message "); 
 return false; 
 } 
 } 
</script> 



<title>Contact Us</title>
</head>
<body>

<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-icon-wrapper">
                    <a href="settings.html"><img src="assets/icons/icon_settings.png" alt="Settings Icon"></a>
                    <a href="index.html"><img src="assets/icons/icon_logout.png" alt="Logout Icon"></a>
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
                                <li><a href="make-a-payment.jsp">
                                    <img src="assets/icons/icon_make_a_payment.png" alt="Make a Payment Icon">
                                    Make a Payment
                                </a></li>
                            </ul>
                        </div>
                
                        <div class="sidepanel-nav">
                            <h6>SUPPORT</h6>
                            <ul>
                                <li class="active"><a href="contact-us.html">
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
                    <img src="assets/icons/icon_dashboad_contact_us.png" alt="Contact Us Header Icon">
                    <h6>CONTACT US</h6>
                </div>

                <div class="row dash-body">
                    <div class="col-md-12">
                        <p>Contact us about anything related to our Bank or services, we'll do our best to get back to you as soon as posible, We are always ready to help you out regarding all your queries. Send us a message via the form below or you can email or call us.</p>
                    </div>
                    <div class="col-md-6">
                        <div class="contact-wrapper">
                            <h6>HEAD OFFICE</h6>
                            <hr>
                            <div class="row row-contact-options">
                                <div class="col-md-6">
                                    <h6 class="h6-black">Call us on</h6>
                                    <a href="tel:+94112462462">+94 112 462462</a>
                                </div>
                                <div class="col-md-6">
                                    <h6 class="h6-black">Fax</h6>
                                    <a href="tel:+94112462462">+94 112 462462</a>
                                </div>
                                <div class="col-md-12">
                                    <h6 class="h6-black">Email us at</h6>
                                    <a href="mailto:chaos@gmail.com">chaos@gmail.com</a>
                                </div>
                                <div class="col-md-6">
                                    <h6 class="h6-black">Write to</h6>
                                    <address>Head of Customer Experience, <br>  No 567, <br> T.B Jaya mawatha, <br> Colombo 7</address>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="contact-wrapper">
                            <div class="contactus-container">
                                <h6>SEND US A MESSAGE</h6>
                                    <hr>
                                    <form name="form" action="contactus" method="post"   class="contactus"  >
                                     	<input type="text" name="CustomerId" class = "input" id = "Customer Id" placeholder="Customer ID">
                                        <input type="text" name="firstname" class = "input" id = "fist-name" placeholder="First Name">
                                        <input type="text" name="lastname"  class = "input" id="last-name" placeholder="Last Name">
                                        <input type="email" name="email" class = "input" id="email" placeholder="Email">
                                        <textarea id="subject" class="input" name="subject" placeholder="Write something.."required></textarea>
                                        <button  type="submit" onclick="return validation();" class="btn btn-orange">Submit</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    






</body>
</html>