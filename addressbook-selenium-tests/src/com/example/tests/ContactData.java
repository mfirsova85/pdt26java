package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String secodaryemail;
	private String bdday;
	private String bdmonth;
	private String bdyear;
	private String groupName;
	private String secondaryAddress;
	private String secondaryHome;
	
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
		this.secodaryemail = secodaryemail;
		this.bdday = bdday;
		this.bdmonth = bdmonth;
		this.bdyear = bdyear;
		this.groupName = groupName;
		this.secondaryAddress = secondaryAddress;
		this.secondaryHome = secondaryHome;
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	@Override
	public int compareTo(ContactData other) {
		
		int res =  lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (res != 0) {
		  return res;
		}
		return firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		}	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result
		//		+ ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result
		//		+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName=firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName=lastName;
		return this;
	}

	public ContactData  withAddress(String address) {
		this.address=address;
		return this;
	}

	public ContactData  withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public  ContactData withWork(String work) {
		this.work = work;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withSecodaryemail(String secodaryemail) {
		this.secodaryemail= secodaryemail;
		return this;
	}

	public ContactData withBdday(String bdday) {
		this.bdday= bdday;
		return this;
	}

	public ContactData withBdmonth(String bdmonth) {
		this.bdmonth= bdmonth;
		return this;
	}

	public ContactData withBdyear(String bdyear) {
		this.bdyear= bdyear;
		return this;
	}

	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress= secondaryAddress;
		return this;
	}

	public ContactData withSecondaryHome(String secondaryHome) {
		this.secondaryHome= secondaryHome;
		return this;
	}

	public ContactData withGroupName(String groupName) {
		this.groupName= groupName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getSecodaryemail() {
		return secodaryemail;
	}

	public String getBdday() {
		return bdday;
	}

	public String getBdmonth() {
		return bdmonth;
	}

	public String getBdyear() {
		return bdyear;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getSecondaryHome() {
		return secondaryHome;
	}

	
	
	
}