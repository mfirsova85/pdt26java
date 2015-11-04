package com.example.tests;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactRemovalTest extends TestBase{
	
		@Test
		  public void deletesomecontact () {
			
			  app.getNavigationHelper().openMainPage();
			//save old list
				List<ContactData> oldlist=app.getContactHelper().getContacts();
				Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			    
				//actions
			  app.getContactHelper().initContactModification(index);
			  app.getContactHelper().deleteContactModification();
		      app.getNavigationHelper().openMainPage();
		      
		      //save new list
		      List<ContactData> newlist=app.getContactHelper().getContacts();
		      
		      //compare lists
		      
		 oldlist.remove (index);
		 Collections.sort(oldlist);
		 Assert.assertEquals(newlist, oldlist);
		
		}

		
}