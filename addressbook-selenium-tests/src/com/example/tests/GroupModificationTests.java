package com.example.tests;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
public class GroupModificationTests extends TestBase{

	@Test (dataProvider ="randomValidGroupsGenerator")
	  public void modifySomeGroups (GroupData group)throws Exception {
		  app.navigateTo().mainPage();
	      app.navigateTo().groupPage();
	      
	    //save old state
	      SortedListOf<GroupData> oldlist=app.getGroupHelper().getGroups();
	      
	      
	      Random rnd =new Random ();
	      int index =rnd.nextInt(oldlist.size()-1);
	      //actions
	      app.getGroupHelper().modifyGroup(index, group);
	      
	      
	    //save new list
	      
	      SortedListOf<GroupData> newlist=app.getGroupHelper().getGroups();
	      
	      //compare old and new list
	      assertThat(newlist,equalTo(oldlist.without(index).withAdded(group)));
	      
	      
	}
	
}
