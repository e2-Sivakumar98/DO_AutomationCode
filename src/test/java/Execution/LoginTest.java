package Execution;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.*;

public class LoginTest extends Base_class {
	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}
	
	//@Test(description = "This test case checks whether the First letter should not be a space error message is displayed")
	public void shouldErrorThownWhenUserProvideSpaceBeforeMentioningEmailID() throws InterruptedException, IOException {
		
		boolean firstLetterCannotBesSpaceErrorMessage = false;
		String userEmailAddress = getDataFromExcel("FirstLetterShouldNotBeSpace", 1, 0);
		String userPassword = getDataFromExcel("FirstLetterShouldNotBeSpace", 1, 1);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		Thread.sleep(2000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
		normalClick(htmlElmentLocator.getLoginButton());
		Thread.sleep(2000);

		try {
			firstLetterCannotBesSpaceErrorMessage = htmlElmentLocator.getValidEmailAddressErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(firstLetterCannotBesSpaceErrorMessage);
		
	}

	@Test(description = "This test case checks whether the mail address entered by the user is invalid or not!!!")
	public void shouldErrorThrownWhenUserProvideInvalidEmailId() throws Exception {

		boolean enterValidEmailAddressErrormessage = false;

		String userEmailAddress = getDataFromExcel("LoginWithInvalidEmailId", 1, 0);
		String userPassword = getDataFromExcel("LoginWithInvalidEmailId", 1, 1);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		Thread.sleep(3000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
		normalClick(htmlElmentLocator.getLoginButton());
		Thread.sleep(2000);

		try {
			enterValidEmailAddressErrormessage = htmlElmentLocator.getValidEmailAddressErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(enterValidEmailAddressErrormessage);
		refresh();
		Thread.sleep(2000);
	}

	@Test(description ="This test case checks whether the entered user's password is correct or incorrect!!!")
	public void shouldErrorThrownWhenUserProvideInvalidPassword() throws IOException, InterruptedException {
		
		boolean invalidPasswordErrorMessage = false;
		
		String userEmailAddress = getDataFromExcel("LoginWithInvalidPassword", 1, 0);
		String userPassword = getDataFromExcel("LoginWithInvalidPassword", 1, 1);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
	
			Thread.sleep(3000);
			sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
			sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
			normalClick(htmlElmentLocator.getLoginButton());
			Thread.sleep(3000);
			normalClick(htmlElmentLocator.getShowPasswordEyeIcon());
			Thread.sleep(3000);
			
			try {
				invalidPasswordErrorMessage = htmlElmentLocator.getInvalidPasswordsErrorMessage().isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}

			assertTrue(invalidPasswordErrorMessage);
			refresh();
			Thread.sleep(2000);
	}
	
	//@Test(description ="This test case checks whether the entered user's password is less than a six character!!!")
	public void shouldErrorThrownWhenUserProvidePasswordHasLessThanSixcharacter() throws IOException, InterruptedException {
		
		boolean minimumSixCharactersRequired = false;
		
		String userEmailAddress = getDataFromExcel("LoginWithLessThan6Character", 1, 0);
		String userPassword = getDataFromExcel("LoginWithLessThan6Character", 1, 1);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
	
			Thread.sleep(3000);
			sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
			sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
			normalClick(htmlElmentLocator.getLoginButton());
			Thread.sleep(3000);
			normalClick(htmlElmentLocator.getShowPasswordEyeIcon());
			Thread.sleep(3000);
			
			try {
				minimumSixCharactersRequired = htmlElmentLocator.getMiniumSixCharactersRequiredErrorMessage().isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}

			assertTrue(minimumSixCharactersRequired);
			refresh();
			Thread.sleep(2000);
	}
	
	
	//@Test(description ="This test case checks whether the user's email Id is existing or not in the application if user login with the new credentials")
	public void shouldErrorThrownWhenUserProvideNewEmailId() throws IOException, InterruptedException {
		
		boolean userDoesnotExistErrorMessage = false;
		
		String userEmailAddress = getDataFromExcel("UserDoesnotExist", 1, 0);
		String userPassword = getDataFromExcel("UserDoesnotExist", 1, 1);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
	
			Thread.sleep(3000);
			sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
			sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
			normalClick(htmlElmentLocator.getLoginButton());
			Thread.sleep(2000);
			
			try {
				userDoesnotExistErrorMessage = htmlElmentLocator.getuserDoesnotExistErrorMessage().isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}

			assertTrue(userDoesnotExistErrorMessage);
			refresh();
			Thread.sleep(2000);
	}
	
	//@Test(description ="This test case checks whether the error message is displayed if the user directly click on the submit button without providing any credentials")
	public void shouldErrorThrownWhenUserClickSubmitButtonWithoutAnyCredentials() throws IOException, InterruptedException {

		boolean enterEmailAddressErrorMessage = false;
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		Thread.sleep(3000);
		normalClick(htmlElmentLocator.getLoginButton());
		
		try {
			enterEmailAddressErrorMessage = htmlElmentLocator.getValidEmailAddressErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(enterEmailAddressErrorMessage);
		refresh();
		Thread.sleep(2000);
}
	
	//@Test(description ="This test case checks whether the error message is displayed if the user directly click on the submit button without providing any credentials")
	public void shouldErrorThrownWhenUserClickOnSubmitButtonWithoutThePassword() throws IOException, InterruptedException {

		boolean enterPasswordErrorMessage = false;
		
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials", 1, 0);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		Thread.sleep(3000);
		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		normalClick(htmlElmentLocator.getLoginButton());
		
		try {
			enterPasswordErrorMessage = htmlElmentLocator.getMiniumSixCharactersRequiredErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(enterPasswordErrorMessage);
		refresh();
		Thread.sleep(2000);
}
	
	//@Test(description ="This test case checks whether the error message is displayed if the user directly click on the submit button without providing any credentials")
	public void shouldErrorThrownWhenUserClickOnSubmitButtonWithoutEmailId() throws IOException, InterruptedException {

		boolean enterEmailAddressErrorMessage = false;
		
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials", 1, 1);
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		Thread.sleep(3000);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
		normalClick(htmlElmentLocator.getLoginButton());
		
		try {
			enterEmailAddressErrorMessage = htmlElmentLocator.getValidEmailAddressErrorMessage().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(enterEmailAddressErrorMessage);
		refresh();
		Thread.sleep(2000);
}
		
	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
