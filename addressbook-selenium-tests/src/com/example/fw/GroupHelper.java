package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase { 

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
		
	}

	public void submitGroupForm() {
		
	  click("submit");
	}

	private void click(String locator) {
		driver.findElement(By.name(locator)).click();
	}

	public void fillGroupForm( GroupData Group) {
	
type("group_name", Group.groupname);
type("group_header", Group.header);
type("group_footer", Group.footer);

	}

	public void initNewGroupCreation() {
		
	   driver.findElement(By.name("new")).click();
	}

}
