
package Tests2;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test10_7_Trending_KidsToys extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if Trending Kids and Toys link is clickable
	  
	Thread.sleep(5000);
	driver.findElement(By.id("home-trending")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//a[contains(text(),'Kids & Toys')])[4]")).click();
	Thread.sleep(20000);
		
	Reporter.log("Trending Kids & Toys link is clickable.",true);
	
      
  }

  @AfterClass(alwaysRun = true)
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

