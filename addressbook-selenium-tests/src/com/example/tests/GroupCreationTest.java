package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class GroupCreationTest extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getGroupHelper().gotoGroupsPage();
      //save old state
      List<GroupData> oldlist=app.getGroupHelper().getGroups();
      
      app.getGroupHelper().initNewGroupCreation();
      GroupData group = new GroupData();
      group.groupname = "aaa";
      group.header ="header 1";
      group.footer ="footer 1"; 
	  app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupForm();
      app.getGroupHelper().gotoGroupsPage();
      
      //save new list
      
      List<GroupData> newlist=app.getGroupHelper().getGroups();
      
      //compare old and new list
     
      
      oldlist.add (group);
      Collections.sort(oldlist);
      Assert.assertEquals(newlist, oldlist);
      
  }
  
 @Test
  public void testEmptyGroupCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getGroupHelper().gotoGroupsPage();
    //save old state
      List<GroupData> oldlist=app.getGroupHelper().getGroups();
      
      //actions
      app.getGroupHelper().initNewGroupCreation();
      GroupData group = new GroupData("", "", "");
	  app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupForm();
      app.getGroupHelper().gotoGroupsPage();

      //save new list
      
      List<GroupData> newlist=app.getGroupHelper().getGroups();
      
      //compare old and new list
      oldlist.add (group);
      Collections.sort(oldlist);
      Assert.assertEquals(newlist, oldlist);
        
  }
}
