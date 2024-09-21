package console_script;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sanity extends method {
	@Given("enter the URL")
	public void enter_the_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://console.mirrorfly.com");
	}

	@Then("Login the application")
	public void login_the_application() {
		login("rahul.s@contus.in", "SuperAdmin!@#$1234");
	}

	//
	@Given("on {int}")
	public void on(Integer int1) throws InterruptedException {
		WebElement Top_active_users = driver.findElement(Top_Active_Users(int1));
		if (Top_active_users.getAttribute("class").equals("active") == false) {
			Top_active_users.click();
		}
		Thread.sleep(1000);
	}

	@Given("In plan type {string}")
	public void in_plan_type(String string) throws InterruptedException {
		driver.findElement(plan_Type_Dropdown).click();
		Thread.sleep(500);
		driver.findElement(plan_type_selection(string)).click();
		Thread.sleep(500);
	}

	@When("Verify if {string} value exist")
	public void verify_if_value_exist(String string) throws InterruptedException {
		driver.findElement(analysisTabs(string)).click();
		WebElement value = driver.findElement(values(1));
//		Assert.assertTrue(value.isDisplayed(), "element not displayed");
//		System.out.println(numberExtract(value)+"string");
		Assert.assertTrue(numberExtract(value)>=0,"number is not displayed");
		Thread.sleep(500);
	}

	@When("Verify if Graph not exist when {string} <={int}")
	public void verify_if_graph_not_exist_when(String string, Integer int1) {
		System.out.println();
	}

	@When("Verify if Graph exist when Total {string} >{int}")
	public void verify_if_graph_exist_when_total(String string, Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
