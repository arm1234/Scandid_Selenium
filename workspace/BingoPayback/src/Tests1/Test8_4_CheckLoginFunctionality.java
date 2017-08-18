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

public class Test8_4_CheckLoginFunctionality extends BusinessFunctions{
	  
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
	
	 driver.findElement(By.id("weakphonenumber")).clear();
	    driver.findElement(By.id("weakphonenumber")).sendKeys("9401151903791009");
	    Thread.sleep(10000);
	    driver.findElement(By.id("loginbutton")).click();
	    driver.findElement(By.linkText("Login")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("pin1")).clear();
	    driver.findElement(By.id("pin1")).sendKeys("2");
	    Thread.sleep(10000);
	    driver.findElement(By.id("pin2")).clear();
	    driver.findElement(By.id("pin2")).sendKeys("3");
	    Thread.sleep(10000);
	    driver.findElement(By.id("pin3")).clear();
	    driver.findElement(By.id("pin3")).sendKeys("6");
	    Thread.sleep(10000);
	    driver.findElement(By.id("pin4")).clear();
	    driver.findElement(By.id("pin4")).sendKeys("1");
	    Thread.sleep(10000);
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(10000);
    driver.findElement(By.linkText("Logout")).click();
    Thread.sleep(10000);
	
	Reporter.log("\nLogin Functionality is working fine.",true);

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
