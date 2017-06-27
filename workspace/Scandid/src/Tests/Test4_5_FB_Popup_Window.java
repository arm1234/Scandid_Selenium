package Tests;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;

import Functions.BusinessFunctions;

import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class Test4_5_FB_Popup_Window extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
	
	OpenBrowser();
	
  }

  @Test
  public void test4() throws Exception {
     
	Thread.sleep(10000);
	String parentWindowHandle = driver.getWindowHandle();  
    driver.findElement(By.xpath("(//span[@onclick='facebookLogin()'])[2]")).click();
    
    Thread.sleep(20000);
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }
    
    //Check if popup window can be minimized, maximized or closed.
    
    driver.manage().window().maximize();
    Thread.sleep(10000); 
    driver.manage().window().setPosition(new Point(-2000, 2000));
    Thread.sleep(10000); 
    driver.quit();
    
    Reporter.log("Facebook popup can be maximised, minimised and closed",true);
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
