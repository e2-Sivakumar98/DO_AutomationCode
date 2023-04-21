package Execution;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.DashBoardPageLocators;
import Locators.LoginPageLocators;
import Locators.MaintenanceReportLocators;
import Locators.UserManagementPageLocators;
import Locators.siteManagementPagelocators;

public class MaintenanceReport extends Base_class{
	
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
	
	@Test(description = "This test case verifies that landing page is Maintenance Report module", priority = 1)
	public void shouldMaintenanceReportPageDisplayed() throws Exception {
		implicitWait(10);
		boolean maintenanceReportTitleNameIsDisplayed = false;
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		Thread.sleep(7000);
		normalClick(htmlElmentLocator1.getMenuButton());
		//Thread.sleep(5000);
		normalClick(htmlElementLocator.getSytemAdministration());
		normalClick(htmlElementLocator2.getSiteAdministration());
		normalClick(htmlElementLocator3.getMaintenanceReportDrawerName());
		try {
			maintenanceReportTitleNameIsDisplayed = htmlElementLocator3.getMaintenanceReportTitleName().isDisplayed();
		}catch(Exception e) {
			System.out.println("MR Page locator not found");
		}
		if(maintenanceReportTitleNameIsDisplayed) {
			System.out.println("Maintenance Report Page Displayed");
		}
		else {
			System.out.println("Maintenance Report Page Not Displayed");
		}
	}
	
	@Test(description = "This test case verifies that default new report tab is selected", priority = 2)
	public void shouldNewReportsDefaultTabPageDisplayed() throws InterruptedException {
		
		boolean newReportTabIsSelected = false;
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		
		try {
			newReportTabIsSelected = htmlElementLocator3.getNewReportsTabButton().isEnabled();
		}catch(Exception e) {
			System.out.println("Locator not found");
		}
		assertTrue(newReportTabIsSelected);
		if(newReportTabIsSelected) {
			System.out.println("Default New Reports tab is selected");
		}
		else {
			System.out.println("Not selected");
		}
	}
	
	@Test(description = "This test case verifies that able to create Maintenance report for an existing site", priority = 3)
	public void shouldAbletoCreateMRSite() throws InterruptedException, IOException {
		String communityName = getDataFromExcel("MaintenanceReport", 1, 0);
		String district = getDataFromExcel("MaintenanceReport", 1, 1);
		String country = getDataFromExcel("MaintenanceReport", 1, 2);
		String lifePumpID = getDataFromExcel("MaintenanceReport", 1, 3);
		String pleaseDescribeReportedIssue = getDataFromExcel("MaintenanceReport", 1, 4);
		String firstResponderName = getDataFromExcel("MaintenanceReport", 1, 5);
		String firstResponderCellPhoneNumber = getDataFromExcel("MaintenanceReport", 1, 6);
		String waterPointCommitteeMemberName = getDataFromExcel("MaintenanceReport", 1, 7);
		String waterPointCommitteeMemberPhoneNumber = getDataFromExcel("MaintenanceReport", 1, 8);
		String datePerformed = getDataFromExcel("MaintenanceReport", 1, 9);
		String nameOfPersonPerformingMaintenance = getDataFromExcel("MaintenanceReport", 1, 10);
		//String serialNumber = getDataFromExcel("MaintenanceReport", 1, 11);
		String newGearboxAssemblyNumber = getDataFromExcel("MaintenanceReport", 1, 11);
		String newGearboxDateCoder = getDataFromExcel("MaintenanceReport", 1, 12);
		String newStatorSerialNumber = getDataFromExcel("MaintenanceReport", 1, 13);
		String maintenanceNotes = getDataFromExcel("MaintenanceReport", 1, 14);
		String wereAnyNonStandardHardwareInstalledOnThePump = getDataFromExcel("MaintenanceReport", 1, 15);
		String peakHandleTorque = getDataFromExcel("MaintenanceReport", 1, 16);
		String handlRotationsToFillContainer= getDataFromExcel("MaintenanceReport", 1, 17);
		String optionalNote = getDataFromExcel("MaintenanceReport", 1, 18);
		String pumpMaintenancePeriod = getDataFromExcel("MaintenanceReport", 1, 19);
		String pleaseRecordNamePersonBeingInterviewed = getDataFromExcel("MaintenanceReport", 1, 20);
		String ageOfPersonBeingInterviewed = getDataFromExcel("MaintenanceReport", 1, 21);	
		
		boolean reportCreatedSuccessMessage = false;
		boolean preventativeMaintenanceOptionIsSelected = false;
		boolean nonStandardHardwareOptionSelected = false;
		boolean gearBoxSealLeakingYesOptionSelected = false;
		boolean pumpMaintenancePeriodOption1IsSelected = false;
		boolean pumpMaintenancePeriodOption2IsSelected = false;
		
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		
		normalClick(htmlElementLocator3.getAddNewReportButton());
		normalClick(htmlElementLocator2.getPartnerNameDropdown());
		Thread.sleep(2000);
		normalClick(htmlElementLocator.getSelectPartnerName());
		normalClick(htmlElementLocator3.getSiteIdDropDownButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator3.getSelectSiteId());
		sendkeys(htmlElementLocator3.getLifePumpId(), lifePumpID);
		sendkeys(htmlElementLocator3.getReportedIssue(), pleaseDescribeReportedIssue);
		sendkeys(htmlElementLocator3.getWaterPointCommitteeName(), waterPointCommitteeMemberName);
		sendkeys(htmlElementLocator3.getWaterPointCommitteePhone(), waterPointCommitteeMemberPhoneNumber);
		normalClick(htmlElementLocator3.getNextButton());
		sendkeys(htmlElementLocator3.getDatePerformed(), datePerformed);
		sendkeys(htmlElementLocator3.getNameOfPersonPerformingMaintenance(), nameOfPersonPerformingMaintenance);
		try {
		preventativeMaintenanceOptionIsSelected = htmlElementLocator3.getPrimaryReasonForVisitingPumpOption().isSelected();
		}catch(Exception e){
			System.out.println("Locator not found");
			
		}
		if(preventativeMaintenanceOptionIsSelected) {
			normalClick(htmlElementLocator3.getPrimaryReasonForVisitingPumpRepairOption());
		}
		
		normalClick(htmlElementLocator3.getWasIssueReslovedYesOption());
		normalClick(htmlElementLocator3.getWaspumpfunctionaluponleavingsiteYesOption());
		normalClick(htmlElementLocator3.getNewGearboxAssemblyNumber());
		//sendkeys(htmlElementLocator3.getNewGearboxAssemblyNumber(),newGearboxAssemblyNumber);
		sendkeys(htmlElementLocator3.getNewGearboxDateCode(),newGearboxDateCoder);
		sendkeys(htmlElementLocator3.getNewStatorSerialNumber(),newStatorSerialNumber);
		sendkeys(htmlElementLocator3.getMaintenanceNotes(),maintenanceNotes);
		normalClick(htmlElementLocator3.getNextButton());
		
		try {
			nonStandardHardwareOptionSelected = htmlElementLocator3.getNonstandardhardwareinstalledYesOption().isSelected();
		}catch(Exception e) {
			System.out.println("Locator not found1");
		}
		if(nonStandardHardwareOptionSelected) {
			sendkeys(htmlElementLocator3.getNonstandardhardwareinstalled(), wereAnyNonStandardHardwareInstalledOnThePump);
		}
		else {
			//normalClick(htmlElementLocator3.getNonstandardhardwareinstalledNoOption());
			sendkeys(htmlElementLocator3.getPeakhandletorque(), peakHandleTorque);
		}
		
		sendkeys(htmlElementLocator3.getHandlerotation(), handlRotationsToFillContainer);
		try {
		gearBoxSealLeakingYesOptionSelected = htmlElementLocator3.getIsgearboxSealLeakingYesOption().isSelected();
		}catch(Exception e) {
			System.out.println("Invalid locator");
		}
		
		if(gearBoxSealLeakingYesOptionSelected) {
			
			String filepath = "/home/devmachine/Downloads/do1.jpeg";
			File filename = new File(filepath);
			String path = filename.getAbsolutePath();
			normalClick(htmlElementLocator3.getVisualAssessment());
			
			//sendkeys(htmlElementLocator3.getVisualAssessment(), path);
			sendkeys(htmlElementLocator3.getOptionalNotes(), optionalNote);
			
		}else {
			normalClick(htmlElementLocator3.getNextButton());
		}
		normalClick(htmlElementLocator3.getNextButton());
		try {
		pumpMaintenancePeriodOption1IsSelected = htmlElementLocator3.getPumpmaintenanceperiodOption1().isSelected();
		}catch(Exception e) {
			System.out.println("Locator not found2");
		}
		try {
		pumpMaintenancePeriodOption2IsSelected = htmlElementLocator3.getPumpMaintenancePeriodOption2().isSelected();
		}catch(Exception e) {
			System.out.println("Locator not found3");
		}
		
		if(pumpMaintenancePeriodOption1IsSelected) {
			Thread.sleep(2000);
			sendkeys(htmlElementLocator3.getLifePumpBenefitedYourCommunity(),pumpMaintenancePeriod);
		}
		else if(pumpMaintenancePeriodOption2IsSelected) {
			sendkeys(htmlElementLocator3.getUnderstandWhatTheProblem(), pumpMaintenancePeriod);			
		}
		
		sendkeys(htmlElementLocator3.getNameOfPersonBeingInterviewed(), pleaseRecordNamePersonBeingInterviewed);
		sendkeys(htmlElementLocator3.getAgeOfPerson(), ageOfPersonBeingInterviewed);
		String filepath = "/home/devmachine/Downloads/do1.jpeg";
		File filename = new File(filepath);
		String path = filename.getAbsolutePath();
		normalClick(htmlElementLocator3.getVisualAssessment());
		sendkeys(htmlElementLocator3.getVisualAssessment(), path);
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getPhotoCheckList());
		normalClick(htmlElementLocator3.getSaveButton());
		
		try {
			reportCreatedSuccessMessage = htmlElementLocator3.getReportCreatedSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Locator not found for report created");
		}
		if(reportCreatedSuccessMessage) {
			System.out.println("Report created");
		}else {
			System.out.println("Report not created");
		}
	}
	
	@Test(description = "This test case verifies that able to update the  Maintenance report", priority = 4)
	public void shouldAbleTOUpdateMR() throws InterruptedException, IOException {
		
		boolean updateSuccessMessage = false;
		String communityName = getDataFromExcel("MaintenanceReport", 1, 0);
		String lifePumpID = getDataFromExcel("MaintenanceReport", 1, 3);

		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		
		
		sendkeys(htmlElementLocator2.getSearchbox(), communityName);
		normalClick(htmlElementLocator3.getEditButton());
		doubleClick(htmlElementLocator3.getLifePumpId());
		sendkeys(htmlElementLocator3.getLifePumpId(), "lp-lh-788");
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getPrimaryReasonForVisitingPumpRepairOption());
		normalClick(htmlElementLocator3.getNewGearboxAssemblyNumber1());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNonstandardhardwareinstalledNoOption());
		normalClick(htmlElementLocator3.getIsgearboxSealLeakingNoOption());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getPumpMaintenancePeriodOption2());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getSaveButton());
		Thread.sleep(2000);
		try {
			updateSuccessMessage = htmlElementLocator3.getUpdateSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Invalid locator");
		}
		assertTrue(updateSuccessMessage);
		if(updateSuccessMessage) {
			System.out.println("MR report udpated");
		}else {
			System.out.println("MR report not udpated");
		}
	}
	
	//@Test(description = "This test case verifies that able to approve the  Maintenance report", priority = 5)
	public void shouldAbleToApproveMR() throws InterruptedException, IOException {
		boolean approvedSuccessMessage = false;
		
		String communityName = getDataFromExcel("MaintenanceReport", 1, 0);
		
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		UserManagementPageLocators htmlElementLocator = new UserManagementPageLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		
		doubleClick(htmlElementLocator2.getSearchbox());
		sendkeys(htmlElementLocator2.getSearchbox(), communityName);
		normalClick(htmlElementLocator3.getEditButton());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getSaveApproveButton());
		Thread.sleep(2000);
		try {
			approvedSuccessMessage = htmlElementLocator3.getReportCreatedSuccessMessage().isDisplayed();
		}catch(Exception e) {
			System.out.println("Approved locator not found");
		}
		if(approvedSuccessMessage) {
			normalClick(htmlElementLocator3.getApprovedReportsTabButton());
			doubleClick(htmlElementLocator2.getSearchbox());
			sendkeys(htmlElementLocator2.getSearchbox(), communityName);
			System.out.println("Report approved");
		}else {
			System.out.println("Report not approved");
		}
	}
	
	@Test(description = "This test case verifies that the Maintenance report is available in the Site management for the Site", priority = 6)
	public void shouldApprovedMaintenanceReportIsUpdatedInSiteManagement() throws InterruptedException, IOException {
		String communityName = getDataFromExcel("MaintenanceReport", 1, 0);
		
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		DashBoardPageLocators htmlElmentLocator1 = new DashBoardPageLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		
		normalClick(htmlElmentLocator1.getMenuButton());
		normalClick(htmlElementLocator2.getSiteManagement());
		doubleClick(htmlElementLocator2.getSearchbox());
		Thread.sleep(3000);
		sendkeys(htmlElementLocator2.getSearchbox(), communityName);
		normalClick(htmlElementLocator2.getMaintenanceReportIconButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator2.getViewMaintenanceReport());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNextButton());
		normalClick(htmlElementLocator3.getNextButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator3.getNextButton());
		//To close the current popup of MR
		normalClick(htmlElementLocator2.getSiteDetailsTabButton());
		normalClick(htmlElementLocator2.getCloseMaintenanceReportpopupPage());
		normalClick(htmlElementLocator2.getSearchCancelButton());
		normalClick(htmlElmentLocator1.getMenuButton());
		Thread.sleep(2000);
		normalClick(htmlElementLocator3.getMaintenanceReportDrawerName());
		
	}
	//@Test(description = "This test case verifies that able to delete the saved Maintenance report", priority = 7)
	public void shouldAbleToDeleteMR() throws InterruptedException, IOException {
		
		boolean deleteSuccessMessage = false;
		String communityName = getDataFromExcel("MaintenanceReport", 1, 0);
		
		MaintenanceReportLocators htmlElementLocator3 = new MaintenanceReportLocators();
		siteManagementPagelocators htmlElementLocator2 = new siteManagementPagelocators();
		
		doubleClick(htmlElementLocator2.getSearchbox());
		sendkeys(htmlElementLocator2.getSearchbox(), communityName);
		normalClick(htmlElementLocator3.getDeleteButton());
		normalClick(htmlElementLocator3.getOkButton());
		Thread.sleep(2000);
		try {
			deleteSuccessMessage = htmlElementLocator3.getReportDeletedSuccessMessage().isDisplayed();
		}
		catch(Exception e) {
			System.out.println("Invalid locator for Delete button");
		}
		assertTrue(deleteSuccessMessage);
		if(deleteSuccessMessage) {
			System.out.println("MR deleted");
		}else {
			System.out.println("MR not deleted");
		}
	}
}
