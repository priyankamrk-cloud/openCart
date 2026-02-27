package testCase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Master"})
	public void Accountvalid() {
		logger.info("Open the cart to Register");
		
		HomePage hpg = new HomePage(driver);		
		hpg.clickOnAccount();
		logger.info("Selected the My Account");
		
		hpg.clickOnRegis();
		logger.info("selected to Register");
		logger.info("Providing customer detailsr");
		RegistrationPage rgp = new RegistrationPage(driver);
		rgp.setFname(randomeString());
		rgp.setLname(randomeString());
	//	rgp.setEmail(randomeString()+"@gmail.com");
		rgp.setEmail(generateUniqueEmail());
		rgp.setphone(randomeNumber());
		String txtpwd = "Test1234";
		rgp.setPwd(txtpwd);
		rgp.setcnfPwd(txtpwd);
		rgp.submitform();
		System.out.println("After submit URL: " + driver.getCurrentUrl());
		System.out.println("Page contains warning? " +
		        driver.getPageSource().contains("Warning"));
		logger.info("validating expected msg");		
		boolean isSuccess;
		try {
		    wait.until(ExpectedConditions.urlContains("success"));
		    isSuccess = true;
		} catch (Exception e) {
		    isSuccess = false;
		}

		System.out.println("Current URL: " + driver.getCurrentUrl());

		if (isSuccess) {

		    String msg = rgp.getCnfmsg().trim();
		    System.out.println("Actual message: " + msg);

		    Assert.assertEquals(msg,
		            "Your Account Has Been Created!",
		            "Account registration failed");

		} else {

		    System.out.println("Registration failed. Still on page: "
		            + driver.getCurrentUrl());

		    Assert.fail("Registration did not navigate to success page.");
		}
	

		logger.info("Testcase Completed");
		
	
	}

}
