<!-- Customer's dashboard, gets redirected from loginServlet -->
            <%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_header.png" alt="Dashboard Header Icon">
                    <h6>DASHBOARD</h6>
                </div>

                <div class="row dash-body">
                    <div class="col-md-12">
                        <div class="balance-wrapper">
                            <div class="bank-balanace-wrapper">
                            	<p class="acc-no-text">Account Number</p>
                                <h3 class="acc-no"><%= session.getAttribute("acc") %></h3>
                            </div>
                            <div class="balance">
                            <%
                            	DisplayTransactionService display = new DisplayTransactionService();
                            		ResultSet rslt1 = display.Display(session.getAttribute("bankID").toString());                                                
                            		while(rslt1.next()){
                            			String balance = rslt1.getString("cBalance");
                            %>
                                <p>Balance</p>
                                <h3><%= balance %><span> LKR</span></h3>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="col-md-12">
					<div class="transactions transactions-table">                
						<table>
							<tr>
								<th>Transaction ID</th>
								<th>Transferred to</th>
                                <th>Sender Remark</th>
                                <th>Date</th>
                                <th>Amount (LKR)</th>
                            </tr>
                           		<% 
                           			ResultSet rslt2 = display.DisplayTransaction(session.getAttribute("acc").toString());
                           			while(rslt2.next()){
                           		%>
                             <tr>
	                             <td><%= "WBTR00"+rslt2.getString("transactionID").toString() %></td>
	                             <td><%=  rslt2.getString("recieverAccNo") %></td>
	                             <td><%=  rslt2.getString("senderRem") %></td>
	                             <td><%=  rslt2.getString("transactionDate")%></td>
	                             <td><%=  rslt2.getString("amount")%></td>
                             </tr>          
                              	<% }%>
                          </table>                        
                     </div>
                 </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>