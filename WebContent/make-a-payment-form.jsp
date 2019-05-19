		<%String id = (String)session.getAttribute("bankID"); %>
            <%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">
                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_make_a_payment.png" alt="Make a Payment Header Icon">
                    <h6>MAKE A PAYMENT</h6>
                </div>
                <div class="dash-body">
                    <h6 class="dash-title">Effective Available Balance</h6>
                    
                       <%
                                		makepaymentDao mk = new makepaymentDao();
                                		
                                 		ResultSet rs= mk.DisplaycurrentBalance(id); 
                                    	while(rs.next())
                                    	{
                                    	%>	
                                   <h3><%=rs.getString("cBalance") %><span> LKR</span></h3>
                             
                            			<% 
                                    	}
                                    	%>
                    
                    
                  

                    <form name="form" action="makePaymentForm" method="POST" class="make-a-payment-form">
                        <div class="form-element-wrapper">
                            <p>Pay to</p> <span><% out.println(request.getParameter("category")); %></span> 
                        </div>
                            
                        <div class="form-element-wrapper">
                            <p>Amount</p>
                            <input type="number" name="amount">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Enter Account Number</p>
                            <input type="number" name="account">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Re-enter Account Number </p>
                            <input type="number" name="reaccount" id="re-acc-no">
                        </div>

                        <button type="submit" onclick="return validation();"  class="btn-orange btn-proceed" >Proceed</button>
                        
                     
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    
    <script type="text/javascript"> 
    function validation()
{ 
var amount = document.form.amount.value;	
 var account = document.form.account.value;
 var reaccount = document.form.reaccount.value;
 
 if (amount==null || amount=="")
 { 
 alert("please enter amount for transfer"); 
 return false; 
 }
 else if (account==null || account=="")
 { 
 alert("Please enter account number"); 
 return false; 
 }
 else if (reaccount==null || reaccount=="")
 { 
 alert("Please Re-enter account number"); 
 return false; 
 }
 else if (account != reaccount )
 { 
 alert("account number is not matching "); 
 return false; 
 }
 } 
</script> 
</body>
</html>