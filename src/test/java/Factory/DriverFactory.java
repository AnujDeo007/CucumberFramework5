package Factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utils.CommonsUtils;
import Utils.ConfigReader;

public class DriverFactory {

   static WebDriver driver = null;
	
	public static WebDriver initializeBrowser(String browserName) {
		
	
		
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browserName.equals("safari")) {
			
			driver = new SafariDriver();
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonsUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonsUtils.IMPLICIT_WAIT_TIME));
		
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	
	
}
