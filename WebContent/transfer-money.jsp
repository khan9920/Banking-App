            <%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">
                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_header.png" alt="Dashboard Header Icon">
                    <h6>Transfer Money</h6>
                </div>
                <div class="dash-body">
                    <h6 class="dash-title">Effective Available Balance</h6>
                    <%
                    	DisplayTransactionService display = new DisplayTransactionService();
                    		ResultSet rslt = display.Display(session.getAttribute("bankID").toString());
                    		while(rslt.next()){
                    			Double balance = rslt.getDouble("cBalance");
                    %>
                    <h3><%= balance %></span> LKR</h3>
                    <% } %>

                    <form action="TransactionServlet" method="POST" class="transfer-form">
                        <div class="form-element-wrapper">
                        	<p style = "color: red; text-align: left; font-size: 14px; font-weight: 600" id="errorCommon"></p><br>
                            <p>Transfer Amount</p>
                            <input type="number" step="0.01"name="amount" id="amount">
                             
                        </div>
                            
                        <div class="form-element-wrapper">
                            <p>Sender Remarks</p>
                            <input type="text" name="senderRemark" maxlength="15" placeholder="(Optional)">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Beneficiary Remarks</p>
                            <input type="text" name="beneficiaryRemark" maxlength="15" placeholder="(Optional)">
                        </div>
                        
                        <div class="form-element-wrapper">
                        	<p style = "color: red; text-align: left; font-size: 14px; font-weight: 600" id="errorAccNo"></p><br>
                            <p>Account Number </p>
                            <input type="number" name="accountNumber" id="accNo">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Re-enter Account Number </p>
                            <input type="number" name="re-acc-number" id="reAccNo">
                        </div>

                        <button type="submit" class="btn-orange btn-proceed"  onclick="return validateForm()">Proceed</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/transferFormValidation.js"></script>
</body>
</html>