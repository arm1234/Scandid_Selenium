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

public class Test4_1_FB_Login_Logout extends BusinessFunctions {
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
    
        
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("scandid.ex@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("scandid123");
    driver.findElement(By.id("u_0_2")).click();
    
    driver.switchTo().window(parentWindowHandle);
    Thread.sleep(20000);
   //driver.findElement(By.xpath("//ul[@id='ubermenu-nav-main-2-primary']/li[4]/a/span")).click();
   //Thread.sleep(20000);
    driver.findElement(By.xpath("//div[@id='header']/div/div/div[2]/div/div[2]/div/span")).click();
    driver.findElement(By.xpath("(//li[@onclick=\"redirect_url('/logout')\"])[2]")).click();
    Thread.sleep(10000);
    Reporter.log("Login Logout is successful",true);
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
