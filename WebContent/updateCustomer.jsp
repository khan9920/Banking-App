
			<%@ include file="re-usable.jsp"%>
                    <div class="col-md-9 col-dash-body">

                        <div class="dash-header">
                            <img src="assets/icons/icon_dashboard_admin_transaction.png" alt="Transactions Header Icon">
                            <h6>UPDATE CUSTOMER DETAILS</h6>
                        </div>

                        <div class="row dash-body">
                            <form action="update" class="update" method = "post" name = "update">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h6 class="dash-title">PERSONAL INFO</h6>
                                    </div>
                                    <div class="col-md-6">
                                        <label>Email :</label>
                                        <input type="email" name="email" id="emailid" placeholder="Email">
                                        
                                        <label>Address :</label>
                                        <input type="text" name="address" id="addressid" placeholder="Address">
                                        
                                        <label>Postal Code :</label>
                                        <input type="text" name="pcode" id="pcodeid" placeholder="Postal Code">

                                                                                
                                        <label>City :</label>
                                        <input type="text" name="city" id="cityid" placeholder="City">
                                        
                                    </div>
                                    
                                    
                                    <div class="col-md-12">
                                        <button type="submit" class = "btn btn-orange" onclick="return myFunction()">Update</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>