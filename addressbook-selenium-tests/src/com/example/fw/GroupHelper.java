package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase { 

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
		
	}

	public void submitGroupForm() {
		
	  driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm( GroupData Group) {
	
driver.findElement(By.name("group_name")).clear();
driver.findElement(By.name("group_name")).sendKeys(Group.groupname);
driver.findElement(By.name("group_header")).clear();
driver.findElement(By.name("group_header")).sendKeys(Group.header);
driver.findElement(By.name("group_footer")).clear();
driver.findElement(By.name("group_footer")).sendKeys(Group.footer);
	}

	public void initNewGroupCreation() {
		
	   driver.findElement(By.name("new")).click();
	}

}