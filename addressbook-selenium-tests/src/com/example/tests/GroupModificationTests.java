package com.example.tests;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

	@Test
	  public void modifySomeGroups ()throws Exception {
		  app.getNavigationHelper().openMainPage();
	      app.getGroupHelper().gotoGroupsPage();
	      app.getGroupHelper().initGroupModification(5);
	      GroupData group=new GroupData();
	      group.groupname= "new name";
		  app.getGroupHelper().fillGroupForm( group);
	      app.getGroupHelper().submitGroupModification();
	      app.getGroupHelper().gotoGroupsPage();
	}
	
}
