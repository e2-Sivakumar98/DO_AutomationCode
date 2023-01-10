package Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Base_class;
import Locators.LocatorsofDashboardListViewPage;

public class Exectuion extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {

		RequestedBrowserWillBelaunch("chrome");

		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");

	}

	@Test(description="Here the user will login with their proper credentials and should be succesfully logged in.")
	public void UserShouldloginSuccessfullyWithTheProperCredentials() throws Exception {
		
		SuccessfullLogin login = new SuccessfullLogin();

		login.UserShouldloginSuccessfully();
		//login.forgotpasswordlink();
	}
//	@Test
//	public void tc02Dashboard() throws Exception {
//		Dashboard list =new Dashboard();
//		list.siteusage();

//	}

}
