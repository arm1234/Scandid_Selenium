
package Tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test5_1_Quicklinks extends BusinessFunctions {
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if Quicklinks are working fine
	  
    driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[2]/a/span")).click();
    Thread.sleep(10000);
    driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[3]/a/span")).click();
    Thread.sleep(10000);
    driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[4]/a/span")).click();
    Thread.sleep(10000);
    driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[5]/a/span")).click();
    Thread.sleep(10000);
    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
    Thread.sleep(10000);
    
    Reporter.log("Quicklinks are clickable and working fine",true);
  
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

