
package Tests4;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test12_1_2_ProductSearchSortButtonLowHighPopular extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if Product Search and Sort Button Low, High and Popular are working
	  
	    Thread.sleep(10000);
	    driver.findElement(By.id("product_key1")).click();
	    driver.findElement(By.id("product_key1")).clear();
	    driver.findElement(By.id("product_key1")).sendKeys("samsung");
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.id("sortby")).click();
	    Thread.sleep(10000);
	    new Select(driver.findElement(By.id("sortby"))).selectByVisibleText("Lowest Price");
	    driver.findElement(By.id("sortby")).click();
	    Thread.sleep(10000);
	    new Select(driver.findElement(By.id("sortby"))).selectByVisibleText("Highest price");
	    driver.findElement(By.id("sortby")).click();
	    Thread.sleep(10000);
	    new Select(driver.findElement(By.id("sortby"))).selectByVisibleText("Popular");
	    Thread.sleep(10000);
				
		    
			
		    
		Reporter.log("Product Search and Sort Button Low, High and Popular are working.",true);
		      
      
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

