package console_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\main\\java\\feature_file\\sanity_SA.feature",
		"src\\main\\java\\feature_file\\sanity_Admin.feature" }, // Path to feature files
		glue = { "console_script" }, // Package for step definitions
		plugin = { "pretty", // For console output
				"html:target/cucumber-reports/Cucumber.html", // HTML report
				"json:target/cucumber-reports/Cucumber.json" // JSON report
		}, monochrome = true // To make console output more readable

)
public class Runner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String Browser, SA_username, SA_pass_word, Admin_username, Admin_pass_word, url;

	@BeforeClass
	@Parameters({ "browser", "environment" })
	public void browserlaunchconfiguration(String browser, String environment) {
		launchbrowser(browser);
		Environment(environment);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public static void browserQuitconfiguration() {
		driver.quit();
	}

	public void launchbrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		} else {
			driver = null;
		}
	}

	public void Environment(String Env) {
		switch (Env) {
		case "QA":
			url = "https://console.mirrorfly.com/";
			SA_username = "rahul.s@contus.in";
			SA_pass_word = "SuperAdmin!@#$1234";
			Admin_username = "rahul.s@contus.in";
			Admin_pass_word = "SuperAdmin!@#$1234";
			break;

		case "DEV":
			url = "https://console.mirrorfly.com/";
			SA_username = "rahul.s@contus.in";
			SA_pass_word = "SuperAdmin!@#$1234";
			Admin_username = "rahul.s@contus.in";
			Admin_pass_word = "SuperAdmin!@#$1234";
			break;
		case "Live":
			url = "https://console.mirrorfly.com/";
			SA_username = "rahul.s@contus.in";
			SA_pass_word = "SuperAdmin!@#$1234";
			Admin_username = "rahul.s@contus.in";
			Admin_pass_word = "SuperAdmin!@#$1234";
			break;
		}
	}

}
