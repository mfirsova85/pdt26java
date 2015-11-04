package com.example.tests;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactModificationTest extends TestBase{
	
		@Test (dataProvider ="randomValidContactgeneratorWithoutGroupName")
		  public void modifySomeContact (ContactData contact) throws Exception {
			 app.getNavigationHelper().openMainPage();
			 //save old list
			 List<ContactData> oldlist=app.getContactHelper().getContacts();
			 //actions
			    Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			      app.getContactHelper().initContactModification(index);
			      app.getContactHelper().fillContactForm(contact);
		          app.getContactHelper().submitContactModification();
		          app.getNavigationHelper().openMainPage();
		      //save new list
		      List<ContactData> newlist=app.getContactHelper().getContacts();
		      //compare lists
		     oldlist.remove (index);
		     oldlist.add (contact);
		     Collections.sort(oldlist);
		     Assert.assertEquals(newlist, oldlist);
		}

		
}






 
 

  
 