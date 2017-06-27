
package Tests4;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test16_2_NewsLinkTimesOfIndia extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if TimesOfIndia News link is working
	  
	  String winHandleBefore = driver.getWindowHandle();	  
	  driver.findElement(By.cssSelector("img[alt=\"timesofindia\"]")).click();
	  Thread.sleep(20000);
	  for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	    
      String bodyText = driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div/div/div[4]/div[1]/section[1]/h1")).getText();
	  
	  System.out.println(bodyText);
	  
	  Assert.assertEquals("An app that helps you make sense of discounts and deals", bodyText);
	  
	  Thread.sleep(10000);
	  
	  Reporter.log("\nTimesOfIndia News link is working.",true);
		          
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

