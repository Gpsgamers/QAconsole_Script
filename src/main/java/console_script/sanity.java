package console_script;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class sanity extends method {
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Given("enter the URL")
	public void enter_the_url() {
//		driver = new ChromeDriver();
//		System.out.println(driver);
//		driver.manage().window().maximize();
		driver.get("https://console.mirrorfly.com");
	}

	@When("login the application Superadmin")
	public void login_the_application_Superadmin() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(sign_in));
		login("rahul.s@contus.in", "SuperAdmin!@#$1234");
		Thread.sleep(3000);
	}

	@When("login the application Admin")
	public void login_the_application_Admin() throws InterruptedException {
		login("rahul.s@contus.in", "SuperAdmin!@#$1234");
		Thread.sleep(3000);
	}

	@Given("on {int}")
	public void on(Integer int1) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(pageloader));
		} catch (Exception e) {

		}
		WebElement Top_active_users = driver.findElement(Top_Active_Users(int1));
		if (Top_active_users.getAttribute("class").equals("active") == false) {
			Top_active_users.click();
		}
	}

	@Given("In plan type {string}")
	public void in_plan_type(String string) throws InterruptedException {
		driver.findElement(plan_Type_Dropdown).click();
		driver.findElement(plan_type_selection(string)).click();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(pageloader));
		} catch (Exception e) {

		}
	}

	@When("Verify if {string} value exist")
	public void verify_if_value_exist(String string) {
		WebElement analysistab = wait.until(ExpectedConditions.visibilityOfElementLocated(analysisTabs(string)));
		analysistab.click();
		WebElement value = driver.findElement(values(1));
		System.out.println(numberExtract(value));
		System.out.println(value.getText());
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with {string} and {int}")
	public void verify_if_graph_exist_with_and(String string, Integer int1) {
		WebElement Values = wait.until(ExpectedConditions.visibilityOfElementLocated(values(1)));
		Graph_and_value(Values, graph_Xaxis(1), graph_Yaxis(1));
	}

	@When("verify if Total message value exist")
	public void verify_if_total_message_value_exist() {
		WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(values(2)));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total message and {int}")
	public void verify_if_graph_exist_with_total_message_and(Integer int1) {
		WebElement Values = wait.until(ExpectedConditions.visibilityOfElementLocated(values(2)));
		Graph_and_value(Values, graph_Xaxis(3), graph_Yaxis(3));
	}

	@Given("Select platform {string}")
	public void select_platform(String string) throws InterruptedException {
		WebElement analysistab = wait.until(ExpectedConditions.visibilityOfElementLocated(analysisTabs(string)));
		analysistab.click();
	}

	@When("verify if New users value exist")
	public void verify_if_new_users_value_exist() {
		WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(values(4)));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with New users and {int}")
	public void verify_if_graph_exist_with_new_users_and(Integer int1) {
		WebElement Values = wait.until(ExpectedConditions.visibilityOfElementLocated(values(4)));
		Graph_and_value(Values, graph_Xaxis(5), graph_Yaxis(5));
	}

	@Given("Select calltype {string}")
	public void select_calltype(String string) throws InterruptedException {
		WebElement analysisTabs = wait
				.until(ExpectedConditions.visibilityOfElementLocated(analysisTabs_indexed(string, 1)));
		analysisTabs.click();
	}

	@When("verify if Total Call Duration value exist")
	public void verify_if_total_call_duration_value_exist() {
		WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(values(3)));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total call duration and {int}")
	public void verify_if_graph_exist_with_total_call_duration_and(Integer int1) {
		WebElement Values = wait.until(ExpectedConditions.visibilityOfElementLocated(values(3)));
		Graph_and_value(Values, graph_Xaxis(4), graph_Yaxis(4));
	}

	@Given("Select call {string}")
	public void select_call(String string) throws InterruptedException {
		WebElement analysisTabs = wait
				.until(ExpectedConditions.visibilityOfElementLocated(analysisTabs_indexed(string, 2)));
		analysisTabs.click();
	}

	@When("verify if Total Calls value exist")
	public void verify_if_total_calls_value_exist() {
		WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(values(5)));
		System.out.println(numberExtract(value));
		Assert.assertTrue(value.isDisplayed(), "element not displayed");
		Assert.assertTrue(numberExtract(value) >= 0, "number is not displayed");
	}

	@When("Verify if Graph exist with Total calls and {int}")
	public void verify_if_graph_exist_with_total_calls_and(Integer int1) {
		WebElement Values = wait.until(ExpectedConditions.visibilityOfElementLocated(values(5)));
		Graph_and_value(Values, graph_Xaxis(6), graph_Yaxis(6));
	}

//////
	static String value;
//	@Given("Get the value on the total customer on the dashboard")
//	public void get_the_value_on_the_total_customer_on_the_dashboard() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Click on the view details on total customer")
//	public void click_on_the_view_details_on_total_customer() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("total customer value on the dashboard and on the customer is equal")
//	public void total_customer_value_on_the_dashboard_and_on_the_customer_is_equal() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Get the value on the Active Customers on the dashboard")
//	public void get_the_value_on_the_active_customers_on_the_dashboard() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Click on the view details on active customer")
//	public void click_on_the_view_details_on_active_customer() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Active Customers value on the dashboard and on the customer is equal")
//	public void active_customers_value_on_the_dashboard_and_on_the_customer_is_equal() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Get the value on the Trial Customers on the dashboard")
//	public void get_the_value_on_the_trial_customers_on_the_dashboard() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Click on the view details on trial customer")
//	public void click_on_the_view_details_on_trial_customer() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Trial Customers value on the dashboard and on the customer is equal")
//	public void trial_customers_value_on_the_dashboard_and_on_the_customer_is_equal() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Click on the view details by total paid customer")
//	public void click_on_the_view_details_by_total_paid_customer() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Total Paid Customers value on the dashboard and on the payments page is equal")
//	public void total_paid_customers_value_on_the_dashboard_and_on_the_payments_page_is_equal() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

	// -------------------logout--------------------------------------------//

	@Given("click on the profile initial")
	public void click_on_the_profile_initial() {
		driver.findElement(profile_initial).click();
	}

	@When("click on the logout from the dropdown")
	public void click_on_the_logout_from_the_dropdown() {
		WebElement Logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		Logout.click();
	}

	@Then("click on the logout button")
	public void click_on_the_logout_button() {
		WebElement Logout_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(logout_btn));
		Logout_btn.click();
	}
	// ----------------------

}
