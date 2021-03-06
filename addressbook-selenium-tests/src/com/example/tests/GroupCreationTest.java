package com.example.tests;

//import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
public class GroupCreationTest extends TestBase{
	
	@DataProvider
	public Iterator <Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File ("groups.xml"))).iterator();
	    }
	
	@Test (dataProvider ="groupsFromFile")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {

      //save old state
      SortedListOf<GroupData> oldlist
      = app.getModel().getGroups() ;
      
      //actions
      app.getGroupHelper().createGroup(group);
       //save new list
      
      SortedListOf<GroupData> newlist
      =app.getModel().getGroups() ;
      
      //compare old and new list
      assertThat(newlist,equalTo(oldlist.withAdded(group)));

      if (wantToCheck ()){
     
      
      if ("yes".equals(app.getPropert("check.db"))){
      assertThat(app.getModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));
      }
      if ("yes".equals(app.getPropert("check.UI")))
      assertThat(app.getModel().getGroups(),equalTo(app.getGroupHelper().getUIGroups()));
      }
  }
}
