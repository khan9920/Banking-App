            <%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">
                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_header.png" alt="Dashboard Header Icon">
                    <h6>Transfer Money</h6>
                </div>
                <div class="dash-body">
                    <h6 class="dash-title">Effective Available Balance</h6>
                    <h3><%= session.getAttribute("bal") %>LKR</span></h3>

                    <form action="TransactionServlet" method="POST" class="transfer-form">
                        <div class="form-element-wrapper">
                            <p>Transfer Amount</p>
                            <input type="number" name="amount" id="amount">
                        </div>
                            
                        <div class="form-element-wrapper">
                            <p>Sender Remarks</p>
                            <input type="text" name="senderRemark" placeholder="(Optional)">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Beneficiary Remarks</p>
                            <input type="text" name="beneficiaryRemark" placeholder="(Optional)">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Account Number </p>
                            <input type="text" name="accountNumber" id="acc-no">
                        </div>
                        
                        <div class="form-element-wrapper">
                            <p>Re-enter Account Number </p>
                            <input type="text" name="re-acc-number" id="re-acc-no">
                        </div>

                        <button type="submit" class="btn-orange btn-proceed" name="btnSubmit">Proceed</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>