package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private static WebDriver driver;

	private DriverFactory() {
		// Prevent instantiation
	}

	public static synchronized WebDriver getDriver() {
		if (driver == null) {
//          System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static synchronized void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
