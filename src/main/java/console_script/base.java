package console_script;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class base extends method {
	@Given("enter the URL")
	public void enter_the_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://console.mirrorfly.com");
	}

	@Then("Login the application")
	public void login_the_application() {
		login("rahul.s@contus.in", "SuperAdmin!@#$1234");
	}
}
