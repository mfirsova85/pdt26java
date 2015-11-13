package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.ListOf;

public class ContactModificationTest extends TestBase{
	
		@Test (dataProvider ="randomValidContactgenerator")
		  public void modifySomeContact (ContactData contact) throws Exception {
			app.navigateTo().mainPage();
			 //save old list
			 ListOf<ContactData> oldlist=app.getContactHelper().getContacts();
			 
			 //actions
			    Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			    app.getContactHelper().ModifyContact(index,contact);
			      
		          
		      //save new list
		       ListOf<ContactData> newlist=app.getContactHelper().getContacts();
		      
		      //compare lists
		       oldlist.remove (index);
			   oldlist.add (contact);
			   Collections.sort(oldlist);
			   Collections.sort(newlist);
			   assertThat(oldlist, equalTo(newlist));
		
}
}
