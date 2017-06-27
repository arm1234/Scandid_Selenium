package Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BusinessFunctions {

	public static WebDriver driver;
	public Properties prop;
	public static String sAppUrl;
	
	public void OpenBrowser () throws FileNotFoundException, IOException  { 
	    
		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/SD_Configuration.properties"));
		sAppUrl = prop.getProperty("sAppUrl");
		
		// Different Drivers. Choose any one and comment the other two
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		//driver = new FirefoxDriver();
		 
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chromedriver.exe");
		driver = new ChromeDriver();	
	
		
		//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(sAppUrl);
	    
	    driver.manage().window().maximize();
	    
	    
	return ;
	}
	
	
	
	
}
