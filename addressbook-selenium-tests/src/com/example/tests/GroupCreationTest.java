package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
public class GroupCreationTest extends TestBase{
	
  @Test (dataProvider ="randomValidGroupsGenerator")
   
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  app.navigateTo().groupPage();  
	  
      //save old state
      SortedListOf<GroupData> oldlist=app.getGroupHelper().getGroups();
      
      //actions
      app.getGroupHelper().createGroup(group);
       //save new list
      
      SortedListOf<GroupData> newlist=app.getGroupHelper().getGroups();
      
      //compare old and new list

      assertThat(newlist,equalTo(oldlist.withAdded(group)));
      
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
