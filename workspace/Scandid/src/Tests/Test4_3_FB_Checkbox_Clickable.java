package Tests;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;

public class Test4_3_FB_Checkbox_Clickable extends BusinessFunctions{
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 

@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
		
	OpenBrowser();
  }

  @Test
  public void test4() throws Exception {
     
	String parentWindowHandle = driver.getWindowHandle();  
    driver.findElement(By.xpath("(//span[@onclick='facebookLogin()'])[2]")).click();
    
    Thread.sleep(20000);
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }
    
    //Check if Checkbox is clickable
    
    driver.findElement(By.id("offline_access")).click();
    Thread.sleep(10000); 
    driver.findElement(By.id("offline_access")).click();
    Reporter.log("Checkbox is Clickable (Selected and Deselected)",true);
    
    Thread.sleep(10000); 
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
