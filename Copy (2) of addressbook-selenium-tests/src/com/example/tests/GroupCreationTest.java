package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getNavigationHelper().gotoGroupsPage();
      app.getGroupHelper().initNewGroupCreation();
      GroupData group = new GroupData();
      group.groupname = "group name 1";
      group.header ="header 1";
      group.footer ="footer 1";
	  app.getGroupHelper().fillGroupForm( group);
      app.getGroupHelper().submitGroupForm();
      app.getNavigationHelper().gotoGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getNavigationHelper().gotoGroupsPage();
      app.getGroupHelper().initNewGroupCreation();
      app.getGroupHelper().fillGroupForm( new GroupData("", "", ""));
      app.getGroupHelper().submitGroupForm();
      app.getNavigationHelper().gotoGroupsPage();
  }
}
