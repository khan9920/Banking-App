package com.bank.service;

//import all the necessery packages
import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*;
import com.bank.dao.*;
import com.bank.model.*;


//implementing iCreateAccout class as CreateAdminAcc
public class CreateAdminAcc implements iCreateAccount{

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
    private String Aemail;
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
    
    //set values to aemail variable
    public void setEmail(String Email){
        Aemail = Email;
    };
    
    //set values to password variable
    public void setPassword(String Password){
        password = Password;
    };
    
    //get the current date and time for create accout
    public void setCreateDate(){
        Date dNow = new Date( );
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        createDateNtime = ft.format(dNow);
    };
    
    //creating a unique userid
    public void createUserID(){
        try {

            //creating connection instance and connect to database
            dbConnection con = new dbConnection();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            //generate a random number & validate it for get a unique random number
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
            }while(Loop);//end of the do while loop

            conn.close(); //close the connection
        }catch(Exception e) {
            System.out.println(e);
        }
    };

    //add new user to database
    public void updateDB(){

    	try {
    	//creating connection instance and connect to database
        dbConnection con = new dbConnection();
        Connection conn = con.toConnect();
        

        Statement st = conn.createStatement();
        
        //insert values to admin table
        String sql = "INSERT INTO admin(adminID,fullName,initials,NIC,address,city,postalCode,gender,tpNO,email,password,Birthday,createDate) VALUES ('"+userID+"', '"+name+"', '"+initials+"', '"+nic+"', '"+address+"','"+city+"', '"+pcode+"', '"+gender+"', '"+contact+"', '"+Aemail+"', '"+password+"', '"+bday+"', '"+createDateNtime+"')";
		
        st.executeUpdate(sql);

        conn.close();//close the database connetion

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    
    };

    
}
