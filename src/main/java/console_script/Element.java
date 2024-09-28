package console_script;

import org.openqa.selenium.By;

public class Element extends Runner {
	//login page 
	public static By emailfield = By.xpath("//*[@label ='email']");
	public static By password = By.xpath("//*[@label ='password']");
	public static By sign_in = By.xpath("//*[text() ='Sign In']");
	public static By pageloader = By.xpath("(//div[@class='pageLoader fixed overlay'])[1]");
	//logout
	public static By profile_initial = By.xpath("//span[@class='profileInitial']");
	public static By logout = By.xpath("//*[@class='logout']");
	public static By logout_btn = By.xpath("//span[text()='Logout']");
	// Analytics page
	/// recent activity section
	public static By plan_Type_Dropdown = By.xpath("//*[@for ='planTypeId']");
	public static By plan_type_selection(String plantype) { 
		return By.xpath("//button[@data-value ='"+plantype+"']");
		}
	public static By Top_Active_Users (int index) {
		return By.xpath("(//span[text()='#"+index+"']/../..)[1]");
	}
	//// graph element
	public static By analysisTabs(String button_name) {
		return By.xpath("//button[text() = '"+button_name+"']");
	}
	public static By analysisTabs_indexed (String button_name, int index) {
		return By.xpath("(//button[text() = '"+button_name+"'])["+index+"]");
	}
	public static By values(int index) {
		return By.xpath("(//div[@class='analysisValue'])["+index+"]");
	}
	public static By values_span(int index){
		return By.xpath("(//div[@class='analysisValue']/span)["+index+"]");
	}
	public static By graph_Xaxis (int index) {
		return By.xpath("(//div[@class='recharts-wrapper'])["+index+"]//*[@class='recharts-layer recharts-cartesian-axis recharts-xAxis xAxis']");
	}
	public static By graph_Yaxis (int index) {
		return By.xpath("(//div[@class='recharts-wrapper'])["+index+"]//*[@class='recharts-layer recharts-cartesian-axis recharts-yAxis yAxis']");
	}
	//// quick over view 
	public static By cardvalue(int index) {
		return By.xpath("(//span[@class='cardValue'])["+index+"]");
	}
	public static By Viewdetails(int index) {
		return By.xpath("(//span[text()='View details'])["+index+"]");
	}
	public static By info= By.xpath("//span[@class='info']");
	public static By home_page_btn = By.xpath("(//a[@href='/analytics'])[1]");
	public static By no_customer_label=By.xpath("//span[text()='No customers found']");
}
