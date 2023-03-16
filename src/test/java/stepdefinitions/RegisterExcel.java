package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.RegisterExcelElements;
import utilities.ExcelReader;

public class RegisterExcel {
	WebDriver driver = Hooks.getDriver();

	RegisterExcelElements registerExcelElements = PageFactory.initElements(driver, RegisterExcelElements.class);
	String expectedmessage;

	@Given("User navigate to Register page")
	public void user_navigate_to_register_page() {
		driver.get("https://dsportalapp.herokuapp.com/register");
		driver.manage().window().maximize();
	}

	@When("User enters user data {string} and {int}")
	public void user_enters_user_data_and(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/config/Exceldata/Registration.xlsx", sheetname);
		String username = testdata.get(rownumber).get("username");
		String password = testdata.get(rownumber).get("password");
		String confirmpassword = testdata.get(rownumber).get("confirmpassword");
		expectedmessage = testdata.get(rownumber).get("expectedmessage");
		registerExcelElements.setregUsername(username);
		registerExcelElements.setregPassword(password);
		registerExcelElements.cnfmpasswordreg(confirmpassword);
		// registerExcelElements.printRetrievemsg();

	}

	@When("User clicks Register button")
	public void user_clicks_register_button() {
		registerExcelElements.clickRegister();
	}

	@Then("User sees a an approriate message")
	public void user_sees_a_an_approriate_message() {
		Assert.assertEquals(registerExcelElements.printRetrievemsg(), expectedmessage);
		driver.close();
	}

}
