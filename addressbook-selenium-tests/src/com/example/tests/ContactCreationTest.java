package com.example.tests;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
	

			
			@Test (dataProvider ="randomValidContactgenerator")

  public void ContactCreationwithValidData(ContactData contact) throws Exception {
	  
	 app.getNavigationHelper().openMainPage();
	  //save old list
	  List<ContactData> oldlist=app.getContactHelper().getContacts();
	  //actions
	 app.getContactHelper().initNewContactCreation();
     app.getContactHelper().fillContactForm(contact);
     app.getContactHelper().submitContact();
     app.getNavigationHelper().returnToHomePage();
     
     //save new list
     List<ContactData> newlist=app.getContactHelper().getContacts();
     
     //compare lists
     oldlist.add (contact);
     Collections.sort(oldlist);
     Assert.assertEquals(newlist, oldlist);
    
  }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getContactHelper().initNewContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
      app.getContactHelper().submitContact();
      app.getNavigationHelper().returnToHomePage();
  }



 
}
