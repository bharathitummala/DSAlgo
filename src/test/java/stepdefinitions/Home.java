package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.HomeElements;
import pageobjectmodel.LoginElements;

public class Home {
	WebDriver driver = Hooks.getDriver();

	HomeElements homeelements = PageFactory.initElements(driver, HomeElements.class);

	@Given("The user navigates to Home page")
	public void the_user_navigates_to_home_page() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}

	@When("The user click on Get started button")
	public void the_user_click_on_get_started_button() {
		homeelements.clickgraphUrl();

	}

	@Then("User sees Error message {string} is displayed")
	public void user_sees_error_message_is_displayed(String loginerrormsg) {
		Assert.assertEquals(homeelements.retrieveLoginMsg(), loginerrormsg);
	}

	@Then("User clicks on the Sign in")
	public void user_clicks_on_the_sign_in() throws InterruptedException {
		homeelements.clickSignin();

	}

	@When("User enters {word} and {word}")
	public void user_enter_username_and_password(String arg1, String arg2) {
		LoginElements loginElements = PageFactory.initElements(driver, LoginElements.class);
		loginElements.setUsername(arg1);
		loginElements.setPassword(arg2);
	}

	@Then("^User clicks Login button$")
	public void user_clicks_login_button() {
		LoginElements loginElements = PageFactory.initElements(driver, LoginElements.class);
		loginElements.clickSubmit();
	}

}
