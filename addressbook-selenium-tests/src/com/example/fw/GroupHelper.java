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

	public void fillGroupForm(GroupData Group) {
		
	   type(By.name("group_name"), Group.getGroupname());
	   type(By.name("group_header"), Group.getHeader());
	   type(By.name("group_footer"), Group.getFooter());
	   
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
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
	}

	public void initGroupModification(int index) {
		selectGroup(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		// TODO Auto-generated method stub

		click(By.name("update"));
		
	}

	public List<GroupData> getGroups() {
		
		List<GroupData>groups= new ArrayList<GroupData>();
		List<WebElement>checkboxes=driver.findElements(By.name("selected[]"));
		for (WebElement checkbox:checkboxes) {
			String title =checkbox.getAttribute("title");
	        String groupname =title.substring("Select (".length(), title.length()-")".length());
	        groups.add(new GroupData().withGroupName(groupname));
		   }
		return groups;
		
		
		
	
	
	}
}


