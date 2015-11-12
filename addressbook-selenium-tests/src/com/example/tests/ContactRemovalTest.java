package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.ListOf;


public class ContactRemovalTest extends TestBase{
	
		@Test
		  public void deletesomecontact () {
			
			 app.navigateTo().mainPage();
			//save old list
			 ListOf<ContactData> oldlist=app.getContactHelper().getContacts();
				Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			    
				//actions
			  app.getContactHelper().RemoveContact(index);
			  
		      
		      //save new list
			 ListOf<ContactData> newlist=app.getContactHelper().getContacts();
		      
		      //compare lists
			    oldlist.remove(index);
				Collections.sort(oldlist);
				Collections.sort(newlist);
			  assertThat(newlist,equalTo(oldlist.without(index)));
		
		
		}

		
}