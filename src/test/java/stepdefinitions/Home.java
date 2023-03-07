package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjectmodel.HomeElements;

public class Home {
	WebDriver driver = new ChromeDriver();

	HomeElements homeelements = PageFactory.initElements(driver, HomeElements.class);

	@Given("The user navigates to Home page")
	public void the_user_navigates_to_home_page() {
		driver.get("https://dsportalapp.herokuapp.com/home");
		driver.manage().window().maximize();
	}

	@Then("The user click on Get started button")
	public void the_user_click_on_get_started_button() {

		homeelements.clickgraphUrl();
	}

}
