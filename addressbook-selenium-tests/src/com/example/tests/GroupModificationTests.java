package com.example.tests;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

	@Test (dataProvider ="randomValidGroupsGenerator")
	  public void modifySomeGroups (GroupData group)throws Exception {
		  app.getNavigationHelper().openMainPage();
	      app.getGroupHelper().gotoGroupsPage();
	      
	    //save old state
	      List<GroupData> oldlist=app.getGroupHelper().getGroups();
	      
	      
	      Random rnd =new Random ();
	      int index =rnd.nextInt(oldlist.size()-1);
	      //actions
	      app.getGroupHelper().initGroupModification(index);
		  app.getGroupHelper().fillGroupForm( group);
	      app.getGroupHelper().submitGroupModification();
	      app.getGroupHelper().gotoGroupsPage();
	      
	    //save new list
	      
	      List<GroupData> newlist=app.getGroupHelper().getGroups();
	      
	      //compare old and new list
	     
	      
	      oldlist.remove(index);
	      oldlist.add(group);
	      Collections.sort(oldlist);
	      Assert.assertEquals(newlist, oldlist);
	      
	}
	
}
