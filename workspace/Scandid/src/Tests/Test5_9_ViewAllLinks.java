
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


public class Test5_9_ViewAllLinks extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

    //Check if View All links are working fine
	
	    driver.findElement(By.linkText("View All")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div/div[4]/div/div/div/div/div[1]/span[2]/a")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div/div[6]/div/div/div/div/div[1]/span[2]/a")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div/div[10]/div/div/div/div/div[1]/span[2]/a")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div/div[14]/div/div/div/div/div[1]/span[2]/a")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div/div[16]/div/div/div/div/div[1]/span[2]/a")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("img[alt=\"Scandid\"]")).click();
	    Thread.sleep(10000);
	    
		     
    Reporter.log("View All Links are working fine.",true);
  
  
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

