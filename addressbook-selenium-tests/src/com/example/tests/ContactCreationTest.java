package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
  @Test
  public void testnotEmptyContactCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
	  app.getContactHelper().initNewContactCreation();
      ContactData contact = new ContactData( );
      contact.firstName = "firstname12";
      contact.lastName ="lastname134";
      contact.home ="home13423";
      contact.mobile ="00000001";
      contact.work ="work1";
      contact.email ="test1@email.test";
      contact.secodaryemail ="secondarytest1@email.test";
      contact.bdday = "10";
      contact.bdmonth ="December";
      contact.bdyear ="2010";
      contact.groupName ="Rob";
      contact.secondaryAddress ="secondaryaddress2";
      contact.secondaryHome ="secondaryhome2";
      
     app.getContactHelper().fillContactForm(contact);
     app.getContactHelper().submitContact();
     app.getNavigationHelper().returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getContactHelper().initNewContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
      app.getContactHelper().submitContact();
      app.getNavigationHelper().returnToHomePage();
  }



 
}
