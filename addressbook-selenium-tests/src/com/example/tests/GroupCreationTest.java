package com.example.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
public class GroupCreationTest extends TestBase{
	
  @Test (dataProvider ="randomValidGroupsGenerator")
   
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  app.navigateTo().groupPage();  
	  
      //save old state
      List<GroupData> oldlist=app.getGroupHelper().getGroups();
      
      //actions
      app.getGroupHelper().createGroup(group);
       //save new list
      
      List<GroupData> newlist=app.getGroupHelper().getGroups();
      
      //compare old and new list

      oldlist.add (group);
      Collections.sort(oldlist);
      AssertJUnit.assertEquals(newlist, oldlist);
      
  }
  
// @Test 
  
 // public void testGroupCreationWithInvalidData() throws Exception {
//	  app.getNavigationHelper().openMainPage();
//      app.getGroupHelper().gotoGroupsPage();
      
      //save old state
//      List<GroupData> oldlist=app.getGroupHelper().getGroups();
      
      //actions
//      GroupData group =new GroupData();
//      group.groupname ="test'";
//      group.header= "header1";
//      group.footer="footer1";
//      app.getGroupHelper().initNewGroupCreation();
//	  app.getGroupHelper().fillGroupForm(group);
//      app.getGroupHelper().submitGroupForm();
//      app.getGroupHelper().gotoGroupsPage();
      
      //save new list
      
//      List<GroupData> newlist=app.getGroupHelper().getGroups();
      
      //compare old and new list
     
//      Collections.sort(oldlist);
//      Assert.assertEquals(newlist, oldlist);
      
//  }
  
}
