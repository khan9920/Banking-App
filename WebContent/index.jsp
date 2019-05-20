<!-- Main pages and acts as the login
	 Call loginServlet on form submit
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Google fonts Montserrat 200, 400, 600 -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,600" rel="stylesheet">

        <!-- Fontawesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

        <!-- Bootstrap CSS Framework 4.3.1 -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Styles -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/forgotPass.css">
        <link rel="stylesheet" href="css/login.css">

        <!-- Title -->
        <title>World Bank | Login</title>
    </head>

    <body>
        

        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="heading-wrapper">
                            <i class="fas fa-university"></i> <h1>World Bank</h1>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur optio amet tempora suscipit magni quia exercitationem deserunt alias rerum tenetur impedit voluptas est placeat, corrupti voluptatibus vitae. Voluptatibus, nulla. Reiciendis.</p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="login-wrapper">
                            <p>LOGIN</p>
                            <form action="login" class="login" method = "post" name = "login"> 
                                <input type="text" id="bankId" placeholder="Banking ID" name = "bId" class = "bid">
                                <p style = "color: red; text-align: left; font-size: 14px;" class = "idError"></p>
                               
                                <input type="password" id="password" placeholder="Password" name = "pass" class = "pass">
                                <p style = "color: red; text-align: left; font-size: 14px;" class = "passError"></p>
                                
                                <!-- <input type = "submit" class="btn btn-orange" value = "login" > -->
                                <button type="submit" class = "btn btn-orange" onclick="return myFunction()">Submit</button>
                                <%-- <%if(session.getAttribute("bankID") == null){ %>
                                <p>Wrong Credentials</p>
                                <% }%> --%>
                                <a href="forgot-password.jsp">Forgot password?</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="footer-content">
                                <hr>
                                <p class="footer-para"> Bank name - Retail Version © year</p>
                                <a href="#" class="link about-us">About Us</a> <span class = "devide-span">|</span>
                                <a href="contact-us.html" class="link contact-us">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
  <script type="text/javascript">  
  function myFunction(){
	  var id = document.querySelector('.bid').value;
	  var pass = document.querySelector('.pass').value;
	  
	  if(id == ""){
		  var id = document.querySelector('.idError').innerHTML = "Please enter the bank ID";
		  return false;
	  }
	  if(pass == ""){
		  var id = document.querySelector('.passError').innerHTML = "Please enter the password";
		  return false;
	  }
	  if(pass.length < 8){
		  var id = document.querySelector('.passError').innerHTML = "Please check the length of the password";
		  return false;
	  }
  }
  
</script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src = "js/script.js"></script>
    </body>
</html>