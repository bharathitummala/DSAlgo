package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepdefinitions.DriverFactory;

public class Hooks {
	private static WebDriver driver;

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}