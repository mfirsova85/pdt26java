package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  app.NavigationHelper.openMainPage();
      app.NavigationHelper.gotoGroupsPage();
      app.GroupHelper.initNewGroupCreation();
      GroupData group = new GroupData();
      group.groupname = "group name 1";
      group.header ="header 1";
      group.footer ="footer 1";
	  app.GroupHelper.fillGroupForm( group);
      app.GroupHelper.submitGroupForm();
      app.NavigationHelper.gotoGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  app.NavigationHelper.openMainPage();
      app.NavigationHelper.gotoGroupsPage();
      app.GroupHelper.initNewGroupCreation();
      app.GroupHelper.fillGroupForm( new GroupData("", "", ""));
      app.GroupHelper.submitGroupForm();
      app.NavigationHelper.gotoGroupsPage();
  }
}