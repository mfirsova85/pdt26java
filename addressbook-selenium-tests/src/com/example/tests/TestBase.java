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
	    		group.groupname=generateRandomString(10);
	    		group.header=generateRandomString(10);
	    		group.footer =generateRandomString(10);
	    		list.add (new Object[] {group});
	    		
	    	}
	    	
	    	return list.iterator();
	    }
	    
	 // public String generateRandomString () {
	 //	Random rnd= new Random();
	 // 	if (rnd.nextInt(3)==0) {
	 //		return "";
				 //	}else {
	 //	return "test" +rnd.nextInt();
	 //		}
	 //   }
	  

	public static String generateRandomString(int length) {
	   final char[] KEYCHARS = "0123456789ABCDEFGhijklmnopqrstuvwxyz±$!@#%&*()".toCharArray();
		  Random randomizer = new Random();
		  char[] randomString = new char[length];
	Random rnd=new Random ();
	if (rnd.nextInt(3)==0) {return "";}
	else {
		  for (int i = 0; i < length; i++) {
	       randomString[i] = KEYCHARS[randomizer.nextInt(KEYCHARS.length)];
	   }
	  return new String(randomString);
		}}
	 
		@DataProvider
		public Iterator<Object[]> randomValidContactgeneratorWithoutGroupName() {
			List<Object[]> list =new ArrayList<Object[]>();
			Random rnd =new Random();
			for (int i =0;i<5;i++) {
				ContactData contact =new ContactData();
				contact.firstName =generateRandomString(10);
				contact.lastName =generateRandomString(10);
				contact.address =generateRandomString(10);
				contact.home =generateRandomString(10);
				contact.mobile =generateRandomString(10);
				contact.work =generateRandomString(10);
				contact.email =generateRandomString(10);
				contact.secodaryemail =generateRandomString(10);
				contact.bdday ="10";
				contact.bdmonth ="May";
				contact.bdyear ="1985";
				contact.secondaryAddress =generateRandomString(10);
				contact.secondaryHome =generateRandomString(10);
				list.add(new Object[]{contact});	
				}
			    
			
			
				return list.iterator();
			}
		
		@DataProvider
		public Iterator<Object[]> randomValidContactgenerator() {
			List<Object[]> list =new ArrayList<Object[]>();
			Random rnd =new Random();
			for (int i =0;i<5;i++) {
				ContactData contact =new ContactData();
				contact.firstName =generateRandomString(10);
				contact.lastName =generateRandomString(10);
				contact.address =generateRandomString(10);
				contact.home =generateRandomString(10);
				contact.mobile =generateRandomString(10);
				contact.work =generateRandomString(10);
				contact.email =generateRandomString(10);
				contact.secodaryemail =generateRandomString(10);
				contact.bdday ="10";
				contact.bdmonth ="May";
				contact.bdyear ="1985";
				contact.secondaryAddress =generateRandomString(10);
				contact.secondaryHome =generateRandomString(10);
				list.add(new Object[]{contact});	
				}
			    
			
				return list.iterator();
			}

}
