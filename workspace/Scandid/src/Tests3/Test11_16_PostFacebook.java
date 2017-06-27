
package Tests3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test11_16_PostFacebook extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if Facebook Post is working fine
	  
	    Thread.sleep(10000);
		driver.get("http://scandid.in/pricelist/memory-cards?ref=refsec_menu");
		Thread.sleep(10000);
				
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/a/img")).click();
		
		Thread.sleep(20000);
			
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	    
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/div/div")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/div/div")).sendKeys("Like");
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//button[@value='1']")).click();
	    Thread.sleep(10000);
	    
	    //driver.findElement(By.cssSelector("textarea._1cb._1u9t")).clear();
	    //driver.findElement(By.cssSelector("textarea._1cb._1u9t")).sendKeys("Like");
	    //driver.findElement(By.xpath("//button[@value='1']")).click();
	    Thread.sleep(10000);
	    
	    
	Reporter.log("Facebook Post is working Fine.",true);
	
      
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

