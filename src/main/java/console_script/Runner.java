package console_script;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\main\\java\\feature_file\\sanity.feature", // Path to feature files
	    glue = {"stepDefinitions"},               // Package for step definitions
	    plugin = {
	        "pretty",                              // For console output
	        "html:target/cucumber-reports/Cucumber.html",   // HTML report
	        "json:target/cucumber-reports/Cucumber.json"    // JSON report
	    },
	    monochrome = true                          // To make console output more readable
	)
public class Runner {

	
	
}
