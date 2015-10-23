package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void fillGroupForm(GroupData Group) {
		
	   type(By.name("group_name"), Group.groupname);
	   type(By.name("group_header"), Group.header);
	   type(By.name("group_footer"), Group.footer);
	   
	}

	public void initNewGroupCreation() {
		
	   click(By.name("new"));
	}

	public void gotoGroupsPage() {
	
		click(By.linkText("groups"));
	}
	
    public void submitGroupForm() {
		
	   click(By.name("submit"));
	}

	public void deleteGroup(int index) {
	    selectGroup(index);
		click(By.name("delete"));
	}

	private void selectGroup(int index) {
		click(By.xpath("//input [@name='selected[]']["+index+"]"));
	}

	public void initGroupModification(int index) {
		selectGroup(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		// TODO Auto-generated method stub

		click(By.name("update"));
		
	}

}
