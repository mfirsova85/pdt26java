package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {



	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}
	
	public List<GroupData> getGroups() {
		List<GroupData>groups= new ArrayList<GroupData>();
		manager.navigateTo().groupPage();
		List<WebElement>checkboxes=driver.findElements(By.name("selected[]"));
		for (WebElement checkbox:checkboxes) {
			String title =checkbox.getAttribute("title");
	        String groupname =title.substring("Select (".length(), title.length()-")".length());
	        groups.add(new GroupData().withGroupName(groupname));
		   }
		return groups;
	}
	
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initNewGroupCreation();
	    fillGroupForm(group);
        submitGroupForm();
        returnToGroupPage();	
        return this;
		
	}
	public GroupHelper modifyGroup (int index, GroupData group) {
	
	       initGroupModification(index);
		   fillGroupForm(group);
	       submitGroupModification();
	       returnToGroupPage();	
	       return this;
	}
	
	public GroupHelper deleteGroup(int index) {
	    selectGroup(index);
		submitGroupRemoval();
		returnToGroupPage();
		return this;
	}

	
	
	
//----------------------------------------------------------
	private void submitGroupRemoval() {
		click(By.name("delete"));
	}
	
	public GroupHelper fillGroupForm(GroupData Group) {
		
	   type(By.name("group_name"), Group.getGroupname());
	   type(By.name("group_header"), Group.getHeader());
	   type(By.name("group_footer"), Group.getFooter());
	   return this;
	
	}

	public  GroupHelper initNewGroupCreation() {	
		manager.navigateTo().groupPage();
		click(By.name("new"));
	   return this;
	   
	}

	public  GroupHelper returnToGroupPage() {	
		manager.navigateTo().groupPage();
		click(By.linkText("groups"));
	   return this;
	   
	}
	
    public GroupHelper submitGroupForm() {
		
	   click(By.name("submit"));
	   return this;
	}

	

	private GroupHelper selectGroup(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroup(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		// TODO Auto-generated method stub

		click(By.name("update"));
		return this;
	}

	

	

	
		
		
		
	
	
	}

	



