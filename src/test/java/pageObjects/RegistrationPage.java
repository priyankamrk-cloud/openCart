package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtphone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpwd;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtcnfpwd;
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	WebElement txtnwslett;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement txtagree;
	@FindBy(css = "input[type='submit']")
	WebElement btncont;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfmsg;

	public void setFname(String fname) {
		txtfname.sendKeys(fname);
	}

	public void setLname(String lname) {
		txtlname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setphone(String phone) {
		txtphone.sendKeys(phone);
	}

	public void setPwd(String pwd) {
		txtpwd.sendKeys(pwd);
	}

	public void setcnfPwd(String cnfpwd) {
		txtcnfpwd.sendKeys(cnfpwd);
	}

	public void submitform() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", txtnwslett);
		js.executeScript("arguments[0].click();", txtagree);
		js.executeScript("arguments[0].click();", btncont);
	}

	/*
	 * public void selectNewsletter() { txtnwslett.click(); } public void
	 * acceptPrivacyPolicy() { txtagree.click(); } public void clickContinue() {
	 * btncont.click(); }
	 */
	public String getCnfmsg() {
		return cnfmsg.getText();
	}

}
