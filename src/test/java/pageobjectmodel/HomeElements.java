package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeElements {
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement successmsg;
	@FindBy(xpath = "//ul/a[contains(text(),'Register')]")
	WebElement registerurl;

	public String getsuccessmsg() {
		return successmsg.getText();
	}

	public void clickregisterurl() {
		registerurl.click();
	}

}
