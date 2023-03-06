package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.HomeElements;
import pageobjectmodel.RegisterElements;
import pageobjectmodel.UserData;

public class Register {
	WebDriver driver = new ChromeDriver();
	RegisterElements registerElements = PageFactory.initElements(driver, RegisterElements.class);

	@Given("I navigate to Register page")
	public void i_navigate_to_register_page() {
		driver.get("https://dsportalapp.herokuapp.com/register");
		driver.manage().window().maximize();
	}

	@When("I enter {word} and {word} and {word}")
	public void i_enter_username_and_password(String arg1, String arg2, String arg3) {
		registerElements.setregUsername(UserData.USERNAME);
		registerElements.setregPassword(arg2);
		registerElements.cnfmpasswordreg(arg3);

	}

	@When("I click Register button")
	public void i_click_register_button() {
		registerElements.clickRegister();
	}

	@Then("I see success message {string} is displayed")
	public void i_see_success_message_is_displayed(String successmsg) {
		HomeElements homeelements = PageFactory.initElements(driver, HomeElements.class);
		Assert.assertEquals(homeelements.getsuccessmsg(), successmsg + " " + UserData.USERNAME);
		driver.close();
	}

	@Then("I see failure message {string} is displayed")
	public void i_see_failure_message_is_displayed(String failuremsg) {
		HomeElements homeelements = PageFactory.initElements(driver, HomeElements.class);
		Assert.assertEquals(homeelements.getsuccessmsg(), failuremsg);
		driver.close();
	}

	/*
	 * @Then("I see input error message {string} is displayed") public void
	 * i_see_input_error_message_is_displayed(String inputError) { //
	 * System.out.println("empty text msg: " +
	 * registerElements.getEmptyPasswordError());
	 * registerElements.getEmptyPasswordError();
	 * 
	 * }
	 */

	@When("^I enter invalid ([^\"]*) and ([^\"]*) and ([^\"]*)$")
	public void i_enter_in_valid_numpy_sdet102_and_and(String arg1, String arg2, String arg3) {
		registerElements.getEmptyPasswordError();
		registerElements.setregUsername(arg1);
		registerElements.setregPassword(arg2);
		registerElements.cnfmpasswordreg(arg3);

	}

}
