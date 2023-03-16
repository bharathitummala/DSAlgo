package hooks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepdefinitions.DriverFactory;

public class Hooks {
	private static WebDriver driver;

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot(scenario)).build());
		}
		DriverFactory.quitDriver();
	}

	public String getBase64Screenshot(Scenario scenario) throws FileNotFoundException, IOException {
		String image = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		byte[] data = Base64.decodeBase64(image);
		String directory = System.getProperty("user.dir") + "/target/SystemTestReports/Extent/screenshot/"
				+ scenario.getName() + ".jpg";
		try (OutputStream stream = new FileOutputStream(directory)) {
			stream.write(data);
		}
		return image;
	}

	public static WebDriver getDriver() {
		return driver;
	}
}