package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountpage extends BasePage {

	public MyAccountpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "My Account")
	WebElement ScreenMsg;
	@FindBy(xpath = ("//a[@class='list-group-item'][normalize-space()='Logout']"))
	WebElement Logout;

	public boolean ValidateScreenMsg() {
		if (ScreenMsg.isDisplayed()) {
			return true;
		} else
			return false;

	}

	public void ClickLogout() {
		System.out.println(driver.getCurrentUrl());
		Logout.click();
	}

}
