package Tests1;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;

import Functions.BusinessFunctions;

public class Test7_11_HomeLinkClickable extends BusinessFunctions{
	  
	  //private WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	    
		@BeforeTest(alwaysRun = true)
	    public void setUp() throws Exception {
			
		OpenBrowser ();
		
	  }
 

	@Test
    public void test2() throws Exception {

	Thread.sleep(10000);
	driver.findElement(By.id("product_key")).clear();
    driver.findElement(By.id("product_key")).sendKeys("samsung");
	Thread.sleep(10000);
    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-search")).click();
	Thread.sleep(10000);
    driver.findElement(By.xpath("html/body/section/div[1]/div[1]/div[2]/div[1]/div/div[1]/a")).click();
	Thread.sleep(10000);
	
	driver.findElement(By.linkText("Home")).click();
	Thread.sleep(20000);
    		
	Reporter.log("\nHome link is clickable",true);

}


     @AfterTest(alwaysRun = true)
     public void tearDown() throws Exception {
     driver.quit();
     String verificationErrorString = verificationErrors.toString();
     if (!"".equals(verificationErrorString)) {
     AssertJUnit.fail(verificationErrorString);
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
