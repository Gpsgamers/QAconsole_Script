package console_script;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class method extends Element {
	public static WebDriver driver;
	public static Robot action;

	public static void login(String Email, String Password) {
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}

	public static float numberExtract(WebElement ele) {
		float f = (float) -1.0;
		try {
			String value = ele.getText();
			value = value.replace("\n", " ").replace("\r", "");
			f = Float.parseFloat(value.substring(0, value.indexOf(" ")));
		} catch (Exception e) {
			f = (float) -1.0;
			return f;
		}
		return f;
	}

//	public static void takeScreenshot(String fileName) {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./screen shot" + fileName);
//		try {
//			FileUtils.copyFile(srcFile, destFile);
//			System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
//		} catch (IOException e) {
//			System.out.println("Failed to save screenshot: " + e.getMessage());
//		}
//	}
//
//	public static void executeSafely(Runnable operation) {
//		try {
//			operation.run();
//		} catch (Exception e) {
//			String filename = "screenshot_on_failure" + Math.random() + ".png";
//			takeScreenshot(filename);
//			System.out.println(e);
//		}
//	}
}
