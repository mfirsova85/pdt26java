package com.example.tests;
import org.testng.annotations.Test;


public class ContactRemovalTest extends TestBase{
	
		@Test
		  public void modifySomeGroups ()throws Exception {
			  app.getNavigationHelper().openMainPage();
			  app.getContactHelper().initContactModification(8);
			  app.getContactHelper().deleteContactModification();
			  app.getContactHelper().submitContactModification();
		      app.getNavigationHelper().openMainPage();
		}

		
}