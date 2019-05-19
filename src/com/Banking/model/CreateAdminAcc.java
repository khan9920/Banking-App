package com.Banking.model;

import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*;
import com.Banking.service.*;
import com.Banking.util.*;
import com.Banking.Dao.*;
import com.Banking.model.*;



public class CreateAdminAcc implements iCreateAccount{

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
    private String Aemail;
    private String password;
    private String createDateNtime;
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
        Aemail = Email;
    };
    
    public void setPassword(String Password){
        password = Password;
    };
    
    public void setCreateDate(){
        Date dNow = new Date( );
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        createDateNtime = ft.format(dNow);
    };
    
    public void createUserID(){
        try {

            Connections con = new Connections();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            do{
            Random rand = new Random();
	    	int random = rand.nextInt((999999 - 100000) + 1) + 100000;
	    	String randomID = Integer.toString(random);
            userID = "A"+randomID;

            
	    	String sql = "SELECT custID FROM admin";
	    	ResultSet rs = st.executeQuery(sql);
	    	    while(rs.next()) { // loop through the results of the query
	    		    if(userID.equals(rs.getString("adminID")))
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
    	
        Connections con = new Connections();
        Connection conn = con.toConnect();
        

        Statement st = conn.createStatement();
			
        String sql = "INSERT INTO admin(adminID,fullName,initials,NIC,address,city,postalCode,gender,tpNO,email,password,Birthday,createDate) VALUES ('"+userID+"', '"+name+"', '"+initials+"', '"+nic+"', '"+address+"','"+city+"', '"+pcode+"', '"+gender+"', '"+contact+"', '"+Aemail+"', '"+password+"', '"+bday+"', '"+createDateNtime+"')";
		
        st.executeUpdate(sql);

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    
    };

    
}
