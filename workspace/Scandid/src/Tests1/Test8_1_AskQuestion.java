
package Tests1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test8_1_AskQuestion extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

    //Check if Ask Question is clickable
	  
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[8]/a/span")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("customer_name")).clear();
	    driver.findElement(By.id("customer_name")).sendKeys("John Doe");
	    Thread.sleep(10000);
	    driver.findElement(By.id("email_user")).clear();
	    driver.findElement(By.id("email_user")).sendKeys("abc@xyz.com");
	    Thread.sleep(10000);
	    driver.findElement(By.id("question_user")).clear();
	    driver.findElement(By.id("question_user")).sendKeys("Inquiry regarding Samsung");
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("#txtCaptchaDiv_addquestion_form > a.captcha-refresh > img")).click();
	    driver.findElement(By.linkText("Cancel")).click();
	   
	
	Thread.sleep(10000);
	
    Reporter.log("Ask Question link is clickable.",true);
  
  
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

