package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase  {
	
	@Test
	  public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().gotoGroupsPage();
		//save old state
	      List<GroupData> oldlist=app.getGroupHelper().getGroups();
	      
	      Random rnd =new Random ();
	      int index =rnd.nextInt(oldlist.size()-1);
	      //actions
		app.getGroupHelper().deleteGroup(0);
		app.getGroupHelper().gotoGroupsPage();
		
		  //save new list
	      
	      List<GroupData> newlist=app.getGroupHelper().getGroups();
	      
	      //compare old and new list
	      oldlist.remove(index);
	      Collections.sort(oldlist);
	      assertEquals(newlist, oldlist);
	      
	}

}