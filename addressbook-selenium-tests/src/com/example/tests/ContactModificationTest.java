package com.example.tests;
import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTest extends TestBase{
	
		@Test (dataProvider ="randomValidContactgeneratorWithoutGroupName")
		  public void modifySomeContact (ContactData contact) throws Exception {
			app.navigateTo().mainPage();
			 //save old list
			SortedListOf<ContactData> oldlist=app.getContactHelper().getContacts();
			 
			 //actions
			    Random rnd =new Random ();
			    int index =rnd.nextInt(oldlist.size()-1);
			    app.getContactHelper().ModifyContact(index,contact);
			      
		          
		      //save new list
		      SortedListOf<ContactData> newlist=app.getContactHelper().getContacts();
		      
		      //compare lists
		      assertThat(newlist,equalTo(oldlist.without(index).withAdded(contact)));

		
}
}
