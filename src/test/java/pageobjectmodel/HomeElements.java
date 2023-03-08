package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeElements {
	WebDriver driver;

	public HomeElements(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement successmsg;

	@FindBy(xpath = "//ul/a[contains(text(),'Register')]")
	WebElement registerurl;
	@FindBy(xpath = "//a[@href='graph']")
	WebElement graphurlclick;
	@FindBy(xpath = "//a[@href='/login']")
	WebElement siginUrl;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement loginerrormsg;

	public String getsuccessmsg() {
		return successmsg.getText();
	}

	public void clickregisterurl() {
		registerurl.click();
	}

	public void clickgraphUrl() {
		graphurlclick.click();
	}

	public void clickSignin() {
		siginUrl.click();
	}

	public String retrieveLoginMsg() {
		return loginerrormsg.getText();
	}

}
