package console_script;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class method extends Element {
	public static WebDriver driver;
	public static Actions actions ;
	
	public static void scrollToelement(WebElement  elementToScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	}

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

	public static void takeScreenshot(String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screen shot" + fileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
	}

	public static void executeSafely(Runnable operation) {
		try {
			operation.run();
		} catch (Exception e) {
			String filename = "screenshot_on_failure" + Math.random() + ".png";
			takeScreenshot(filename);
			System.out.println(e);
		}
	}
	
	public static void Graph_and_value(By Value, By graphXaxis,By graphYaxis){
		WebElement value = driver.findElement(Value);
		Boolean GraphXaxis = false;
		Boolean GraphYaxis = false;
		try {
			GraphXaxis = driver.findElement(graphXaxis).isDisplayed();
			GraphYaxis = driver.findElement(graphYaxis).isDisplayed();
		}catch(Exception e){
			GraphXaxis = false;
			GraphYaxis = false;
		}
		System.out.println(GraphXaxis+" "+GraphYaxis);
		if (numberExtract(value) == 0) {
			Assert.assertTrue(!GraphXaxis && !GraphYaxis,"Value is not dispalyed with graph");
		} else if(numberExtract(value) >= 0) {
			Assert.assertTrue(GraphXaxis && GraphYaxis ,"graph is not displayed");
		}
	}
}
