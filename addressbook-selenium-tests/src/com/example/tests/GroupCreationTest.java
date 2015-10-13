package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;






import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupCreationTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  openMainPage();
      gotoGroupsPage();
      initNewGroupCreation();
      GroupData group = new GroupData();
      group.groupname = "group name 1";
      group.header ="header 1";
      group.footer ="footer 1";
	  fillGroupForm(group);
      submitGroupForm();
      gotoGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
      gotoGroupsPage();
      initNewGroupCreation();
      fillGroupForm(new GroupData("", "", ""));
      submitGroupForm();
      gotoGroupsPage();
  }
private void submitGroupForm() {
	
    driver.findElement(By.name("submit")).click();
}

private void fillGroupForm(GroupData Group) {
	
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(Group.groupname);
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(Group.header);
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(Group.footer);
}

private void initNewGroupCreation() {
	
    driver.findElement(By.name("new")).click();
}

private void gotoGroupsPage() {

    driver.findElement(By.linkText("groups")).click();
}

private void openMainPage() {
	
    driver.get(baseUrl + "/addressbookv4.1.4/index.php");
}

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
