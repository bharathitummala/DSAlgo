package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElements {
	WebDriver driver;

	public LoginElements(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement successnerrormsg;

	public void setUsername(String name) {
		username.sendKeys(name);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickSubmit() {
		submit.click();
	}

	public String retrieveMsg() {
		return successnerrormsg.getText();
	}

}
