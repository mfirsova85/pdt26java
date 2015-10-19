package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app ;

	public static String baseUrl;
	//private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	public static WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		app=new ApplicationManager ();
	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop ();
	    
	  }

}
