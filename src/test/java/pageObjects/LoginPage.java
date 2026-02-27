package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = ("//input[@id='input-email']"))
	WebElement email;
	@FindBy(xpath = ("//input[@id='input-password']"))
	WebElement pwd;
		
	@FindBy(xpath = ("//input[@value='Login']"))
	WebElement loginbtn;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	WebElement errorMessageElement;

	public void emailsend(String sndemail) {
		// email.sendKeys(sndemail);
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(sndemail);
	}

	public void pwdend(String sndpwd) {
		// pwd.sendKeys(sndpwd);
		wait.until(ExpectedConditions.visibilityOf(pwd));
		pwd.sendKeys(sndpwd);
	}

	public void loginClick() {
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();

	}

	public boolean isErrorMessageDisplayed() {
		try {
			return errorMessageElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
