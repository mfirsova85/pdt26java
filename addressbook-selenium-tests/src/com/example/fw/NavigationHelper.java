package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}



	public void openMainPage() {
		
	driver.get(manager.baseUrl + "/addressbookv4.1.4/index.php");
	}

	

	public void returnToHomePage() {
	
	 click(By.linkText("home"));
	}

}
