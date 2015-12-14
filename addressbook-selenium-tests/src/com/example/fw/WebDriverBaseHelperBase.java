package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverBaseHelperBase extends HelperBase{

	
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;
	
	public WebDriverBaseHelperBase (ApplicationManager manager) {
		super(manager);
		this.driver = manager.getDriver();
		wait = new WebDriverWait (driver, 10);
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
