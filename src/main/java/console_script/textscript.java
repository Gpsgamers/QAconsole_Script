package console_script;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.devtools.v128.network.Network;

public class textscript {
	public static void main(String[] args) throws IOException, AWTException {
		// Setting up the Chrome driver and DevTools session
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		// Emulate offline network conditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		devTools.send(Network.emulateNetworkConditions(true, 100, 0, 0, null, null, null, null));
		
		// Reconnect to the internet by setting offline to false
		devTools.send(Network.emulateNetworkConditions(
				false, 
				0, 
				50000, 
				50000, 
				Optional.of(ConnectionType.WIFI), 
				Optional.of(0.0), 
				null, null));
		driver.get("https://example.com");
		// Proceed with further test steps
		driver.navigate().refresh();

	}
}
