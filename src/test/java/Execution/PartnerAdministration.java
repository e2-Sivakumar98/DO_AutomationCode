package Execution;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;
import Locators.PartnerAdministrationPageLocators;
import Locators.UserManagementPageLocators;

public class PartnerAdministration extends Base_class{
	
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
	
	@Test(description="This test case verifies that landing page is the Partner Administration module",priority= 1)
	public void shouldPartnerAdministrationPageDisplayed() throws Exception {
		implicitWait(10);
		boolean partnerAdministrationTitleNameIsDisplayed = false;
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		PartnerAdministrationPageLocators htmlElementLocator2 = new PartnerAdministrationPageLocators();
		
		Thread.sleep(4000);
		normalClick(htmlElmentLocator1.getMenuButton());
		Thread.sleep(4000);
		//WebdriverWaitClickable(htmlElementLocator.getSytemAdministration());
		normalClick(htmlElementLocator.getSytemAdministration());
		Thread.sleep(10000);
		//WebdriverWaitClickable(htmlElementLocator2.getPartnerAdministration());
		normalClick(htmlElementLocator2.getPartnerAdministration());
		try {
			partnerAdministrationTitleNameIsDisplayed = htmlElementLocator2.getPartnerAdministrationTitle().isDisplayed();
		} catch(Exception e) {
			System.out.println("Partner Administration title name not displayed here");
		}
		assertTrue(partnerAdministrationTitleNameIsDisplayed);
	}
	
	@Test(description="This test case verifies that able to create a Partner Admin user profile",priority= 2)
	public void shouldPartnerRootAdminUserProfileCreated() throws Exception {
		
		implicitWait(10);
		String partnerBusinessName = getDataFromExcel("PartnerRootUser", 1, 0);
		String  address1= getDataFromExcel("PartnerRootUser", 1, 1);
		String address2= getDataFromExcel("PartnerRootUser", 1, 2);
		String city = getDataFromExcel("PartnerUserProfile", 1, 3);
		String state = getDataFromExcel("PartnerUserProfile", 1, 4);
		String country = getDataFromExcel("PartnerUserProfile", 1, 5);
		String postalCode = getDataFromExcel("PartnerUserProfile", 1, 6);
		String fname = getDataFromExcel("PartnerUserProfile", 1, 7);
		String lname = getDataFromExcel("PartnerUserProfile", 1, 8);
		String phone = getDataFromExcel("PartnerUserProfile", 1, 9);
		String email = getDataFromExcel("PartnerUserProfile", 1, 10);
		String password = getDataFromExcel("PartnerUserProfile", 1, 11);
		String confirmPassword = getDataFromExcel("PartnerUserProfile", 1, 12);
		
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		PartnerAdministrationPageLocators htmlElementLocator2 = new PartnerAdministrationPageLocators();
		
		Thread.sleep(3000);
		normalClick(htmlElementLocator.getAddUserButton());
		sendkeys(htmlElementLocator2.getPartnerBusinessName(),partnerBusinessName);
		sendkeys(htmlElementLocator2.getAddressLine1(),address1);
		sendkeys(htmlElementLocator2.getAddressLine2(),address2);
		sendkeys(htmlElementLocator2.getCity(),city);
		sendkeys(htmlElementLocator2.getState(),state);
		sendkeys(htmlElementLocator2.getCountry(),country);
		sendkeys(htmlElementLocator2.getPinCode(),postalCode);
		sendkeys(htmlElementLocator2.getfName(),fname);
		sendkeys(htmlElementLocator2.getlName(),lname);
		sendkeys(htmlElementLocator2.getContactNumber(),phone);
		sendkeys(htmlElementLocator2.getEmailAdress(),email);
		sendkeys(htmlElementLocator2.getPassword(),password);
		sendkeys(htmlElementLocator2.getConfirmPassword(),confirmPassword);
		normalClick(htmlElementLocator.getSubmitButton());
			
		
	}
}
