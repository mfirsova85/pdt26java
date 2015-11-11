package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;


public class ContactRemovalTest extends TestBase{
	
		@Test
		  public void deletesomecontact () {
			
			 app.navigateTo().mainPage();
			//save old list
			 SortedListOf<ContactData> oldlist=app.getContactHelper().getContacts();
				Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			    
				//actions
			  app.getContactHelper().RemoveContact(index);
			  
		      
		      //save new list
			  SortedListOf<ContactData> newlist=app.getContactHelper().getContacts();
		      
		      //compare lists
			  assertThat(newlist,equalTo(oldlist.without(index)));
		
		
		}

		
}