package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features",
				 glue={"StepDefination","Hooks"},
				 publish=true,
				 monochrome = true,
				    		
			   // plugin = {"pretty", "json:target/MyReports/report.json","junit:target/MyReports/report.xml"}
				 plugin={"pretty","html:target/CucumberReports/CucumberReport.html"}
)
public class TestRunner {
	
	

}