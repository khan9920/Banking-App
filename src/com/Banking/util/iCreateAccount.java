package com.Banking.util;

public interface iCreateAccount{

    public void setName(String Name);
    public void setInitials(String Initials);
    public void setNIC(String NIC);
    public void setAddress(String Address);
    public void setCity(String City);
    public void setBday(String Bday);
    public void setGender(String Gender);
    public void setContact(int Contact);
    public void setPcode(int Pcode);
    public void setEmail(String Email);
    public void setPassword(String Password);
    public void setCreateDate();
    public void createUserID();
    public void updateDB();

}