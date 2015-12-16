package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.ListOf;

public class ContactHelper extends WebDriverBaseHelperBase {
    public static boolean CREATION=true;
    public static boolean MODIFICATION=false;
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}
	private ListOf <ContactData> cachedContacts;
	
	public ListOf<ContactData> getContactsUI() {
		if(cachedContacts==null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache () {
		cachedContacts= new ListOf<ContactData>();
		manager.navigateTo().mainPage();
       
		List<WebElement> contactsrows = driver.findElements(By.name("entry"));
        for ( int contactsrowi = 0 ; contactsrowi < contactsrows.size() ; contactsrowi++ ){
              WebElement contactsrow = contactsrows.get(contactsrowi);
              List<WebElement> contactinformation = contactsrow.findElements(By.tagName("td"));
              String lastName = contactinformation.get(1).getText();
              String firstName = contactinformation.get(2).getText();
              ContactData contact = new ContactData()
        	  .withLastName (lastName) 
              .withFirstName (firstName);
    
              cachedContacts.add(contact);                                                                
        
     
	}
		
	}

	
    public ContactHelper CreateContact(ContactData contact) {
		
		initNewContactCreation();
	    fillContactForm(contact,CREATION);
	    submitContact();
	    rebuildCache();
	    return this;
	    
		
	}
    
    public ContactHelper ModifyContact (int index,ContactData contact) {
	      initContactModification(index);
	      fillContactForm(contact,MODIFICATION);
          submitContactModification();
	      returnToHomePage();
	      rebuildCache();
	      return this;
		
	}
    
    public ContactHelper RemoveContact(int index) {
		initContactModification(index);
		  deleteContactModification();
		  returnToHomePage();
		  rebuildCache();
		  return this;
		
	}
 //---------------------------------------------------------------------------------
    
    
	public ContactHelper initNewContactCreation() {
		
	   click(By.linkText("add new"));
	   return this;
	}

	public ContactHelper submitContact() {
	
	   click(By.name("submit"));
	   cachedContacts=null;
	   return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
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
	    if (formType == CREATION) {
			// selectByText(By.name("new_group"), contact.group);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}

	
	 type(By.name("address2"),contact.getSecondaryAddress());
	 type(By.name("phone2"),contact.getSecondaryHome());
	 return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		cachedContacts=null;
		 return this;
		
	}

	public ContactHelper initContactModification(int index) {
	  //click(By.id("id"+index));
	  click (By.xpath("(//img[@alt='Edit'])["+(index+1)+"]"));
	  return this;
	}

	public ContactHelper deleteContactModification() {
		click (By.xpath("(//input[@name='update'])[2]"));
		cachedContacts=null;
		 return this;
	}
	public ContactHelper returnToHomePage() {
		click(By.linkText("home"));
		 return this;
	}

	

	

	
}


