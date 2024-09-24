package console_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\main\\java\\feature_file\\", // Path to feature files
		glue = { "console_script" }, // Package for step definitions
		plugin = { "pretty", // For console output
				"html:target/cucumber-reports/Cucumber.html", // HTML report
				"json:target/cucumber-reports/Cucumber.json" // JSON report
		}, monochrome = true // To make console output more readable
)
public class Runner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeClass
	public static void browserlaunchconfiguration() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void browserQuitconfiguration() {
		driver.quit();
	}

}
