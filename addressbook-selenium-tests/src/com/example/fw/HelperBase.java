package com.example.fw;

import org.openqa.selenium.WebDriver;

public abstract class HelperBase {


protected ApplicationManager manager;
protected WebDriver driver;

	public HelperBase (ApplicationManager manager) {
		this.manager = manager;
	    this.driver = manager.driver;
		
	}
}
