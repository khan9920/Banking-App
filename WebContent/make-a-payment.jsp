			<%@ include file="re-usable.jsp"%>
            <div class="col-md-9 col-dash-body">

                <div class="dash-header">
                    <img src="assets/icons/icon_dashboard_make_a_payment.png" alt="Make a Payment Header Icon">
                    <h6>MAKE A PAYMENT</h6>
                </div>
                <div class="dash-body">
                    <div class="payment-category">
                        <form action="makePaymentdropdown" method="POST">
                            <h6 class="dash-title">Select from available payees</h6>
                            <select name="category" id="payees">
                                <option value="0">Select category</option>
                                <option value="Education">Education</option>
                                <option value="Electricity">Electricity</option>
                                <option value="Higher Education">Higher Education Institutes</option>
                                <option value="Internet">Internet</option>
                                <option value="Telephone">Telephone</option>
                                <option value="water Board">Water Board</option>

                            </select>
                            <select name="payeeOption" id="payees">
                                <option value="1">op1</option>
                                <option value="2">op2</option>
                                <option value="3">op3</option>
                                <option value="4">op4</option>
                            </select>
                    <button type="submit"  class="btn-orange">Make Payment</a>
              
                               
                        </form>
                    </div>

                    <div class="payments-hisroy">
                        <h6 class="dash-title">PAYMENT HISTORY</h6>
                        <table>
                            <tr>
                                <th>Category</th>
                                <th>Paid to</th>
                                <th>Account No</th>
                                <th>Amount</th>
                                <th>Date</th>
                            </tr>
                          
                                		<%
                                		makepaymentDao mk = new makepaymentDao();
                                		
                                 		ResultSet rs= mk.DisplayPayments(); 
                                    	while(rs.next())
                                    	{
                                    	%>	
                                   
                                        <tr>
                                        <td><%=rs.getString("v.name") %> </td>
                                        <td><%=rs.getString("v.options") %> </td>
                                        <td><%=rs.getString("vf.accountNo") %> </td>
                                        <td><%=rs.getString("vf.amount") %> </td>
                                        <td><%=rs.getString(5) %> </td>
                                     
                            			</tr>
                            			<% 
                                    	}
                                    	%>
                               
                        </table>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>