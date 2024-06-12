package Hooks;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	
	
	WebDriver driver;
	
	@Before   // hooks  // executed every each scenario
	public void setup() {
		
        Properties prop = ConfigReader.initializePropertiesfiles();
        driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
	}
	
	
	
	@After // Executed after every hooks
	public void teardown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			
		 byte[] srcScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(srcScreenshot, "image/png", scenarioName);
			
		}
		
		
		driver.quit();
		
		
	}

}
