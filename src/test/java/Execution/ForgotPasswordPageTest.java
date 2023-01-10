package Execution;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.LoginPageLocators;

public class ForgotPasswordPageTest extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}

	@Test(description = "This test verifies that, forgot password page is displayed")
	public void shouldForgotPasswordPageDisplayed() {

		boolean forgotPasswordTitleNameIsDisplayed = false;

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		normalClick(htmlElmentLocator.getForgotPasswordPageLink());

		try {
			forgotPasswordTitleNameIsDisplayed = htmlElmentLocator.getforgotPasswordTitleName().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(forgotPasswordTitleNameIsDisplayed);

		refresh();
	}

	@Test(description ="This test verifies that login page will be displayed once the reset link is sended")
	
	public void shouldNavigateToLoginPageAfterResetLinkSend() throws InterruptedException, IOException {
		
		boolean loginPageTitleNameIsDisplayed = false;
		boolean	resetlinkSuccessMessageIsDisplayed = false;
		
		String userEmailAddress = getDataFromExcel("ResetLinkSendtoRegisteredMailId", 1, 0);
	
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		normalClick(htmlElmentLocator.getForgotPasswordPageLink());
		
		Thread.sleep(3000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		normalClick(htmlElmentLocator.getSubmitButton());
	
		Thread.sleep(3000);
		try {
			resetlinkSuccessMessageIsDisplayed = htmlElmentLocator.getmailSentSuccessMessage().isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(resetlinkSuccessMessageIsDisplayed);
		
		try {
			
			loginPageTitleNameIsDisplayed = htmlElmentLocator.getLoginTitleName().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(loginPageTitleNameIsDisplayed);
		
		Thread.sleep(2000);
		refresh();
	}

	@Test(description = "This test verifies that, Error message should be displayed without submitting any data.")

	public void shouldErrorThrownWhenUserSubmitWithEmptyData() throws InterruptedException, IOException {

		boolean enterEmailAddressErrorMessageIsDisplayed = false;
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		Thread.sleep(1000);
		
		normalClick(htmlElmentLocator.getForgotPasswordPageLink());
		
		Thread.sleep(2000);
		normalClick(htmlElmentLocator.getSubmitButton());

		Thread.sleep(2000);
		try {
			enterEmailAddressErrorMessageIsDisplayed = htmlElmentLocator.getValidEmailAddressErrorMessage()
					.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(enterEmailAddressErrorMessageIsDisplayed);

		refresh();
	}

	@Test(description = "This test verifies that, if the user uses an unregistered email id to create the reset link then an error message is displayed.")
	public void shouldErrorThrownWhenUserProvidedNewEmailId() throws InterruptedException, IOException {
		implicitWait(5);

		boolean invalidEmailErrormessageIsDisplayed = false;
		String userEmailAddress = getDataFromExcel("LinkShouldNotSendToNotRegMailId", 1, 0);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		normalClick(htmlElmentLocator.getForgotPasswordPageLink());

		Thread.sleep(3000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);

		normalClick(htmlElmentLocator.getSubmitButton());

		Thread.sleep(2000);
		try {
			invalidEmailErrormessageIsDisplayed = htmlElmentLocator.getuserDoesnotExistErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(invalidEmailErrormessageIsDisplayed);

		refresh();
	}

	@Test(description = "This test verifies that, if the user uses an invalid email address.")
	public void shouldErrorThrownWhenUserProvidedInvlaidEmailId() throws InterruptedException, IOException {

		boolean invalidEmailIdErrorMessageIsDisplayed = false;

		String userEmailAddress = getDataFromExcel("LinkShouldNotSendToInvalidMail", 1, 0);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		Thread.sleep(2000);
		normalClick(htmlElmentLocator.getForgotPasswordPageLink());

		Thread.sleep(2000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);

		normalClick(htmlElmentLocator.getSubmitButton());
		Thread.sleep(2000);

		try {
			invalidEmailIdErrorMessageIsDisplayed = htmlElmentLocator.getValidEmailAddressErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(invalidEmailIdErrorMessageIsDisplayed);
		refresh();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
//