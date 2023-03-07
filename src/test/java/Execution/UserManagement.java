package Execution;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;
import Locators.UserManagementPageLocators;

public class UserManagement extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
		driver.manage().window().maximize();
	}

	@BeforeSuite
	public void dashboardLaunch() throws InterruptedException, IOException {

		implicitWait(5);
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials", 1, 0);
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials", 1, 1);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);

		normalClick(htmlElmentLocator.getLoginButton());

	}

	@Test(description = "This test case verifies that landing page is the User management module", priority = 1)
	public void shouldUserManagementPageDisplayed() throws InterruptedException {

		boolean userManagementTitleNameIsDisplayed = false;
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		// implicitWait(5);
		Thread.sleep(7000);
		normalClick(htmlElmentLocator1.getMenuButton());

		normalClick(htmlElementLocator.getSytemAdministration());
		normalClick(htmlElementLocator.getUserAdministration());
		normalClick(htmlElementLocator.getUserManagement());
		try {
			userManagementTitleNameIsDisplayed = htmlElementLocator.getUserManagementTitleName().isDisplayed();
		} catch (Exception e) {
			System.out.println("User Management title not displayed here");
		}
		assertTrue(userManagementTitleNameIsDisplayed);
	}

	@Test(description = "This test case verifies that error message is displayed without providing any details in mandatory fields", priority = 2)
	public void shouldErrorThrownDirectlyClickingSubmitButton() throws InterruptedException {
		boolean thisFieldRequriedErrormessage = false;
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		Thread.sleep(2000);
		normalClick(htmlElementLocator.getAddUserButton());
		normalClick(htmlElementLocator.getSubmitButton());
		normalClick(htmlElementLocator.getAddUserDialogPageCancelButton());

		try {
			thisFieldRequriedErrormessage = htmlElementLocator.getFieldRequriedErrormessage().isDisplayed();
		} catch (Exception e) {
			System.out.println("Error at priority 2");
		}
		assertTrue(thisFieldRequriedErrormessage);

	}

	@Test(description = "This test case verifies that error message is displayed Providing with Invalid Email address", priority = 3)
	public void shouldErrorThrownProvidingInvalidEmail() throws InterruptedException {
		boolean validEmailAdrressErrorMessage = false;
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		Thread.sleep(2000);
		normalClick(htmlElementLocator.getAddUserButton());
		sendkeys(htmlElementLocator.getEmailAddress(), "qapartner");
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			validEmailAdrressErrorMessage = htmlElementLocator.getValidEmailErrorMessage().isDisplayed();
		} catch (Exception e) {
			System.out.println("Error at priority 3");
		}
		assertTrue(validEmailAdrressErrorMessage);

	}

	@Test(description = "This test case verifies that error message is displayed without providing Minimum Inputs In Password Field", priority = 4)
	public void shouldErrorThrownProvidingMinimumInputsInPasswordField() throws InterruptedException, IOException {
		boolean minimum6CharacterRequriedMessage = false;
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		sendkeys(htmlElementLocator.getPassword(), "qa12");
		normalClick(htmlElementLocator.getSubmitButton());
		Thread.sleep(3000);

		try {
			minimum6CharacterRequriedMessage = htmlElementLocator.getMinimum6CharaterErrorMessage().isDisplayed();
		} catch (Exception e) {
			System.out.println("Error at priority 4");
		}
		assertTrue(minimum6CharacterRequriedMessage);
	}

	@Test(description = "This test case verifies that error message is displayed without providing Invalid Inputs In Confirm Password", priority = 5)
	public void shouldErrorThrownProvidingInvalidInputsInConfirmPassword()
			throws InterruptedException, IOException, AWTException {
		boolean passwordDoesNotMatch = false;
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		normalClick(htmlElementLocator.getPassword());
		robotDelete();
		sendkeys(htmlElementLocator.getPassword(), "qa@1234");
		sendkeys(htmlElementLocator.getConfirmPassword(), "qa@123");
		normalClick(htmlElementLocator.getSubmitButton());
		normalClick(htmlElementLocator.getConfirmPasswordMaskIcon());
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserDialogPageCancelButton());

		try {
			passwordDoesNotMatch = htmlElementLocator.getPassworDoesnotMatchErrorMessage().isDisplayed();
		} catch (Exception e) {
			System.out.println("Error at priority 5");
		}
		assertTrue(passwordDoesNotMatch);
	}

	@Test(description = "This test case verifies that able to create a DO Admin user profile", priority = 6)
	public void shouldDoAdminUserProfileCreated() throws Exception {

		implicitWait(10);
		//// String userTitle = getDataFromExcel("DoUserProfile", 1, 0);
		String userFname = getDataFromExcel("DoUserProfile", 1, 1);
		String userLname = getDataFromExcel("DoUserProfile", 1, 2);
		String contactNumber = getDataFromExcel("DoUserProfile", 1, 3);
		String emailAdress = getDataFromExcel("DoUserProfile", 1, 4);
		String password = getDataFromExcel("DoUserProfile", 1, 5);
		String confirmPassword = getDataFromExcel("DoUserProfile", 1, 6);

		boolean userCreatedSuccessMessageIsDisplayed = false;
		boolean emailAlreayExistsMessageIsDisplayed = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(2000);
		normalClick(htmlElementLocator.getAddUserButton());
		// WebdriverWaitClickable(htmlElementLocator.getUserTitle());
		// sendkeys(htmlElementLocator.getUserTitle(),userTitle);
		sendkeys(htmlElementLocator.getFirstName(), userFname);
		sendkeys(htmlElementLocator.getLastName(), userLname);
		sendkeys(htmlElementLocator.getContactNumber(), contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(), emailAdress);
		sendkeys(htmlElementLocator.getPassword(), password);

		sendkeys(htmlElementLocator.getConfirmPassword(), confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilegeAdmin());
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			emailAlreayExistsMessageIsDisplayed = htmlElementLocator.getEmailIdAlreadyExists().isDisplayed();
		} catch (Exception e) {
			System.out.println("Email address already exists");
		}
		if (emailAlreayExistsMessageIsDisplayed) {
			normalClick(htmlElementLocator.getEmailAddress());
			robotDelete();
			sendkeys(htmlElementLocator.getEmailAddress(), "qa+user10@gmail.com");
			normalClick(htmlElementLocator.getSubmitButton());
		} else {
			try {
				userCreatedSuccessMessageIsDisplayed = htmlElementLocator.getUserCreatedSuccessMessage().isDisplayed();
			} catch (Exception e) {
				System.out.println("Admin user not created");
			}
			assertTrue(userCreatedSuccessMessageIsDisplayed);
		}
	}

	@Test(description = "This test case verifies that able to create a DO staff user profile", priority = 7)
	public void shouldDoStaffUserProfileCreated() throws Exception {

		implicitWait(10);
		String userFname = getDataFromExcel("DoUserProfile", 2, 1);
		String userLname = getDataFromExcel("DoUserProfile", 2, 2);
		String contactNumber = getDataFromExcel("DoUserProfile", 2, 3);
		String emailAdress = getDataFromExcel("DoUserProfile", 2, 4);
		String password = getDataFromExcel("DoUserProfile", 2, 5);
		String confirmPassword = getDataFromExcel("DoUserProfile", 2, 6);

		boolean userCreatedSuccessMessageIsDisplayed = false;
		boolean emailAlreayExistsMessageIsDisplayed = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserButton());
		sendkeys(htmlElementLocator.getFirstName(), userFname);
		sendkeys(htmlElementLocator.getLastName(), userLname);
		sendkeys(htmlElementLocator.getContactNumber(), contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(), emailAdress);
		sendkeys(htmlElementLocator.getPassword(), password);

		sendkeys(htmlElementLocator.getConfirmPassword(), confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilegeStaff());
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			emailAlreayExistsMessageIsDisplayed = htmlElementLocator.getEmailIdAlreadyExists().isDisplayed();
		} catch (Exception e) {
			System.out.println("Email address already exists");
		}
		if (emailAlreayExistsMessageIsDisplayed) {
			normalClick(htmlElementLocator.getEmailAddress());
			robotDelete();
			sendkeys(htmlElementLocator.getEmailAddress(), "qa+user11@gmail.com");
			normalClick(htmlElementLocator.getSubmitButton());
		} else {
			try {
				userCreatedSuccessMessageIsDisplayed = htmlElementLocator.getUserCreatedSuccessMessage().isDisplayed();
			} catch (Exception e) {
				System.out.println("DO staff user not created");
			}
			assertTrue(userCreatedSuccessMessageIsDisplayed);
		}
	}

	@Test(description = "This test case verifies that able to create a Partner Admin user profile", priority = 8)
	public void shouldPartnerAdminUserProfileCreated() throws Exception {

		implicitWait(10);
		// String userTitle = getDataFromExcel("DoUserProfile", 1, 0);
		String userFname = getDataFromExcel("PartnerUserProfile", 1, 1);
		String userLname = getDataFromExcel("PartnerUserProfile", 1, 2);
		String contactNumber = getDataFromExcel("PartnerUserProfile", 1, 3);
		String emailAdress = getDataFromExcel("PartnerUserProfile", 1, 4);
		String password = getDataFromExcel("PartnerUserProfile", 1, 5);
		String confirmPassword = getDataFromExcel("PartnerUserProfile", 1, 6);

		boolean userCreatedSuccessMessageIsDisplayed = false;
		boolean emailAlreayExistsMessageIsDisplayed = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(5000);
		normalClick(htmlElementLocator.getAddUserButton());
		// WebdriverWaitClickable(htmlElementLocator.getUserTitle());
		// sendkeys(htmlElementLocator.getUserTitle(),userTitle);
		sendkeys(htmlElementLocator.getFirstName(), userFname);
		sendkeys(htmlElementLocator.getLastName(), userLname);
		sendkeys(htmlElementLocator.getContactNumber(), contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(), emailAdress);
		sendkeys(htmlElementLocator.getPassword(), password);

		sendkeys(htmlElementLocator.getConfirmPassword(), confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilegeAdmin());
		normalClick(htmlElementLocator.getRadioButton());
		normalClick(htmlElementLocator.getPartnerNameDropdown());
		normalClick(htmlElementLocator.getSelectPartnerName());
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			emailAlreayExistsMessageIsDisplayed = htmlElementLocator.getEmailIdAlreadyExists().isDisplayed();
		} catch (Exception e) {
			System.out.println("Email address already exists");
		}
		if (emailAlreayExistsMessageIsDisplayed) {
			normalClick(htmlElementLocator.getEmailAddress());
			robotDelete();
			sendkeys(htmlElementLocator.getEmailAddress(), "qa+user12@gmail.com");
			normalClick(htmlElementLocator.getSubmitButton());
		} else {
			try {
				userCreatedSuccessMessageIsDisplayed = htmlElementLocator.getUserCreatedSuccessMessage().isDisplayed();
			} catch (Exception e) {
				System.out.println("Partner Admin user not created");
			}
			assertTrue(userCreatedSuccessMessageIsDisplayed);
		}

	}

	@Test(description = "This test case verifies that able to create a Partner staff user profile", priority = 9)
	public void shouldPartnerStaffUserProfileCreated() throws Exception {

		implicitWait(10);
		// String userTitle = getDataFromExcel("DoUserProfile", 1, 0);
		String userFname = getDataFromExcel("PartnerUserProfile", 2, 1);
		String userLname = getDataFromExcel("PartnerUserProfile", 2, 2);
		String contactNumber = getDataFromExcel("PartnerUserProfile", 2, 3);
		String emailAdress = getDataFromExcel("PartnerUserProfile", 2, 4);
		String password = getDataFromExcel("PartnerUserProfile", 2, 5);
		String confirmPassword = getDataFromExcel("PartnerUserProfile", 2, 6);

		boolean userCreatedSuccessMessageIsDisplayed = false;
		boolean emailAlreayExistsMessageIsDisplayed = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserButton());
		// WebdriverWaitClickable(htmlElementLocator.getUserTitle());
		// sendkeys(htmlElementLocator.getUserTitle(),userTitle);
		sendkeys(htmlElementLocator.getFirstName(), userFname);
		sendkeys(htmlElementLocator.getLastName(), userLname);
		sendkeys(htmlElementLocator.getContactNumber(), contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(), emailAdress);
		sendkeys(htmlElementLocator.getPassword(), password);

		sendkeys(htmlElementLocator.getConfirmPassword(), confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilegeStaff());
		normalClick(htmlElementLocator.getRadioButton());
		normalClick(htmlElementLocator.getPartnerNameDropdown());
		normalClick(htmlElementLocator.getSelectPartnerName());
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			emailAlreayExistsMessageIsDisplayed = htmlElementLocator.getEmailIdAlreadyExists().isDisplayed();
		} catch (Exception e) {
			System.out.println("Email address already exists");
		}
		if (emailAlreayExistsMessageIsDisplayed) {
			normalClick(htmlElementLocator.getEmailAddress());
			robotDelete();
			sendkeys(htmlElementLocator.getEmailAddress(), "qa+user13@gmail.com");
			normalClick(htmlElementLocator.getSubmitButton());
		} else {
			try {
				userCreatedSuccessMessageIsDisplayed = htmlElementLocator.getUserCreatedSuccessMessage().isDisplayed();
			} catch (Exception e) {
				System.out.println("Partner staff user not created");
			}
			assertTrue(userCreatedSuccessMessageIsDisplayed);
		}
	}

	 @AfterTest
	 public void tearDown() {
	 driver.quit();
	 }

}
