package com.example.tests;

//import static com.example.tests.ContactDataGenerator.LoadContactsFromCSVFile;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.ListOf;

public class ContactCreationTest extends TestBase {

	@DataProvider
	public Iterator <Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File ("contacts.xml"))).iterator();
	    }
	

	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {

		// save old state
        
		ListOf<ContactData> oldList = app.getContactHelper().getContacts();

		// actions

		app.getContactHelper().CreateContact(contact);

		// save new state

		ListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);

		assertThat(oldList, equalTo(newList));
	}

}