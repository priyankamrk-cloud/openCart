package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "My Account")
	WebElement lnkMyAccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegis;

	@FindBy(linkText = "Login")
	WebElement lnkLogin;

	public void clickOnAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccount)).click();
	}

	public void clickOnRegis() {
		wait.until(ExpectedConditions.visibilityOf(lnkRegis));
		wait.until(ExpectedConditions.elementToBeClickable(lnkRegis)).click();
	}

	public void clickOnLogin() {
		wait.until(ExpectedConditions.visibilityOf(lnkLogin));
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
	}
}
