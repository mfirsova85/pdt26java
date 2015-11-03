package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void initNewContactCreation() {
		
	   click(By.linkText("add new"));
	}

	public void submitContact() {
	
	   click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		 type(By.name("firstname"), contact.firstName);
		 type(By.name("lastname"), contact.lastName);
	     type(By.name("address"),contact.address);
	     type (By.name("home"),contact.home);
         type (By.name("mobile"),contact.mobile);
         type (By.name("work"),contact.work);
         type (By.name("email"),contact.email);	
         type (By.name("email2"),contact.secodaryemail);
	
	    selectByText(By.name("bday"), contact.bdday);
	    selectByText(By.name("bmonth"),contact.bdmonth);
	 
	 type(By.name("byear"),contact.bdyear);
	 
	 selectByText(By.name("new_group"),contact.groupName);
	 
	 type(By.name("address2"),contact.secondaryAddress);
	 type(By.name("phone2"),contact.secondaryHome);
	}

	public void submitContactModification() {
		click(By.name("update"));
		
	}

	public void initContactModification(int index) {
	  //click(By.id("id"+index));
	  click (By.xpath("(//img[@alt='Edit'])["+(index+1)+"]"));
	}

	public void deleteContactModification() {
		click (By.xpath("(//input[@name='update'])[2]"));
	}

	public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> contactsrows = driver.findElements(By.name("entry"));
        for ( int contactsrowi = 0 ; contactsrowi < contactsrows.size() ; contactsrowi++ ){
              WebElement contactsrow = contactsrows.get(contactsrowi);
              List<WebElement> contactinformation = contactsrow.findElements(By.tagName("td"));
              ContactData contact = new ContactData();
              contact.lastName = contactinformation.get(1).getText();
              contact.firstName = contactinformation.get(2).getText();
              contacts.add(contact);                                                                
        }
        return contacts;
	}
}
	
		
	



