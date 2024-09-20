package console_script;

import org.openqa.selenium.By;

public class Element {
	//login page 
	public static By emailfield = By.xpath("//*[@label ='email']");
	public static By password = By.xpath("//*[@label ='password']");
	public static By sign_in = By.xpath("//*[text() ='Sign In']");
	
	// Analytics page
	/// recent activity section
	public static String button_name,index ; 
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
	public static By analysisTabs_indexed = By.xpath("(//button[text() = '"+button_name+"'])["+index+"]");
	public static By values = By.xpath("(//div[@class='analysisValue'])["+index+"]");
	public static By values_span = By.xpath("(//div[@class='analysisValue']/span)["+index+"]");
	public static By graph_layer_indexed = By.xpath("(//*[@class='recharts-cartesian-grid-horizontal'])["+index+"]");
	public static By graph_circle = By.xpath("//circle");
	
	
	
}
