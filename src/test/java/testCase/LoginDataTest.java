package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;
import utilities.Dataprovider;

public class LoginDataTest extends BaseClass {
	@Test(dataProvider = "dp", dataProviderClass = Dataprovider.class,groups= {"DataDriven","Master"})

	public void accountLogintest(String email, String password, String exp) {
		logger.info("Starting the Test");
		try {
			HomePage hmp = new HomePage(driver);
			hmp.clickOnAccount();
			hmp.clickOnLogin();

			LoginPage lpg = new LoginPage(driver);
			// lpg.emailsend(p.getProperty("email"));
			// lpg.pwdend(p.getProperty("pwd"));
			lpg.emailsend(email);
			lpg.pwdend(password);
			lpg.loginClick();
			if (exp.equalsIgnoreCase("Valid")) {
			MyAccountpage myacpage = new MyAccountpage(driver);
			boolean result = myacpage.ValidateScreenMsg();
			//Assert.assertTrue(result);
			
				if (result == true) {
					myacpage.ClickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			else if(exp.equalsIgnoreCase("Invalid")) {
				boolean errorMsg = lpg.isErrorMessageDisplayed();
			    Assert.assertTrue(errorMsg, "Expected error message for invalid login");
				
			}

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
	
	
}
