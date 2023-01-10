package Execution;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;

public class DashboardPage extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}

	@Test(description = "Here the user will get a dashboard map after successfully logged in.")
	public void shoulddefaultMapIsDisplayedAfterLoggedIn() throws Exception {

		boolean dashboardMapIsDisplayed = false;

		Thread.sleep(3000);
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials", 1, 0);
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials", 1, 1);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);

		normalClick(htmlElmentLocator.getLoginButton());

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		Thread.sleep(10000);
		try {
			dashboardMapIsDisplayed = htmlElmentLocator1.getDashboardText().isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(dashboardMapIsDisplayed);
	}

}
