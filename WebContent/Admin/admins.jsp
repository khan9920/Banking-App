<%ResultSet rs = (ResultSet)request.getAttribute("result");%>

                    <%@ include file="re-usable.jsp"%>
                    <div class="col-md-9 col-dash-body">

                        <div class="dash-header">
                            <img src="assets/icons/icon_dashboard_admin_transaction.png" alt="Transactions Header Icon">
                            <h6>ADMINS</h6>
                        </div>

                        <div class="row dash-body">
                            <div class="col-md-12">
                                <button class="btn-orange btn-add-user" onclick="location.href='Admin/add-admin.jsp' ">ADD ADMIN</button>
                                 <form action = "adminSearch" method = "post">
                                        <input type = "text" id = "searchBox" name = "search" placeholder = "search" style= "display:inline; width: 40%;">
                                        <input type = "submit" value = "search" style= "display:inline; width:7%;">
                                </form>
                            </div>
                            <div class="col-md-12">
                                <div class="transactions">
                                    <table>
                                        <tr>
                                            <th>Employee ID</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Mobile Number</th>
                                            <th>Branch</th>
                                            <th>Actions</th>
                                        </tr>
                                        <%while(rs.next()){
                                        	%>
                                        <tr>
                                            <td><%= rs.getString("adminID") %></td>
                                            <td><%= rs.getString("fullName") %></td>
                                            <td><%= rs.getString("email") %></td>
                                            <td><%= rs.getString("tpNO") %></td>
                                            <td><%= rs.getString("city") %></td>
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