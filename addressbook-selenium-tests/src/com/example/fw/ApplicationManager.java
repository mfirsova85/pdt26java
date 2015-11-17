package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager  {
	public  String baseUrl;
	//private boolean acceptNextAlert = true;
	public  WebDriver driver;

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			 driver = new ChromeDriver();
		}
		
		else {
			throw new Error("Unsupported browser: " + browser);
		}

		baseUrl = properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
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


