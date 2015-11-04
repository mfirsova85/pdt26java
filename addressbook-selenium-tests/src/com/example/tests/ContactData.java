package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String secodaryemail;
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
}