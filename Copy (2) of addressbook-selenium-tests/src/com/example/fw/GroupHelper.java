package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase { 

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
		
	}

	public void submitGroupForm() {
		
	  click(By.name("submit"));
	}

	public void fillGroupForm( GroupData Group) {
	
type("group_name", Group.groupname);
type("group_header", Group.header);
type("group_footer", Group.footer);

	}

	public void initNewGroupCreation() {
		
		click(By.name("new"));
	}

	public void deleteGroup(int index) {
		// TODO Auto-generated method stub
		selectGroupByIndex(index);
		click(By.name("delete"));
		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'] ["+index+"] "));
	}

	public void initGroupModification(int index) {
		// TODO Auto-generated method stub
		selectGroupByIndex(index);
		click(By.name("edit"));
		
	}

	public void submitGroupModification() {
		// TODO Auto-generated method stub
		click(By.name("update"));
	}

}
