<!-- Customer's dashboard, gets redirected from loginServlet -->
            <%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_header.png" alt="Dashboard Header Icon">
                    <h6>DASHBOARD</h6>
                </div>

                <div class="row dash-body">
                    <div class="col-md-6">
                        <div class="balance-wrapper">
                            <div class="bank-balanace-wrapper">
                                <p class="acc-no"><%= session.getAttribute("acc") %></p>
                            </div>
                            <div class="balance">
                                <p>Balance</p>
                                <h3> <%= session.getAttribute("bal") %><span>LKR</span></h3>
                            </div>
                            <div class="recent-transaction">
                                <p>Recent Transactions</p>
                                <div class="debit">
                                    <p>1000.00</p> <img src="assets/icons/icon_minus.png" alt="Minus Icon"> <br>
                                    <p class="transation-date">23.03.2019</p>
                                </div>
                                <div class="credit">
                                    <p>1350.00</p> <img src="assets/icons/icon_plus.png" alt="Plus Icon"> <br>
                                    <p class="transation-date">23.03.2019</p>
                                   	<%-- <%}} %> --%>
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