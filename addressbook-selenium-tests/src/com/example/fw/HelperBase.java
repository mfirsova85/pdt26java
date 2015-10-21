package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HelperBase {


protected ApplicationManager manager;
protected WebDriver driver;

	public HelperBase (ApplicationManager manager) {
		this.manager = manager;
	    this.driver = manager.driver;
		
	}

	protected void type(String locator, String text) {
		driver.findElement(By.name(locator)).clear();
		driver.findElement(By.name(locator)).sendKeys(text);
	}
}
