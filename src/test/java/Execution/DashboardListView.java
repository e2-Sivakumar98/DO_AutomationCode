package Execution;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;

public class DashboardListView extends Base_class{
	
	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}
	@BeforeSuite
	public void dashboardLaunch() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials",1,0); 
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials",1,1); 
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		
		sendkeys(htmlElmentLocator.getEmailTextBox(),userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
		
		normalClick(htmlElmentLocator.getLoginButton());
		
	}
	
	@Test(description="This test case verifies that dashboard view gets changed to list view choosing option as list.")
	public void shouldDashboardDisplayedHasInListView() throws Exception {
		
		boolean isListViewButtonSelected = false;
		
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		
		Thread.sleep(10000);
		normalClick(htmlElmentLocator1.getDashboardListViewButton());
		
		Thread.sleep(3000);
		try {
			isListViewButtonSelected = htmlElmentLocator1.getDashboardListViewButton().isEnabled();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(isListViewButtonSelected);
		
	}
	
	//@Test(description="This test case verifies that selected partner site is listed in the page.")
	public void shouldSelectedPartnerSiteIsDisplayed() throws Exception {
		
		boolean selectedPartnerIsDisplayed = false;
		boolean selectedPartnerIsDisplayedOnPartnerNameRow = false;

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();

		Thread.sleep(8000);
		normalClick(htmlElmentLocator1.getallPartnersDropDownButton());
		Thread.sleep(5000);
		
		selectOptionByIndex(htmlElmentLocator1.getSelectedPartnerFromTheList(),5);
		Thread.sleep(5000);
		try {
			selectedPartnerIsDisplayed = htmlElmentLocator1.getSelectedPartnerFromTheList().isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(selectedPartnerIsDisplayed);
		
		Thread.sleep(4000);
		try {
			selectedPartnerIsDisplayedOnPartnerNameRow = htmlElmentLocator1. getselectedPartnerSite().isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		assertTrue(selectedPartnerIsDisplayedOnPartnerNameRow);

	}
	
	@Test(description="This test case verifies that searched site should be displayed.")
	public void shouldSearchedSiteNameISDisplayed() throws Exception {
		boolean searchedSiteNameIsDisplayed = false;
		
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();

		Thread.sleep(10000);
		//String getCopyTextValue = 
		contextClick( htmlElmentLocator1.searchingSiteByName());
		//copy();
//		Thread.sleep(3000);
//		normalClick(htmlElmentLocator1.getsearchField());
//		Thread.sleep(3000);
//		sendkeys(htmlElmentLocator1.getsearchField(),paste());
//		 
//		try {
//			searchedSiteNameIsDisplayed = htmlElmentLocator1.searchingSiteByName().isDisplayed();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		assertTrue(searchedSiteNameIsDisplayed);
		
	}
	
	
	
}
