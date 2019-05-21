<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

<div class="sidepanel">
                            <div class="sidepanel-wrapper">
                                <div class="userprofile-wrapper">
                                    <h6>Administrator <br><%= session.getAttribute("name") %></h6>
                                    <!--Displaying Date using java-->
                                    <%    Date dNow = new Date( );
                                    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy");
                                    out.print( "<p>" + ft.format(dNow) + "</p>"); %>
                                </div>
                            
                                <div class="sidepanel-nav">
                                    <h6>BANKING OPTIONS</h6>
                                    <ul>
                                        <li><a href="adminDashboard.jsp">
                                            <img src="../assets/icons/icon_dashboard.png" alt="Dashboard Icon">
                                            Dashboard
                                        </a></li>
                                        <li><a href="transactions.jsp">
                                            <img src="../assets/icons/icon_admin_transaction.png" alt="Transactions Admin Icon">
                                            Transactions
                                        </a></li>
                                        <li>
										<form id="customer" action="../CustDetailServlet" method="post">
                                    		<img src="../assets/icons/icon_admin_customers.png" alt="Customers Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="adminCust" value="customer" />
    										<a href="#" onclick="document.getElementById('customer').submit();">Customers</a>
										</form>
                                        </li>
                                        <li><a href="support.jsp">
                                            <img src="../assets/icons/icon_admin_support.png" alt="Support Admin Icon">
                                            Support
                                        </a></li>
                                    </ul>
                                </div>

                                <div class="sidepanel-nav">
                                    <h6>EMPLOYEE OPTIONS</h6>
                                    <ul>
                                        <li>
                                        <form id="employee" action="../BankDetailServlet" method="post">
                                    		<img src="../assets/icons/icon_admin_bankers.png" alt="Bankers Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="someName" value="helloworld" />
    										<a href="#" onclick="document.getElementById('employee').submit();">Bankers</a>
										</form></li>
                                        <li class="active">
                                        <form id="admin" action="../AdminDetailServlet" method="post">
                                    		<img src="../assets/icons/icon_admin_admins.png" alt="Admin Icon" style = "padding-right: 10px">
   											<input type="hidden" name="someName" value="helloworld" />
    										<a href="#" onclick="document.getElementById('admin').submit();">Admins</a>
										</form></li>
                                    </ul>
                                </div>
                            </div>
                        </div>