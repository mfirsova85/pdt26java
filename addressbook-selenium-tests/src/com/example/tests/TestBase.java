package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	static ApplicationManager app;

	
	@BeforeTest
	public void setUp() throws Exception {
		app= new ApplicationManager();
	
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop ();
	   
	  }
	
	@DataProvider
	public Iterator <Object[]> randomValidGroupsGenerator() {
	    	
	    	List <Object[]> list =new ArrayList<Object[]> ();
	    	Random rnd= new Random();
	    	for (int i=0;i < 6; i++) {
	    		GroupData group =new GroupData();
	    		group.groupname=generateRandomString();
	    		group.header=generateRandomString();
	    		group.footer =generateRandomString();
	    		list.add (new Object[] {group});
	    		
	    	}
	    	
	    	return list.iterator();
	    }
	    
	    public String generateRandomString () {
	    	Random rnd= new Random();
	    	if (rnd.nextInt(3)==0) {
				return "";
			}else {
			return "test" +rnd.nextInt();
			}
	    }
	    
		@DataProvider
		public Iterator<Object[]> randomValidContactgenerator() {
			List<Object[]> list =new ArrayList<Object[]>();
			Random rnd =new Random();
			for (int i =0;i<5;i++) {
				ContactData contact =new ContactData();
				
				contact.firstName =generateRandomString();
			
				contact.lastName =generateRandomString();
				contact.address =generateRandomString();
				contact.home =generateRandomString();
				contact.mobile =generateRandomString();
				contact.work =generateRandomString();
				contact.email =generateRandomString();
				contact.secodaryemail =generateRandomString();
				contact.bdday ="10";
				contact.bdmonth ="May";
				contact.bdyear ="1985";
				contact.groupName ="Rob";
				contact.secondaryAddress =generateRandomString();
				contact.secondaryHome =generateRandomString();
				list.add(new Object[]{contact});	
				}
				return list.iterator();
			}
		
	

}
