package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dsutilities.LoggerLoad;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.LoginElements;

public class Login {
	WebDriver driver = Hooks.getDriver();

	// Login WebElements
	LoginElements loginElements = PageFactory.initElements(driver, LoginElements.class);
	// LoginElements loginElements2 = new LoginElements(driver);

	@Given("I navigate to login")
	public void i_navigate_to_login() {
		driver.get("https://dsportalapp.herokuapp.com/login");
		driver.manage().window().maximize();
	}

	@When("I enter {word} and {word}")
	public void i_enter_username_and_password(String arg1, String arg2) {
		loginElements.setUsername(arg1);
		loginElements.setPassword(arg2);
	}

	@When("^I click Login button$")
	public void i_click_login_button() {
		loginElements.clickSubmit();
	}

	@Then("Success message {string} is displayed")
	public void success_message_is_displayed(String message) {
		Assert.assertEquals(loginElements.retrieveMsg(), message);
		driver.close();
	}

	@Then("Error message {string} is displayed")
	public void error_message_is_displayed(String message) {
		LoggerLoad.info("Checking error message: " + message);
		Assert.assertEquals(loginElements.retrieveMsg(), message);
		driver.close();
	}

}
