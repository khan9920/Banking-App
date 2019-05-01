import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.text.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateCustomerACC implements iCreateAccout{

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
    private Stirng email;
    private String password;
    private String createDateNtime;

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
        email = Email;
    };
    
    public void setPassword(String Password){
        password = Password;
    };
    
    public void setCreateDate(){
        Date dNow = new Date( );
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        String createDateNtime = ft.format(dNow);
    };
    
    public void createUserID(){
        Random rand = new Random();
		int random = rand.nextInt((999999 - 100000) + 1) + 100000;
        String userID = "A"+random;
    };

    
    public void updateDB(){

    };

}
