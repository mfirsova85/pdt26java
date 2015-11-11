package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
public class ContactCreationTest extends TestBase {
			@Test (dataProvider ="randomValidContactgenerator")

  public void ContactCreationwithValidData(ContactData contact) throws Exception {	 
	  //save old list
	  SortedListOf<ContactData> oldlist=app.getContactHelper().getContacts();
	  //actions
	  app.getContactHelper().CreateContact(contact); 
    //save new list
	  SortedListOf<ContactData> newlist=app.getContactHelper().getContacts();
     
     //compare lists
	  assertThat(newlist,equalTo(oldlist.withAdded(contact)));
    
  }
  
  //@Test
/*  public void testEmptyContactCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getContactHelper().initNewContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
      app.getContactHelper().submitContact();
      app.getNavigationHelper().returnToHomePage();*/
  }



 




