package com.Banking.model;

import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*;
import com.Banking.Dao.*;
import com.Banking.util.*;

//implementing iCreateAccout class as CreateEmployeeAcc
public class CreateEmployeeAcc implements iCreateAccount{

    //creating variables
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
    private String Eemail;
    private String password;
    private String createDateNtime;
    boolean Loop;

    //set values to name variable
    public void setName(String Name){
        name = Name;
    };

    //set values to initials variable
    public void setInitials(String Initials){
        initials = Initials;
    };
    
    //set values to nic variable
    public void setNIC(String NIC){
        nic = NIC;
    };
    
    //set values to address variable
    public void setAddress(String Address){
        address = Address;
    };
    
    //set values to city variable
    public void setCity(String City){
        city = City;
    };
    
    //set values to bday variable
    public void setBday(String Bday){
        bday = Bday;
    };
    
    //set values to gender variable
    public void setGender(String Gender){
        gender = Gender;
    };
    
    //set values to contact variable
    public void setContact(int Contact){
        contact = Contact;
    };
    
    //set values to pcode variable
    public void setPcode(int Pcode){
        pcode = Pcode;
    };
    
    //set values to Eemail variable
    public void setEmail(String Email){
        Eemail = Email;
    };
    
    //set values to password variable
    public void setPassword(String Password){
        password = Password;
    };
    
    //get current data & time for create accout
    public void setCreateDate(){
        Date dNow = new Date( );
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        createDateNtime = ft.format(dNow);
    };
    
    //create a unique user id
    public void createUserID(){
        try {

            //creating connection instance and connect to database
            Connections con = new Connections();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            //generate a random number & validate it for get a unique random number
            do{
            Random rand = new Random();
	    	int random = rand.nextInt((999999 - 100000) + 1) + 100000;
	    	String randomID = Integer.toString(random);
            userID = "E"+randomID;

            
	    	String sql = "SELECT custID FROM Employee";
	    	ResultSet rs = st.executeQuery(sql);
	    	    while(rs.next()) { // loop through the results of the query
	    		    if(userID.equals(rs.getString("empID")))
                        Loop = true;
                    else
                        Loop = false;
                }
            }while(Loop);//end of the do while loop

            conn.close();//close the connection
        }catch(Exception e) {
            System.out.println(e);
        }
    };

    //add new user to database
    public void updateDB()  {
    	
    	try {

        //creating connection instance and connect to database
        Connections con = new Connections();
        Connection conn = con.toConnect();
        

        Statement st = conn.createStatement();
            
        //insert values to Employee table
        String sql = "INSERT INTO Employee(empID,fullName,initials,NIC,address,city,postalCode,gender,tpNO,email,password,Birthday,createDate) VALUES ('"+userID+"', '"+name+"', '"+initials+"', '"+nic+"', '"+address+"','"+city+"', '"+pcode+"', '"+gender+"', '"+contact+"', '"+Eemail+"', '"+password+"', '"+bday+"', '"+createDateNtime+"')";
		
        st.executeUpdate(sql);

        conn.close(); //close the database connetion

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    };
    

}
