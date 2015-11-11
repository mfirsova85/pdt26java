package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	public  String baseUrl;
	//private boolean acceptNextAlert = true;
	public  WebDriver driver;

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public ApplicationManager () {
		   driver = new FirefoxDriver();
		   baseUrl = "http://localhost/";
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		   driver.get(baseUrl + "/addressbookv4.1.4/index.php");
		   
		   
		   
		   contactHelper=new ContactHelper(this);
		   groupHelper=new GroupHelper(this);
	}

	public void stop() {
		 driver.quit();
	}
		    
		public NavigationHelper navigateTo (){
			if (navigationHelper==null) {
				navigationHelper =new NavigationHelper (this);
			}
			return navigationHelper;
			
		}
		public GroupHelper getGroupHelper (){
			if (groupHelper==null) {
				groupHelper =new GroupHelper (this);
			}
			return groupHelper;
			
		}
		public ContactHelper getContactHelper (){
			if (contactHelper==null) {
				contactHelper =new ContactHelper (this);
			}
			return contactHelper;
			
		}
	}


