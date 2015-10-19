package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.TestBase; 

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void openMainPage() {
		
	 driver.get(manager.baseUrl + "/addressbookv4.1.4/index.php");
	}

	public void returnToHomePage() {
	
		driver.findElement(By.linkText("home")).click();
	}

	public void gotoGroupsPage() {
	
		driver.findElement(By.linkText("groups")).click();
	}

}