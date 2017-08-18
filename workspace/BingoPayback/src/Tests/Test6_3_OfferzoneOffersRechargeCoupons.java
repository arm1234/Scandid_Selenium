package Tests;


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

public class Test6_3_OfferzoneOffersRechargeCoupons extends BusinessFunctions{
	  
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
	driver.findElement(By.xpath("html/body/header/div[2]/div/div/div[1]/div/div/nav/ul/li[3]/a")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("html/body/header/div[2]/div/div/div[1]/div/div/nav/ul/li[3]/ul/li[1]/a")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("html/body/header/div/nav/div[2]/div[2]/ul/li[3]/a")).click();
	Thread.sleep(10000);
	
	String winHandleBefore = driver.getWindowHandle();
	
	driver.findElement(By.xpath("html/body/header/div/nav/div[2]/div[2]/ul/li[3]/ul/li[3]/a")).click();
	Thread.sleep(10000);
	
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	
	driver.findElement(By.xpath("html/body/header/div/nav/div[2]/div[2]/ul/li[3]/a")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("html/body/header/div/nav/div[2]/div[2]/ul/li[3]/ul/li[5]/a/span")).click();
	Thread.sleep(20000);
	
	Reporter.log("Offerzone- Offers,Recharge and Coupons are loading.",true);

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
