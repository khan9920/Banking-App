package com.worldbank.model;

public class Contactus {
	private int id;
	private String CustomerId;
	private String firstname;
	private String lastname;
	private String email;
	private String subject;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id=id;
	}
	
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String CustomerId) {
		this.CustomerId = CustomerId;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname=firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname=lastname;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email=email;
	}
	public String getsubject() {
		return subject;
	}
	public void setsubject(String subject) {
		this.subject=subject;
	}


}
