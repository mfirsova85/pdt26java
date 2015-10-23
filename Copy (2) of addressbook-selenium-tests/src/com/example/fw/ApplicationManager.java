package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public  String baseUrl;
	//private static boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	public  WebDriver driver;
	
	private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public ApplicationManager () {
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    
	    
	}
     
	public void stop() {
		// TODO Auto-generated method stub
		driver.quit();
	    
	    }
	public NavigationHelper getNavigationHelper (){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper (this);
		}
		return navigationHelper;
	}
	public GroupHelper getGroupHelper (){
		if (groupHelper == null) {
			groupHelper = new GroupHelper  (this);
		}
		return groupHelper ;
	}
	public ContactHelper getContactHelper (){
		if (contactHelper == null) {
			contactHelper = new ContactHelper  (this);
		}
		return contactHelper ;
	}
	}

	
