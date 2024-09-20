package console_script;


import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class method extends Element {
	public static WebDriver driver ;
	public static Robot action;
	public static void login(String Email,String Password ) {
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}
}
