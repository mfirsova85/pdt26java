package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String secondaryemail;
	public String bdday;
	public String bdmonth;
	public String bdyear;
	public String groupName;
	public String secondaryAddress;
	public String secondaryHome;
	
	
	public ContactData (){}

	public ContactData(String firstName, String lastName, String address,
			String home, String mobile, String work, String email,
			String secodaryemail, String bdday, String bdmonth, String bdyear,
			String groupName, String secondaryAddress, String secondaryHome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.secondaryemail = secodaryemail;
		this.bdday = bdday;
		this.bdmonth = bdmonth;
		this.bdyear = bdyear;
		this.groupName = groupName;
		this.secondaryAddress = secondaryAddress;
		this.secondaryHome = secondaryHome;
	}
}