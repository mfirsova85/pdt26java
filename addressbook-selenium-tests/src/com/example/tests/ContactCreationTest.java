package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.ListOf;
public class ContactCreationTest extends TestBase {
			@Test (dataProvider ="randomValidContactgenerator")

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

 




