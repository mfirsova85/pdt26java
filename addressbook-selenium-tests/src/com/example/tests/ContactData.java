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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result
		//		+ ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result
		//		+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int compareTo(ContactData other) {
		
		int res =  lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (res != 0) {
		  return res;
		}
		return firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		}

	public ContactData withFirstName(String firstName) {
		this.firstName =firstName;
		return this;
	
	}

	public ContactData withLastName(String generateRandomString) {
		this.lastName =lastName;
		return null;
	}

	public ContactData withAddress(String generateRandomString) {
		this.address =address;
		return null;
	}
	public ContactData withHome(String generateRandomString) {
		this.home =home;
		return null;
	}
	public ContactData withMobile(String generateRandomString) {
		this.mobile =mobile;
		return null;
	}
	public ContactData withWork(String generateRandomString) {
		this.work =work;
		return null;
	}
	public ContactData witheMail(String generateRandomString) {
		this.email =email;
		return null;
	}
	public ContactData withSecodaryemail(String generateRandomString) {
		this.secodaryemail =secodaryemail;
		return null;
	}
	
	public ContactData withBdDay(String generateRandomString) {
		this.bdday =bdday;
		return null;
	}
	
	public ContactData withBdMonth(String generateRandomString) {
		this.bdmonth =bdmonth;
		return null;
	}
	public ContactData withBdYear(String generateRandomString) {
		this.bdyear =bdyear;
		return null;
	}
	public ContactData withGroupName(String generateRandomString) {
		this.groupName =groupName;
		return null;
	}
	public ContactData withSecondaryAddress (String generateRandomString) {
		this.secondaryAddress =secondaryAddress;
		return null;
	}
	public ContactData withSecondaryHome(String generateRandomString) {
		this.secondaryHome =secondaryHome;
		return null;
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
	
