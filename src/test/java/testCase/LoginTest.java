package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;


public class LoginTest extends BaseClass {
	@Test(groups= {"Master"})

	public void accountLogintest()
	{
		logger.info("Starting the Test");
		try {
		HomePage hmp=new HomePage(driver);
		hmp.clickOnAccount();
		hmp.clickOnLogin();
		
		LoginPage lpg=new LoginPage(driver);
	    lpg.emailsend(p.getProperty("email"));
	    lpg.pwdend(p.getProperty("pwd"));
		
		lpg.loginClick();
		
		MyAccountpage myacpage=new MyAccountpage(driver);
		boolean result=myacpage.ValidateScreenMsg();
		Assert.assertEquals(result,true);
	
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
	
}
