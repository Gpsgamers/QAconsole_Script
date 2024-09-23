package console_script;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sanity extends method {
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	@Given("enter the URL")
	public void enter_the_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://console.mirrorfly.com");
	}

	@Then("Login the application")
	public void login_the_application() throws InterruptedException {
		login("rahul.s@contus.in", "SuperAdmin!@#$1234");
		Thread.sleep(4000);
	}

	//
	@Given("on {int}")
	public void on(Integer int1) throws InterruptedException {
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(pageloader));
		WebElement Top_active_users = driver.findElement(Top_Active_Users(int1));
		if (Top_active_users.getAttribute("class").equals("active") == false) {
			Top_active_users.click();
		}
	}

	@Given("In plan type {string}")
	public void in_plan_type(String string) throws InterruptedException {
		driver.findElement(plan_Type_Dropdown).click();
		driver.findElement(plan_type_selection(string)).click();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(pageloader));
	}

	@When("Verify if {string} value exist")
	public void verify_if_value_exist(String string) throws InterruptedException {
		driver.findElement(analysisTabs(string)).click();
		WebElement value = driver.findElement(values(1));
		System.out.println(numberExtract(value));
		System.out.println(value.getText());
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with {string} and {int}")
	public void verify_if_graph_exist_with_and(String string, Integer int1) throws AWTException {
		Graph_and_value(values(1),graph_Xaxis(1),graph_Yaxis(1));
	}
	

	@When("verify if Total message value exist")
	public void verify_if_total_message_value_exist() throws InterruptedException {
		WebElement value = driver.findElement(values(2));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total message and {int}")
	public void verify_if_graph_exist_with_total_message_and (Integer int1) {
		Graph_and_value(values(2),graph_Xaxis(3),graph_Yaxis(3));
	}
	
	///
	
	@Given("Select platform {string}")
	public void select_platform(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(analysisTabs(string)).click();
	}

	@When("verify if New users value exist")
	public void verify_if_new_users_value_exist() {
		WebElement value = driver.findElement(values(4));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}


	@When("Verify if Graph exist with New users and {int}")
	public void verify_if_graph_exist_with_new_users_and(Integer int1) {
		Graph_and_value(values(4),graph_Xaxis(5),graph_Yaxis(5));
	}
	
	
	@Given("Select calltype {string}")
	public void select_calltype(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(analysisTabs_indexed(string,1)).click();
	}
	
	@When("verify if Total Call Duration value exist")
	public void verify_if_total_call_duration_value_exist() {
		WebElement value = driver.findElement(values(3));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total call duration and {int}")
	public void verify_if_graph_exist_with_total_call_duration_and(Integer int1) {
		Graph_and_value(values(3),graph_Xaxis(4),graph_Yaxis(4));
	}
	
	///

	@Given("Select call {string}")
	public void select_call(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(analysisTabs_indexed(string,2)).click();
	}

	@When("verify if Total Calls value exist")
	public void verify_if_total_calls_value_exist() {
		WebElement value = driver.findElement(values(5));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total calls and {int}")
	public void verify_if_graph_exist_with_total_calls_and(Integer int1) {
		Graph_and_value(values(5),graph_Xaxis(6),graph_Yaxis(6));
	}
	

}
