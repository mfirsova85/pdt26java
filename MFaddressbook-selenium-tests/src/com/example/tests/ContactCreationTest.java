package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
  @Test
  public void testnotEmptyContactCreation() throws Exception {
	  openMainPage();
      initNewContactCreation();
      ContactData contact = new ContactData( );
      contact.firstName = "firstname1";
      contact.lastName ="lastname1";
      contact.home ="home1";
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
      
      fillContactForm(contact);
     submitContact();
     returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	  openMainPage();
      initNewContactCreation();
      fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "", ""));
      submitContact();
      returnToHomePage();
  }



 
}
