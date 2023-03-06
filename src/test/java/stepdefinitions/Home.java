package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class Home {
	WebDriver driver = new ChromeDriver();

	@Given("The user navigates to Home page")
	public void the_user_navigates_to_home_page() {
		driver.get("https://dsportalapp.herokuapp.com/home");
		driver.manage().window().maximize();
		// comment close window
		driver.close();

	}

}
