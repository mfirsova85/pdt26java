package com.example.tests;

import static com.example.tests.ContactDataGenerator.LoadContactsFromCSVFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.ListOf;
public class ContactCreationTest extends TestBase {
	
@DataProvider
	public Iterator <Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(LoadContactsFromCSVFile(new File ("contacts.txt"))).iterator();
	    }			
			
@Test (dataProvider ="contactsFromFile")
  public void ContactCreationwithValidData(ContactData contact) throws Exception {	 
	  //save old list
	  ListOf<ContactData> oldlist=app.getContactHelper().getContacts();
	  //actions
	  app.getContactHelper().CreateContact(contact); 
    //save new list
	  ListOf<ContactData> newlist=app.getContactHelper().getContacts();
     
     //compare lists
	  
	    oldlist.add(contact);
		Collections.sort(oldlist);
		Collections.sort(newlist);

		assertThat(oldlist, equalTo(newlist));
  }
  
  

}

 




