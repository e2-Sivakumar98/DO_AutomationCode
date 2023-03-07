package Execution;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;
import Locators.UserManagementPageLocators;
import Locators.siteManagementPagelocators;

public class SiteManagement extends Base_class{

	@BeforeSuite
	private void browserlaunch() throws Exception {

		RequestedBrowserWillBelaunch("chrome");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
		driver.manage().window().maximize();

		implicitWait(5);
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials", 1, 0);
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials", 1, 1);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();

		sendkeys(htmlElmentLocator.getEmailTextBox(), userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);

		normalClick(htmlElmentLocator.getLoginButton());

	}


	@Test(description = "This test case verifies that landing page is Site management module", priority = 1)
	public void shouldSiteManagementPageDisplayed() throws InterruptedException {
		implicitWait(10);
		boolean siteManagementTitleNameIsDisplayed = false;
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();

		Thread.sleep(7000);
		normalClick(htmlElmentLocator1.getMenuButton());
		Thread.sleep(5000);
		normalClick(htmlElementLocator.getSytemAdministration());
		normalClick(htmlElementLocator2.getSiteAdministration());
		normalClick(htmlElementLocator2.getSiteManagement());
		Thread.sleep(2000);
		try {
			siteManagementTitleNameIsDisplayed = htmlElementLocator2.getSiteManagementTitleName().isDisplayed();
		} catch (Exception e) {
			System.out.println("Site Management title not displayed here");
		}
		assertTrue(siteManagementTitleNameIsDisplayed);
		if(siteManagementTitleNameIsDisplayed) {
			Thread.sleep(3000);
			normalClick(htmlElementLocator2.getAddButton());
		}
		else {
			System.out.println("Site Management page not available here");
		}
	}


	@Test(description = "This test case verifies that error message is displayed without providing any details in mandatory fields", priority = 2)
	public void shouldErrorThrownDirectlyClickingAddSiteButton() throws InterruptedException {
		boolean thisFieldRequriedErrormessage = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		normalClick(htmlElementLocator.getSubmitButton());

		try {
			thisFieldRequriedErrormessage = htmlElementLocator.getFieldRequriedErrormessage().isDisplayed();
		} catch (Exception e) {
			System.out.println("No such error is displayed here");
		}
		assertTrue(thisFieldRequriedErrormessage);

	}

	@Test(description = "This test case verifies that, creating site without assigning the LPL serial number", priority = 3)
	public void shouldSiteCreateWithoutLPLNo() throws Exception {


		String siteName = getDataFromExcel("siteDetails", 1, 0);
		String contactName = getDataFromExcel("siteDetails", 1, 1);
		String phoneNumber = getDataFromExcel("siteDetails", 1, 2);
		String addressL1 = getDataFromExcel("siteDetails", 1, 3);
		String addressL2 = getDataFromExcel("siteDetails", 1, 4);
		String village = getDataFromExcel("siteDetails", 1, 5);
		String District = getDataFromExcel("siteDetails", 1, 6);
		String state = getDataFromExcel("siteDetails", 1, 7);
		String country = getDataFromExcel("siteDetails", 1, 8);
		String pinumber = getDataFromExcel("siteDetails", 1, 9);


		boolean siteCreatedSuccessMessageIsDisplayed = false;
		boolean createdSiteIsDisplayed = false;

		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();

		sendkeys(htmlElementLocator2.getSiteName(), siteName);
		sendkeys(htmlElementLocator2.getContactName(), contactName);
		sendkeys(htmlElementLocator2.getContactPhoneNumber(), phoneNumber);
		sendkeys(htmlElementLocator2.getSiteAddress1(), addressL1);
		sendkeys(htmlElementLocator2.getSiteAddress2(), addressL2);
		sendkeys(htmlElementLocator2.getSiteCity(), village);
		sendkeys(htmlElementLocator2.getSiteDistrict(), District);
		sendkeys(htmlElementLocator2.getSiteState(), state);
		sendkeys(htmlElementLocator2.getSiteCountry(), country);
		sendkeys(htmlElementLocator2.getSiteZipcode(), pinumber);

		normalClick(htmlElementLocator2.getPartnerNameDropdown());
		normalClick(htmlElementLocator.getSelectPartnerName());
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			siteCreatedSuccessMessageIsDisplayed = htmlElementLocator2.getSiteCreatedSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Not able to create the site");
		}
		Thread.sleep(3000);
		assertTrue(siteCreatedSuccessMessageIsDisplayed);

		if(siteCreatedSuccessMessageIsDisplayed) {
//WebdriverWaitVisible(htmlElementLocator2.getLoadingRing());
			Thread.sleep(2000);
			sendkeys(htmlElementLocator2.getSearchbox(), siteName);
			createdSiteIsDisplayed = htmlElementLocator2.getCreatedSite().isDisplayed();
			normalClick(htmlElementLocator2.getSearchCancelButton());
			assertTrue(createdSiteIsDisplayed);

		}else {
			System.out.println("Searching the created site is not listed here");
		}

	}

	@Test(description = "This test case verifies that, creating site with assigning the LPL serial number", priority = 4)
	public void shouldCreateSiteWithLPLNo() throws IOException, AWTException {

		boolean siteCreatedSuccessMessageIsDisplayed = false;
		boolean createdSiteIsDisplayed = false;

		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();

		normalClick(htmlElementLocator2.getAddButton());
		String siteName = getDataFromExcel("siteDetails", 1, 0);
		String contactName = getDataFromExcel("siteDetails", 1, 1);
		String phoneNumber = getDataFromExcel("siteDetails", 1, 2);
		String addressL1 = getDataFromExcel("siteDetails", 1, 3);
		String addressL2 = getDataFromExcel("siteDetails", 1, 4);
		String village = getDataFromExcel("siteDetails", 1, 5);
		String District = getDataFromExcel("siteDetails", 1, 6);
		String state = getDataFromExcel("siteDetails", 1, 7);
		String country = getDataFromExcel("siteDetails", 1, 8);
		String pinumber = getDataFromExcel("siteDetails", 1, 9);
		String serialNumber = getDataFromExcel("siteDetails", 1, 10);
		String date = getDataFromExcel("siteDetails", 1, 11);

		sendkeys(htmlElementLocator2.getSiteName(), siteName);
		sendkeys(htmlElementLocator2.getContactName(), contactName);
		sendkeys(htmlElementLocator2.getContactPhoneNumber(), phoneNumber);
		sendkeys(htmlElementLocator2.getSiteAddress1(), addressL1);
		sendkeys(htmlElementLocator2.getSiteAddress2(), addressL2);
		sendkeys(htmlElementLocator2.getSiteCity(), village);
		sendkeys(htmlElementLocator2.getSiteDistrict(), District);
		sendkeys(htmlElementLocator2.getSiteState(), state);
		sendkeys(htmlElementLocator2.getSiteCountry(), country);
		sendkeys(htmlElementLocator2.getSiteZipcode(), pinumber);
		normalClick(htmlElementLocator2.getPartnerNameDropdown());
		normalClick(htmlElementLocator.getSelectPartnerName());
		sendkeys(htmlElementLocator2.getSerial_number(), serialNumber);
		robotTabEnter();
		sendkeys(htmlElementLocator2.getLifePumpLinkInstallDate(), date);
		normalClick(htmlElementLocator.getSubmitButton());

		try {
			siteCreatedSuccessMessageIsDisplayed = htmlElementLocator2.getSiteCreatedSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Not able to create the site");
		}
		assertTrue(siteCreatedSuccessMessageIsDisplayed);

		if(siteCreatedSuccessMessageIsDisplayed) {
			sendkeys(htmlElementLocator2.getSearchbox(), siteName);
			createdSiteIsDisplayed = htmlElementLocator2.getCreatedSite().isDisplayed();
			assertTrue(createdSiteIsDisplayed);
		}else {
			System.out.println("Searching the created site is not listed here");
		}

	}


	// @Test(description = "This test case verifies that, Viewing the Site Installation Report for the created site", priority = 5)
	public void shouldAbleToViewSIRForTheCreatedSite() throws IOException, InterruptedException {
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();

//String siteName = getDataFromExcel("siteDetails", 1, 0);



//sendkeys(htmlElementLocator2.getSearchbox(), siteName);
		normalClick(htmlElementLocator2.getInstallationReportIconButton());
		normalClick(htmlElementLocator2.getSiteDetailsTabButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator2.getPumpDetailsTabButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator2.getTestimonyTabButton());
		normalClick(htmlElementLocator2.getSirPopupCancelButton());

//Need assert the input datas with the entered inputs.


	}

	@Test(description = "This test case verifies that, Updating the Site deatils for the created site", priority = 6)
	public void shouldAbleToUpdateSite() throws IOException, InterruptedException {

		boolean updateSuccessMessage = false;
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();

		String siteName = getDataFromExcel("siteDetails", 1, 0);

		sendkeys(htmlElementLocator2.getSearchbox(), siteName);
		normalClick(htmlElementLocator2.getOpenSite());
		sendkeys(htmlElementLocator2.getSiteName(), "Kottivakam");
		sendkeys(htmlElementLocator2.getSiteAddress1(),"IGP Stop 1st cross street");

		normalClick(htmlElementLocator2.getUpdateSiteButton());

		try {
			updateSuccessMessage = htmlElementLocator2.getSiteUpdatedSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Site not updated");
		}
		assertTrue(updateSuccessMessage);
		if(updateSuccessMessage) {
			System.out.println("Site is updated");
		}else {
			System.out.println("Site not updated!!");
		}
	}
	@Test(description = "This test case verifies that, Delete the Site deatils from the Site Management", priority = 7)
	public void shouldAbleToDeleteSite() throws IOException, InterruptedException {
		boolean searchedSiteIsDisplayed = false;
		boolean deleteSuccessMessage = false;
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();

		String siteName = getDataFromExcel("siteDetails", 1, 0);

		sendkeys(htmlElementLocator2.getSearchbox(), siteName);

		try {
			searchedSiteIsDisplayed = htmlElementLocator2.getCreatedSite().isDisplayed();
		}catch(Exception e) {
			System.out.println("Not listed");
		}

		if(searchedSiteIsDisplayed) {
			normalClick(htmlElementLocator2.getOpenSite());
			normalClick(htmlElementLocator2.getDeleteSiteButton());
			normalClick(htmlElementLocator2.getOkButton());
		}
		else {
			System.out.println("Not able to delete the site");
		}

		try {
			deleteSuccessMessage = htmlElementLocator2.getSiteDeletedSuccessMessage().isDisplayed();
		}
		catch(Exception e) {
			System.out.println("Locator missing");
		}
		assertTrue(deleteSuccessMessage);

	}




}