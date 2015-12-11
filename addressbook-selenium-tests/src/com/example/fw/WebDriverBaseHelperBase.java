package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriverBaseHelperBase extends HelperBase{

	
	public WebDriver driver;
	
	public WebDriverBaseHelperBase (ApplicationManager manager) {
		super(manager);
		this.manager = manager;
		this.driver = manager.getDriver();
	}

	protected void type(By locator, String text){
		if (text!=null){
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	protected void selectByText(By locator, String text) {
		if (text!=null){
		new Select(driver.findElement(locator)).selectByVisibleText(text);}
	}
	
}
