package Execution;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import Base.Base_class;
import Locators.LoginPageLocators;

public class ResetLinkSendForTheRegisteredMailId extends Base_class{

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}
	@Test(description = "This test case verifies the resetlink is send for the registered mailaddress")
	public void ResetLinkShouldbeSendForTheRegisteredMail() throws Exception {
		boolean	resetlinkSuccessMessageIsDisplayed = false;

		String userEmailAddress = getDataFromExcel("ResetLinkSendtoRegisteredMailId", 1, 0);
		
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		Thread.sleep(2000);
		normalClick(htmlElmentLocator.getForgotPasswordPageLink());

		Thread.sleep(2000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		normalClick(htmlElmentLocator.getSubmitButton());

		Thread.sleep(3000);
		try {
			resetlinkSuccessMessageIsDisplayed = htmlElmentLocator.getmailSentSuccessMessage().isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(resetlinkSuccessMessageIsDisplayed);
		
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
