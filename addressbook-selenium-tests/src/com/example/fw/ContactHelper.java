package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void fillContactForm( ContactData contact) {
		type("firstname", contact.firstName);
		type("lastname", contact.lastName);
		type("home", contact.address);
		type("address", contact.home);
	    type("mobile", contact.mobile);
	    type("work", contact.work);
	    type("email", contact.email);
	    type("email12", contact.secodaryemail);
	    selectByText(By.name("bday"), contact.bdday);
	    selectByText(By.name("bmonth"), contact.bdmonth);
	    type("byear", contact.bdyear);
	    selectByText(By.name("new_group"), contact.groupName);  
	    type("address2", contact.secondaryAddress);
	    type("phone2", contact.SecondaryPhone);
	  ;
	}

	public void initNewContactCreation() {
		
		click(By.name("add new"));
	}

	public void submitContact() {
	
		click(By.name("submit"));
	}

}
