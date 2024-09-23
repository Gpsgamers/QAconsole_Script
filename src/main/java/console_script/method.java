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
	public static Actions actions;

	public static void scrollToelement(WebElement elementToScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	}

	public static void login(String Email, String Password) {
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}

	public static float numberExtract(WebElement value) {
		String num = value.getText();
		int i = 0;
		float total = 0.0f;
		if (num.contains(".")) {
			int index = num.indexOf(".");
			total = Float.parseFloat(num.substring(0, index));
			String s = num.substring(++index);
			float decimal = 0.0f;
			while (true) {
				try {
					float f = Float.parseFloat(s.substring(i, ++i));
					decimal = (decimal * 10) + f;
				} catch (Exception e) {
					decimal = (float) (decimal / Math.pow(10, --i));
					break;
				}
			}
			return total + decimal;
		} else {
			while (true) {
				try {
					float f = Float.parseFloat(num.substring(i, ++i));
					total = (total * 10) + f;
				} catch (Exception e) {
					break;
				}

			}
			return total;
		}
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

	public static void Graph_and_value(By Value, By graphXaxis, By graphYaxis) {
		WebElement value = driver.findElement(Value);
		Boolean GraphXaxis = false;
		Boolean GraphYaxis = false;
		try {
			GraphXaxis = driver.findElement(graphXaxis).isDisplayed();
			GraphYaxis = driver.findElement(graphYaxis).isDisplayed();
		} catch (Exception e) {
			GraphXaxis = false;
			GraphYaxis = false;
		}
		System.out.println(GraphXaxis + " " + GraphYaxis);
		if (numberExtract(value) == 0) {
			Assert.assertTrue(!GraphXaxis && !GraphYaxis, "Value is not dispalyed with graph");
		} else if (numberExtract(value) >= 0) {
			Assert.assertTrue(GraphXaxis && GraphYaxis, "graph is not displayed");
		}
	}
}
