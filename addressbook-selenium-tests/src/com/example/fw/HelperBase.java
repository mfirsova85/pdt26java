package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HelperBase {

	protected ApplicationManager manager;
	public WebDriver driver;
	
	public HelperBase (ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

	protected void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
}
