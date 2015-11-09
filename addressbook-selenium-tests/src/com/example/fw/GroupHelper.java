package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {



	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}
	private SortedListOf <GroupData> cachedGroups;
	
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups==null) {
			rebuildCache();
		}
		return cachedGroups;
	}
		private void rebuildCache() {
		
		cachedGroups= new SortedListOf<GroupData>();
		manager.navigateTo().groupPage();
		List<WebElement>checkboxes=driver.findElements(By.name("selected[]"));
		for (WebElement checkbox:checkboxes) {
			String title =checkbox.getAttribute("title");
	        String groupname =title.substring("Select (".length(), title.length()-")".length());
	        cachedGroups.add(new GroupData().withGroupName(groupname));
		   }
		
	}
	
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initNewGroupCreation();
	    fillGroupForm(group);
        submitGroupForm();
        returnToGroupPage();
        rebuildCache();
        return this;
		
	}
	public GroupHelper modifyGroup (int index, GroupData group) {
	
	       initGroupModification(index);
		   fillGroupForm(group);
	       submitGroupModification();
	       returnToGroupPage();	
	       rebuildCache();
	       return this;
	}
	
	public GroupHelper deleteGroup(int index) {
	    selectGroup(index);
		submitGroupRemoval();
		returnToGroupPage();
		rebuildCache();
		return this;
	}

	
	
	
//----------------------------------------------------------
	private void submitGroupRemoval() {
		click(By.name("delete"));
		cachedGroups=null;
	
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
	   cachedGroups=null;
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
		cachedGroups=null;
		return this;
	}

	

	

	
		
		
		
	
	
	}

	



