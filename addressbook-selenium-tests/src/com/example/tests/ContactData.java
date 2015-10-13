package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String mainAddress;
	public String mainHome;
	public String mobile;
	public String work;
	public String mainMail;
	public String secondaryMail;
	public String bdday;
	public String bdmonth;
	public String bdyear;
	public String group;
	public String secondaryaddress;
	public String secondaryhome;

	public ContactData(String firstName, String lastName,
			String mainAddress, String mainHome, String mobile, String work,
			String mainMail, String secondaryMail, String bdday,
			String bdmonth, String bdyear, String group,
			String secondaryaddress, String secondaryhome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mainAddress = mainAddress;
		this.mainHome = mainHome;
		this.mobile = mobile;
		this.work = work;
		this.mainMail = mainMail;
		this.secondaryMail = secondaryMail;
		this.bdday = bdday;
		this.bdmonth = bdmonth;
		this.bdyear = bdyear;
		this.group = group;
		this.secondaryaddress = secondaryaddress;
		this.secondaryhome = secondaryhome;
	}
}