package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.util.Random;


import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase  {
	
	@Test
	  public void deleteSomeGroup() {
		app.navigateTo().mainPage();
		app.navigateTo().groupPage();
		//save old state
	     SortedListOf<GroupData> oldlist=app.getGroupHelper().getGroups();
	      Random rnd =new Random ();
	      int index =rnd.nextInt(oldlist.size()-1);
	      //actions
		app.getGroupHelper().deleteGroup (index);
		
		
		  //save new list
	      
		SortedListOf<GroupData> newlist=app.getGroupHelper().getGroups();
	      
	      //compare old and new list
          assertThat(newlist,equalTo(oldlist.without(index)));
	      
	}


}