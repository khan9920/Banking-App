package com.Banking.model;



//import all the necessery packages
import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*;
import com.Banking.Dao.*;
import com.Banking.util.*;


//implementing iCreateAccout class as CreateCustomerAcc
public class CreateCustomerAcc implements iCreateAccount{

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
    private String Cemail;
    private String password;
    private String createDateNtime;
    private int accNo;
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
    
    //set values to Cemail variable
    public void setEmail(String Email){
        Cemail = Email;
    };
    
    //set values to password variable
    public void setPassword(String Password){
        password = Password;
    };
    
    //get the current data & time for create accout
    public void setCreateDate(){
        Date dNow = new Date();
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
            userID = "C"+randomID;

            
	    	String sql = "SELECT custID FROM customer";
	    	ResultSet rs = st.executeQuery(sql);
	    	    while(rs.next()) { // loop through the results of the query
	    		    if(userID.equals(rs.getString("custID")))
                        Loop = true;
                    else
                        Loop = false;
                }
            }while(Loop);//end of the do while loop

            conn.close();//close the database connetion
        }catch(Exception e) {
            System.out.println(e);
        }
    };

    //create a unique account number for customer
    public void createAccNo(){
    	

        try {
            //creating connection instance and connect to database
            Connections con = new Connections();
            Connection conn = con.toConnect();

            Statement st = conn.createStatement();

            //generate a random number & validate it for get a unique account number
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
            }while(Loop);//end of the do while loop

            conn.close();//close the database connetion
        }catch(Exception e) {
            System.out.println(e);
        }

    };
    
    //update the database
    public void updateDB(){

    	try {
        	//creating connection instance and connect to database
            Connections con = new Connections();
            Connection conn = con.toConnect();
            

            Statement st = conn.createStatement();
    			
            String sql = "INSERT INTO customer(custID,fullName,initials,NIC,address,city,postalCode,gender,tpNO,email,password,accountNumber,Birthday,createDate) VALUES ('"+userID+"', '"+name+"', '"+initials+"', '"+nic+"', '"+address+"','"+city+"', '"+pcode+"', '"+gender+"', '"+contact+"', '"+Cemail+"', '"+password+"', '"+accNo+"', '"+bday+"', '"+createDateNtime+"')";
    					
            st.executeUpdate(sql);

            conn.close();//close the database connetion

        }catch(Exception e) {
       		System.out.println(e);
        }
        	
        
    };
    

}
