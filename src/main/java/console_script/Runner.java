package console_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
	public static String 
	SA_username, SA_pass_word,
	Admin_username,Admin_pass_word,
	url;
	@BeforeClass  
	public static void browserlaunchconfiguration() {
//		driver = driver("chrome");
//		Environment("QA");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get(url);
	}

	@AfterClass
	public static void browserQuitconfiguration() {
		driver.quit();
	}

//	public static WebDriver driver(String Browser) {
//		if (Browser.equals("chrome")) {
//			return new ChromeDriver();
//		} else if (Browser.equals("Edge")) {
//			return new EdgeDriver();
//		} else {
//			return null;
//		}
//	}
//
//	public static void Environment(String Env) {
//		switch (Env) {
//		case "QA":
//			url = "";
//			break;
//
//		case "DEV":
//			
//			break;
//		case "Live":
//			url = "https://console.mirrorfly.com/";
//			SA_username = "rahul.s@contus.in";
//			SA_pass_word = "SuperAdmin!@#$1234";
//			Admin_username = "rahul.s@contus.in";
//			Admin_pass_word = "SuperAdmin!@#$1234";
//			break;
//		}
//	}

}
