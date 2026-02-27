package utilities;

import org.testng.ITestListener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;



public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test
							// methods
	String reportname;
	public void onStart(ITestContext context) {

		// sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
		// "/reports/myReport.html");// specify
		// location
		// of the
		// report
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportname="Test-Report-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportname);
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "openCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("SubModule", "Customer");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Priyanka");
		
		//extent.setSystemInfo("os", "Windows10");
		//extent.setSystemInfo("Browser name", "Chrome");
		String ops=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("os", ops);
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser name", browser);
		
		List<String> includeGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
		

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName()); // create a new enty in the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()+"got successfully executed"); // update status p/f/s

	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName()); // create a new enty in the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.INFO, "Test Case FAILED cause is: " + result.getThrowable().getMessage());
		
		try {
			String imagePath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName()); // create a new enty in the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.INFO, "Test Case SKIPPED cause is: " + result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {

		extent.flush();
		String reportfilepath=System.getProperty("user.dir")+"\\reports\\"+reportname;
		File extentReport=new File(reportfilepath);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * try { URL url = new
		 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+reportname);
		 * 
		 * // Create the email message ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); email.setSmtpPort(465);
		 * email.setAuthenticator(new
		 * DefaultAuthenticator("mpriyanka.18a@gmail.com","engage24x7"));
		 * email.setSSLOnConnect(true); email.setFrom("mpriyanka.18a@gmail.com");
		 * //Sender email.setSubject("Test Results");
		 * email.setMsg("Please find Attached Report....");
		 * email.addTo("asap.15priyanka@gmail.com"); //Receiver email.attach(url,
		 * "extent report", "please check report..."); email.send(); // send the email }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		
		
	}
}
