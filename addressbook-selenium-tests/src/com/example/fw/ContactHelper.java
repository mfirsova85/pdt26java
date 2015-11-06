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
		 type(By.name("firstname"), contact.getFirstName());
		 type(By.name("lastname"), contact.getLastName());
	     type(By.name("address"),contact.getAddress());
	     type (By.name("home"),contact.getHome());
         type (By.name("mobile"),contact.getMobile());
         type (By.name("work"),contact.getWork());
         type (By.name("email"),contact.getEmail());	
         type (By.name("email2"),contact.getSecodaryemail());
	
	    selectByText(By.name("bday"), contact.getBdday());
	    selectByText(By.name("bmonth"),contact.getBdmonth());
	 
	 type(By.name("byear"),contact.getBdyear());
	 
	 selectByText(By.name("new_group"),contact.getGroupName());
	 
	 type(By.name("address2"),contact.getSecondaryAddress());
	 type(By.name("phone2"),contact.getSecondaryHome());
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
              String firstName = contactinformation.get(1).getText();
              String lastName = contactinformation.get(2).getText();
              ContactData contact = new ContactData()
              .withFirstName(firstName)
              .withLastName(lastName);
              contacts.add(contact);                                                                
        }
        return contacts;
	}
}
	
		
	



