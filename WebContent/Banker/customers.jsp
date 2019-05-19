                <%@ page import = "java.sql.ResultSet" %> 
  <% ResultSet rs = (ResultSet)request.getAttribute("result");%>
                    <%@ include file="re-usable.jsp"%>
                    <div class="col-md-9 col-dash-body">

                        <div class="dash-header">
                            <img src="assets/icons/icon_dashboard_admin_transaction.png" alt="Transactions Header Icon">
                            <h6>CUSTOMERS</h6>
                        </div>

                        <div class="row dash-body">
                            <div class="col-md-12">
                                <button class="btn-orange btn-add-user" onclick="location.href='Banker/add-customer.jsp' ">ADD CUSTOMER</button>
                                <form action = "searchCustomer" method = "post">
                                        <input type = "text" id = "searchBox" name = "search" placeholder = "search" style= "display:inline; width: 40%;">
                                        <input type = "submit" value = "search" name = "submitBanker" style= "display:inline; width:7%;">
                                </form>
                            </div>
                            <div class="col-md-12">
                                <div class="transactions">
                                    
                                    <table>
                                        <tr>
                                            <th>Customer ID</th>
                                            <th>Name</th>
                                            <th>Account Number</th>
                                            <th>NIC</th>
                                            <th>Actions</th>
                                        </tr>
                                        <%
                                        	while(rs.next()){
                                        		
                                        %>
                                        <tr>
                                        	<td><%= rs.getString("custID") %></td>
                                        	<td><%= rs.getString("fullName") %></td>
                                        	<td><%= rs.getString("accountNo") %></td>
                                        	<td><%= rs.getString("NIC") %></td>
                                        	<td>
                                                <a href="edit-customer.html"><img src="assets/icons/icon_admin_edit.png" alt="Edit Icon"></a>
                                                 <a href="delete-customer.html"><img src="assets/icons/icon_admin_delete.png" alt="Delete Icon"></a>
                                            </td>
                                        </tr>
                                        
                                        <%} %>
                                    </table>                        
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