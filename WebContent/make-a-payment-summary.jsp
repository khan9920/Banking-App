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
                    
                    
                    

                    <h6 class="dash-title">TRANSACTION SUMMARY</h6>
                    <div class="transaction-summary">
                        <div class="make-a-payment-summary-element">
                            <p class="title">Transfer Amount : </p>
                            <span><% out.println(request.getParameter("amount"));%></span>
                        </div>
                            
                        <div class="make-a-payment-summary-element">
                            <p class="title">Sender Remarks : </p>
                            <span>.....</span>
                        </div>

                        <div class="make-a-payment-summary-element">
                            <p class="title">Beneficiary Remarks : </p>
                            <span></span>
                        </div>

                        <div class="make-a-payment-summary-element">
                            <p class="title">Account Number : </p>
                            <span><%out.println(request.getParameter("account")); %></span>
                        </div>
                    </div>

                    <form action="BankLog" method="post" class="make-a-payment transfer-confirm">
                        <h6 class="dash-title">CONFIRM TRANSACTION</h6>
                        <div class="form-element-wrapper">
                            <p>Banking ID</p>
                            <input type="text" name="id">
                        </div>
                            
                        <div class="form-element-wrapper">
                            <p>Password</p>
                            <input type="password" name="password">
                        </div>

                        <button type="submit" class="btn-orange">CONFIRM</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>




</body>
</html>