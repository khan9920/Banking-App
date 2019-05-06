package com.bank.service;

import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*;
import com.bank.dao.*;
import com.bank.model.*;


public class CreateCustomerAcc implements iCreateAccount{

    private String userID;
    private String name;
    private String initials;
    private String nic;
    private String address;
    private String city;
    private int pcode;
    private String bday;
    private String gender;
    private int contact;
    private String Cemail;
    private String password;
    private String createDateNtime;
    private int accNo;
    boolean Loop;

    public void setName(String Name){
        name = Name;
    };

    public void setInitials(String Initials){
        initials = Initials;
    };
    
    public void setNIC(String NIC){
        nic = NIC;
    };
    
    public void setAddress(String Address){
        address = Address;
    };
    
    public void setCity(String City){
        city = City;
    };
    
    public void setBday(String Bday){
        bday = Bday;
    };
    
    public void setGender(String Gender){
        gender = Gender;
    };
    
    public void setContact(int Contact){
        contact = Contact;
    };
    
    public void setPcode(int Pcode){
        pcode = Pcode;
    };
    
    public void setEmail(String Email){
        Cemail = Email;
    };
    
    public void setPassword(String Password){
        password = Password;
    };
    
    public void setCreateDate(){
        Date dNow = new Date();
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        createDateNtime = ft.format(dNow);
    };
    
    public void createUserID(){

        try {

            dbConnection con = new dbConnection();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            do{
            Random rand = new Random();
	    	int random = rand.nextInt((999999 - 100000) + 1) + 100000;
	    	String randomID = Integer.toString(random);
            userID = "C"+randomID;

            
	    	String sql = "SELECT custID FROM customer";
	    	ResultSet rs = st.executeQuery(sql);
	    	    while(rs.next()) { // loop through the results of the query
	    		    if(userID.equals(rs.getString("custID")))
                        Loop = true;
                    else
                        Loop = false;
                }
            }while(Loop);
        }catch(Exception e) {
            System.out.println(e);
        }
    };

    public void createAccNo(){
    	

        try {

            dbConnection con = new dbConnection();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            do{
            Random rand = new Random();
            int randomACC = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
            accNo = randomACC;
            String acc = String.valueOf(accNo);
            
	    	String sql = "SELECT custID FROM customer";
	    	ResultSet rs = st.executeQuery(sql);
	    	    while(rs.next()) { // loop through the results of the query
	    		    if(acc.equals(rs.getString("accountNumber")))
                        Loop = true;
                    else
                        Loop = false;
                }
            }while(Loop);
        }catch(Exception e) {
            System.out.println(e);
        }

    };
    
    public void updateDB(){

    	try {
        	
            dbConnection con = new dbConnection();
            Connection conn = con.toConnect();
            

            Statement st = conn.createStatement();
    			
            String sql = "INSERT INTO customer(custID,fullName,initials,NIC,address,city,postalCode,gender,tpNO,email,password,accountNumber,Birthday,createDate) VALUES ('"+userID+"', '"+name+"', '"+initials+"', '"+nic+"', '"+address+"','"+city+"', '"+pcode+"', '"+gender+"', '"+contact+"', '"+Cemail+"', '"+password+"', '"+accNo+"', '"+bday+"', '"+createDateNtime+"')";
    					
            st.executeUpdate(sql);

        }catch(Exception e) {
       		System.out.println(e);
        }
        	
        
    };
    

}
