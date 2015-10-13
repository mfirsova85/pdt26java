package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testnotemptycontactcreation() throws Exception {
    openMainPage();
	initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "firstname1";
    contact.lastName ="lastname1";
    contact.group ="Rob";
    contact.bdday = "10";
    contact.bdmonth ="10";
    contact.bdyear ="2010";
    contact.mainAddress ="mainaddress1";
    contact.mainHome ="mainhome1";
    contact.mainMail ="mainmail1@test.test";
    contact.mobile = "0000001";
    contact.secondaryaddress = "secondaryaddress1";
    contact.secondaryhome = "secondaryhome1";
    contact.secondaryMail = "secondarymail1@test.test";
    		
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testemptycontactcreation() throws Exception {
    openMainPage();
	initNewContactCreation();
    ContactData contact = new ContactData("First name 1", "Last name 1", "Address 1", "home1", "000 000 01", "work1", "testemail1@test.com", "testemail2@test.com", "10", "March", "1985",
			"Rob", "addresssecondary1", "homesecondary1");
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

private void returnToHomePage() {
	
    driver.findElement(By.linkText("home")).click();
}

private void submitContactCreation() {
	
    driver.findElement(By.name("submit")).click();
}

private void fillContactForm(ContactData parameterObject) {
	
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(parameterObject.firstName);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(parameterObject.lastName);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(parameterObject.mainAddress);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(parameterObject.mainHome);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(parameterObject.mobile);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(parameterObject.work);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(parameterObject.mainMail);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(parameterObject.secondaryMail);
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(parameterObject.bdday);
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(parameterObject.bdmonth);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(parameterObject.bdyear);
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(parameterObject.group);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(parameterObject.secondaryaddress);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(parameterObject.secondaryhome);
}

private void initNewContactCreation() {

    driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
	
	  driver.get(baseUrl + "/addressbookv4.1.4/index.php");
}

  @After
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
