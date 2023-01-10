package Execution;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;
import Locators.UserManagementPageLocators;

public class UserManagement extends Base_class{
	
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
	
	@Test(description="This test case verifies that landing page is the User management module",priority= 1)
	public void shouldUserManagementPageDisplayed() throws InterruptedException {
		implicitWait(5);
		boolean userManagementTitleNameIsDisplayed = false;
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		
		Thread.sleep(4000);
		normalClick(htmlElmentLocator1.getMenuButton());
		
		normalClick(htmlElementLocator.getSytemAdministration());
		normalClick(htmlElementLocator.getUserAdministration());
		normalClick(htmlElementLocator.getUserManagement());
		try {
			userManagementTitleNameIsDisplayed = htmlElementLocator.getUserManagementTitleName().isDisplayed();
		} catch(Exception e) {
			System.out.println("User Management title not displayed here");
		}
		assertTrue(userManagementTitleNameIsDisplayed);
	}
	

	//@Test(description="This test case verifies that able to create a DO Admin user profile",priority= 2)
	public void shouldDoAdminUserProfileCreated() throws Exception {
		
		implicitWait(10);
//		String userTitle = getDataFromExcel("DoUserProfile", 1, 0);
		String userFname = getDataFromExcel("DoUserProfile", 1, 1);
		String userLname = getDataFromExcel("DoUserProfile", 1, 2);
		String contactNumber = getDataFromExcel("DoUserProfile", 1, 3);
		String emailAdress = getDataFromExcel("DoUserProfile", 1, 4);
		String password = getDataFromExcel("DoUserProfile", 1, 5);
		String confirmPassword = getDataFromExcel("DoUserProfile", 1, 6);
		
		boolean SuccessResponseMessageIsDisplayed = false;
		
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserButton());
//		WebdriverWaitClickable(htmlElementLocator.getUserTitle());
//		sendkeys(htmlElementLocator.getUserTitle(),userTitle);
		sendkeys(htmlElementLocator.getFirstName(),userFname);
		sendkeys(htmlElementLocator.getLastName(),userLname);
		sendkeys(htmlElementLocator.getContactNumber(),contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(),emailAdress);
		sendkeys(htmlElementLocator.getPassword(),password);
		
		sendkeys(htmlElementLocator.getConfirmPassword(),confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilege());
		normalClick(htmlElementLocator.getSubmitButton());
//		try {
//			SuccessResponseMessageIsDisplayed = htmlElementLocator.get
//		}
		
	}
	@Test(description="This test case verifies that able to create a Partner Admin user profile",priority= 3)
	public void shouldPartnerAdminUserProfileCreated() throws Exception {
		
		implicitWait(10);
//		String userTitle = getDataFromExcel("DoUserProfile", 1, 0);
		String userFname = getDataFromExcel("PartnerUserProfile", 1, 1);
		String userLname = getDataFromExcel("PartnerUserProfile", 1, 2);
		String contactNumber = getDataFromExcel("PartnerUserProfile", 1, 3);
		String emailAdress = getDataFromExcel("PartnerUserProfile", 1, 4);
		String password = getDataFromExcel("PartnerUserProfile", 1, 5);
		String confirmPassword = getDataFromExcel("PartnerUserProfile", 1, 6);
		
		boolean SuccessResponseMessageIsDisplayed = false;
		
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserButton());
//		WebdriverWaitClickable(htmlElementLocator.getUserTitle());
//		sendkeys(htmlElementLocator.getUserTitle(),userTitle);
		sendkeys(htmlElementLocator.getFirstName(),userFname);
		sendkeys(htmlElementLocator.getLastName(),userLname);
		sendkeys(htmlElementLocator.getContactNumber(),contactNumber);
		sendkeys(htmlElementLocator.getEmailAddress(),emailAdress);
		sendkeys(htmlElementLocator.getPassword(),password);
		
		sendkeys(htmlElementLocator.getConfirmPassword(),confirmPassword);
		normalClick(htmlElementLocator.getUserRole());
		normalClick(htmlElementLocator.getUserRolePrivilege());
		normalClick(htmlElementLocator.getRadioButton());
		normalClick(htmlElementLocator.getPartnerNameDropdown());
		normalClick(htmlElementLocator.getSelectPartnerName());
		normalClick(htmlElementLocator.getSubmitButton());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
