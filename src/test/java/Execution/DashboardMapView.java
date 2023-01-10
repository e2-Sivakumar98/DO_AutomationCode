package Execution;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;

public class DashboardMapView extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
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

	//@Test(description = "This test case verifies that available partners are listed in the allpartner dropdown.", priority=1)
	public void shouldPartnersIsDisplayedInAllPartnerDropDown() throws Exception {

		Thread.sleep(10000);

		boolean allPartnerListISDisplayed = false;
		boolean allPartnerButtonIsDisplayed =false;

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();

		//Thread.sleep(10000);
		
		//selectOptionByText(htmlElmentLocator1.getallPartnersDropDownButton(),"All Partners ");
		Thread.sleep(3000);
		try {
			allPartnerButtonIsDisplayed = htmlElmentLocator1.getallPartnersDropDownButton().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(allPartnerButtonIsDisplayed);
		
		Thread.sleep(3000);
		normalClick(htmlElmentLocator1.getallPartnersDropDownButton());
		try {
			allPartnerListISDisplayed = htmlElmentLocator1.getAllPartnerListButton().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(allPartnerListISDisplayed);
		normalClick(htmlElmentLocator1.getallPartnersDropDownButton());

	}

	@Test(description="This test case verifies that available partners are listed in the allpartner dropdown.", priority=2)
	public void shouldAbleToSelectPartner() throws Exception {

		boolean selectedPartnerIsDisplayed = false;

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		implicitWait(8);
		//Thread.sleep(5000);
		normalClick(htmlElmentLocator1.getallPartnersDropDownButton());
		Thread.sleep(4000);
		htmlElmentLocator1.getSelectedPartnerFromTheList().click();

		Thread.sleep(2000);
		try {
			selectedPartnerIsDisplayed = htmlElmentLocator1.getSelectedPartnerFromTheList().isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(selectedPartnerIsDisplayed);
	}

	@Test(description="This test case verifies that unassigned LPLinks tab is selected.", priority=3)

	public void shouldUnassignedLPLinkTabISSelected() throws InterruptedException {

		boolean unassignedLPLinkTabIsSelected = false;

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		implicitWait(5);
		//Thread.sleep(10000);
		normalClick(htmlElmentLocator1.getunassignedLPLinksButton());

		Thread.sleep(1000);
		try {
			unassignedLPLinkTabIsSelected = htmlElmentLocator1.getunassignedLPLinksButton().isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(unassignedLPLinkTabIsSelected);
	}

	//@Test(description="This test case verifies that searched site is displayed in the map.", priority=4)

	public void shouldAbleToSearchRequiredSite() throws InterruptedException, Exception {

		boolean searchedSiteISDisplayed = false;

		String sitename = getDataFromExcel("SearchingTheSite", 1, 0);

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();

		Thread.sleep(5000);

		sendkeys(htmlElmentLocator1.getsearchField(), sitename);

		Thread.sleep(5000);
		try {
			searchedSiteISDisplayed = htmlElmentLocator1.getsearchField().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(searchedSiteISDisplayed);
	}

}
