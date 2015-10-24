package com.example.tests;
import org.testng.annotations.Test;


public class ContactModificationTest extends TestBase{
	
		@Test
		  public void modifySomeGroups ()throws Exception {
			  app.getNavigationHelper().openMainPage();
			  app.getContactHelper().initContactModification(8);
			      ContactData contact = new ContactData( );
			      contact.firstName = "newfirstname1";
			  app.getContactHelper().fillContactForm( contact);
			 
		      app.getContactHelper().submitContactModification();
		      app.getNavigationHelper().openMainPage();
		}

		
}






 
 

  
 