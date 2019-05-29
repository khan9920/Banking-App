<%@ include file="re-usable.jsp"%>
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
   	

</body>
</html>