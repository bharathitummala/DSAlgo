package pageobjectmodel;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterExcelElements {

	WebDriver driver;

	public RegisterExcelElements(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameinput;
	@FindBy(xpath = "//input[@name='password1']")
	WebElement passwordreg;
	@FindBy(xpath = "//input[@name='password2']")
	WebElement cnfmpasswordreg;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement registerbtn;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement retrievemsg;

	public void setregUsername(String username) {
		usernameinput.sendKeys(username);
	}

	public void setregPassword(String regpwd) {
		passwordreg.sendKeys(regpwd);
	}

	public void cnfmpasswordreg(String cnfmpwd) {
		cnfmpasswordreg.sendKeys(cnfmpwd);
	}

	public void clickRegister() {
		registerbtn.click();
	}

	public String printRetrievemsg() {
		try {
			return retrievemsg.getText();
		} catch (NoSuchElementException e) {
			if (usernameinput.getAttribute("value").isBlank()) {
				return usernameinput.getAttribute("validationMessage");
			} else if (passwordreg.getAttribute("value").isBlank()) {
				return passwordreg.getAttribute("validationMessage");
			} else if (cnfmpasswordreg.getAttribute("value").isBlank()) {
				return cnfmpasswordreg.getAttribute("validationMessage");
			}
		}
		return "";
	}

	/*
	 * public void getEmptyPasswordError() {
	 * passwordreg.getAttribute("validationMessage");
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver; Boolean is_valid =
	 * (Boolean) js.executeScript("return arguments[0].checkValidity();",
	 * passwordreg); System.out.println("passowrd: " + is_valid + " message: " +
	 * passwordreg.getAttribute("required")); }
	 */

}
