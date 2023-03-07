package Execution;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;

public class SiteStatus extends Base_class {

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}

	@BeforeSuite
	public void dashboardLaunch() throws InterruptedException, IOException {
		
		Thread.onSpinWait();
//		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials", 1, 0);
//		String userPassword = getDataFromExcel("SuccessfullLoginCredentials", 1, 1);

		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		implicitWait(5);
		sendkeys(htmlElmentLocator.getEmailTextBox(), "e2dosupport@doutreach.org");
		sendkeys(htmlElmentLocator.getPasswordTextBox(), "e2dosupport@do2020");

		normalClick(htmlElmentLocator.getLoginButton());

	}

	@Test(description = "This test case verifies that list view is displayed", priority=1)
	public void shouldSListViewIsDisplayed() throws InterruptedException {
		
		
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		//implicitWait(8);
		Thread.sleep(8000);
		
		normalClick(htmlElmentLocator1.getDashboardListViewButton());
		//Thread.sleep(3000);
		normalClick(htmlElmentLocator1.getPageExtendButton());
		normalClick(htmlElmentLocator1.getextendPageTo100());

	}
	@Test(description = "This test case verifies that usage details of the available red alert sites", priority=2)
	public void redAlertSite() throws InterruptedException {
		int j = 0;

		boolean isRedAlertDisplayed= false;
		boolean isRedAlertStatusDisplayed = false;
		//	boolean isDefaultCustomDaysDisplayed = false;
		boolean isNoDataMessageDisplayed = false;
		boolean redAlertIconStatus = false;

		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		implicitWait(5);


		//Thread.sleep(5000);

		System.out.println(htmlElmentLocator1.getRedAlertIconButton().size());
		for (int i = 0; i <htmlElmentLocator1.getRedAlertIconButton().size(); i++) {


			htmlElmentLocator1.getRedAlertIconButton().get(i).click();

			redAlertIconStatus=	htmlElmentLocator1.getRedAlertIconStatus().isDisplayed();

			//Thread.sleep(2000);
			normalClick(htmlElmentLocator1.getCancelbutton());

			//Thread.sleep(2000);

			if(j<htmlElmentLocator1.getUsageDetailButton().size()) {

				htmlElmentLocator1.getUsageDetailButton().get(j).click();

				try {
					isNoDataMessageDisplayed = htmlElmentLocator1.getEmptySite().isDisplayed();
				}catch(Exception e) {

				}


				if(!isNoDataMessageDisplayed)
				{


					//					try {
					//						isRedAlertDisplayed = htmlElmentLocator1.getLifePumpUsageStatusRedColor().isDisplayed();
					//					}catch(Exception e) {
					//						System.out.println("Red Alert icon mismatch At The Position Of "+ j);
					//					}
					//					assertTrue(isRedAlertDisplayed);
					normalClick(htmlElmentLocator1.getSelectDaysButton());
					
					for(int k=1;k<htmlElmentLocator1.getSelectDay().size();k++) {
					//	System.out.println(htmlElmentLocator1.getSelectDay().size());
						//Thread.sleep(3);
						htmlElmentLocator1.getSelectDay().get(k).click();
						
						
					}

					try {
						isRedAlertStatusDisplayed = htmlElmentLocator1.getLifePumpUsageAlertStatus().isDisplayed();
						assertEquals(redAlertIconStatus,isRedAlertStatusDisplayed );
					}catch(Exception e) {
						System.out.println("Red Alert Status Mismatch At The Position Of "+ j);
					}


					//Thread.sleep();

					normalClick(htmlElmentLocator1.getCancelbutton());

				}
				else {

					System.out.println("No Data Received Yet"+ j);
				}
			}
			else {
				System.out.println("Red Alert Icon Not Exist");
			}
			j++;
		}

	}


	@Test(description = "This test case verifies that usage details of the available yellow alert sites", priority= 3)
	public void yellowAlertSite() throws InterruptedException {
		int j = 0;

		boolean isYellowAlertDisplayed= false;
		boolean isYellowAlertStatusDisplayed = false;
		boolean isDefaultCustomDatysDisplayed = false;
		boolean yellowAlertIconStatus = false;
		boolean isNoDataMessageDisplayed = false;
		
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		Thread.sleep(5000);
		System.out.println(htmlElmentLocator1.getYellowAlertIconButton().size());
		for (int i = 0; i < htmlElmentLocator1.getYellowAlertIconButton().size(); i++) {


			htmlElmentLocator1.getYellowAlertIconButton().get(i).click();
			yellowAlertIconStatus=	htmlElmentLocator1.getYellowAlertIconStatus().isDisplayed();
			normalClick(htmlElmentLocator1.getCancelbutton());

			if(j<htmlElmentLocator1.getYellowUsageDetails().size()) {
				System.out.println(htmlElmentLocator1.getYellowUsageDetails().get(j).isDisplayed());
				//Thread.sleep(2000);
				htmlElmentLocator1.getYellowUsageDetails().get(j).click();

				try {
					isNoDataMessageDisplayed = htmlElmentLocator1.getEmptySite().isDisplayed();
				}catch(Exception e) {

				}	

				//	Thread.sleep(2000);
				//				try {
				//					isYellowAlertDisplayed = htmlElmentLocator1.getLifePumpUsageStatusYellowColor().isDisplayed();
				//				
				//				}catch(Exception e) {
				//					System.out.println("Yellow Alert icon not displayed At The Position Of "+ j);
				//				}

				//	Thread.sleep(2000);
				if(!isNoDataMessageDisplayed) {
					
					normalClick(htmlElmentLocator1.getSelectDaysButton());
					for(int k=0;k<htmlElmentLocator1.getSelectDay().size();k++) {
						
						htmlElmentLocator1.getSelectDay().get(k).click();
						Thread.sleep(5000);
					
					}
					try {
						isYellowAlertStatusDisplayed = htmlElmentLocator1.getLifePumpUsageStatusYellowColor().isDisplayed();
						assertEquals(yellowAlertIconStatus,isYellowAlertStatusDisplayed);
					}catch(Exception e) {
						System.out.println("Yellow Alert Status Mismatching At The Position Of "+ j);
					}

					//Thread.sleep(2000);
					normalClick(htmlElmentLocator1.getCancelbutton());
				}
				else {
					System.out.println("No Data Received for the Site "+ j);
				}

			}
			else {
				System.out.println("Yellow Alert Icon locator Not From The List View");
			}
			j++;
		}

	}

}



//Thread.sleep(8000);
//
//
//Thread.sleep(5000);
//int y=0,k;
////for(int k=0; k<=htmlElmentLocator1.getYellowAlertIconButton().size(); k++) {
//if(y<=htmlElmentLocator1.getYellowAlertIconButton().size()) {
//	
//	
//	htmlElmentLocator1.getYellowAlertIconButton().get(y).click();
//	
//	normalClick(htmlElmentLocator1.getCancelbutton());
//	Thread.sleep(2000);
//	normalClick(htmlElmentLocator1.getYellowUsageDetails());
//	Thread.sleep(2000);
//	normalClick(htmlElmentLocator1.getCancelbutton());
//	y++;
//		
//}
//
//else if(y<=htmlElmentLocator1.getOrangeAlertIconButton().size()) {
//	
//	htmlElmentLocator1.getOrangeAlertIconButton().get(y).click();
//	normalClick(htmlElmentLocator1.getCancelbutton());
//	normalClick(htmlElmentLocator1.geOrangeUsageDetails());
//	Thread.sleep(2000);
//	normalClick(htmlElmentLocator1.getCancelbutton());
//	y++;
//	
//}
//else if(y<=htmlElmentLocator1.getGreenlertIconButton().size()) {
//	
//	normalClick(htmlElmentLocator1.getGreenUsageDetails());
//	Thread.sleep(2000);
//	normalClick(htmlElmentLocator1.getCancelbutton());
//	y++;
//}
