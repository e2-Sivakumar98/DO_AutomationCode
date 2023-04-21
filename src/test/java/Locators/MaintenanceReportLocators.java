package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base_class;

public class MaintenanceReportLocators extends Base_class {
	
	public MaintenanceReportLocators() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Maintenance Report']")
	private WebElement maintenanceReportDrawerName;
	
	@FindBy(xpath = "//span[text()='Maintenance Report']")
	private WebElement maintenanceReport;
	
	@FindBy(xpath = "//span[text()='Maintenance Report']")
	private WebElement MaintenanceReportTitleName;
	
	@FindBy(id = "site-select")
	private WebElement allsiteDropDownButton;
	
	@FindBy(xpath = "(//button[@role='tab'])[1]")
	private WebElement newReportsTabButton;
	
	@FindBy(xpath = "(//button[@role='tab'])[2]")
	private WebElement approvedReportsTabButton;
	
	@FindBy(xpath = "(//button[@type='button'])[6]")
	private WebElement addNewReportButton;
	
	@FindBy(xpath = "(//button[@type='button'])[11]")
	private WebElement closeNewReportdialoguePage;
	
	@FindBy(xpath = "(//button[@role='tab'])[3]")
	private WebElement maintenanceNotificationSlide;
	
	@FindBy(xpath = "(//button[@role='tab'])[4]")
	private WebElement maintenanceActivitySlide;
	
	@FindBy(xpath = "(//button[@role='tab'])[5]")
	private WebElement pumpInspectionSlide;
	
	@FindBy(xpath = "(//button[@role='tab'])[6]")
	private WebElement shortTestimony1Slide;
	
	@FindBy(xpath = "(//button[@role='tab'])[7]")
	private WebElement finalDocumentation;
	
	@FindBy(xpath = "(//div[@role='button'])[3]")
	private WebElement siteIdDropDownButton;
	
	@FindBy(id = "COMM_NAME")
	private WebElement communityName;
	
	@FindBy(xpath = "//li[text()='MOS1566 Mosangu']")
	private WebElement selectSiteId;
	
	@FindBy(id = "DISTRICT")
	private WebElement district;
	
	@FindBy(id = "COUNTRY")
	private WebElement country;
	
	@FindBy(id = "LIFEPUMP_ID")
	private WebElement lifePumpId;
	
	@FindBy(id = "REPORTED_ISSUE")
	private WebElement reportedIssue;
	
	@FindBy(id = "CARE_TAKER_NAME")
	private WebElement careTakerName;
	
	@FindBy(id = "CARE_TAKER_PHONE")
	private WebElement careTakerPhone;
	
	@FindBy(id = "WATER_PNT_COMM_MEM_NAME")
	private WebElement waterPointCommitteeName;
	
	@FindBy(id = "WATER_PNT_COMM_MEM_PHONE")
	private WebElement waterPointCommitteePhone;
	
	@FindBy(id = "DATE_PERFORMED")
	private WebElement datePerformed;
	
	@FindBy(id = "NAME_OF_PRSN_PERFORM_MAINT")
	private WebElement nameOfPersonPerformingMaintenance;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement primaryReasonForVisitingPumpOption;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement primaryReasonForVisitingPumpRepairOption;
	
	@FindBy(xpath="(//input[@type='radio'])[4]")
	private WebElement wasIssueReslovedYesOption;
	
	@FindBy(xpath="(//input[@type='radio'])[5]")
	private WebElement wasIssueReslovedNoOption;
	
	@FindBy(xpath="(//input[@type='radio'])[6]")
	private WebElement waspumpfunctionaluponleavingsiteYesOption;
	
	@FindBy(xpath="(//input[@type='radio'])[7]")
	private WebElement waspumpfunctionaluponleavingsiteNoOption;
	
	@FindBy(xpath="(//input[@type='radio'])[8]")
	private WebElement newLifePumpLinkInstalledYesOption;
	
	@FindBy(xpath="(//input[@type='radio'])[9]")
	private WebElement newLifePumpLinkInstalledNoOption;
	
	@FindBy(xpath="(//input[@type='radio'])[10]")
	private WebElement newGearboxAssemblyNumber;
	
	@FindBy(xpath="(//input[@type='radio'])[11]")
	private WebElement newGearboxAssemblyNumber1;
	
	@FindBy(xpath="(//input[@type='radio'])[16]")
	private WebElement newGearboxAssemblyNumberOtherField;
	
	@FindBy(id = "NEW_GEARBOX_ASSEM_NUM")
	private WebElement newGearboxAssemblyNumberTextField;
	
	@FindBy(id = "NEW_GEARBOX_DATE_CODE")
	private WebElement newGearboxDateCode;
	
	@FindBy(id = "NEW_STATOR_SERIAL_NUM")
	private WebElement newStatorSerialNumber;
	
	@FindBy(id = "MAINTENANCE_NOTES")
	private WebElement maintenanceNotes;
	 
	@FindBy(xpath = "(//button[@type='button'])[16]")
	private WebElement previousButton;
	
	@FindBy(xpath = "//button[@title='Go to next page']")
	private WebElement nextButton;
	
	@FindBy(xpath = "(//button[@type='button'])[15]")
	private WebElement saveButton;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement nonstandardhardwareinstalledYesOption;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement nonstandardhardwareinstalledNoOption;
	
	@FindBy(id = "DES_NON_STD_HARDWARE_INSTALLED")
	private WebElement nonstandardhardwareinstalled;
	
	@FindBy(id = "PEAK_HANDLE_TORQUE")
	private WebElement Peakhandletorque;
	
	@FindBy(id = "HANDLE_ROTS_TO_FILL_20L")
	private WebElement Handlerotation;
	
	@FindBy(xpath="(//input[@type='radio'])[3]")
	private WebElement isgearboxSealLeakingYesOption;
	
	@FindBy(xpath="(//input[@type='radio'])[4]")
	private WebElement isgearboxSealLeakingNoOption;
	
	@FindBy(id = "OPTIONAL_NOTE")
	private WebElement optionalNotes;
	
	@FindBy(xpath = "//span[text()='Choose Files']")
	private WebElement visualAssessment;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement PumpmaintenanceperiodOption1;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement PumpMaintenancePeriodOption2;
	
	@FindBy(id = "LIFEPUMP_BENIFT_YOUR_COMM")
	private WebElement lifePumpBenefitedYourCommunity;
	
	@FindBy(id = "PROBLEM_WITH_YOUR_LIFEPUMP")
	private WebElement understandWhatTheProblem;
	
	@FindBy(id = "NAME_OF_PERSON_INTERVIEWED")
	private WebElement nameOfPersonBeingInterviewed;
	
	@FindBy(id = "AGE_OF_PERSON_INTERVIEWED")
	private WebElement AgeOfPerson;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement photoCheckList;
	
	@FindBy(xpath = "(//button[@type='button'])[18]")
	private WebElement saveApproveButton;
	
	@FindBy(xpath = "(//span[@role='button'])[6]")
	private WebElement editButton;
	
	@FindBy(xpath = "(//span[@role='button'])[7]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement okButton;
	
	@FindBy(xpath = "//div[text()='Update Report']")
	private WebElement updateReportPage;
	
	@FindBy(xpath = "//span[text()='Report created successfully']")
	private WebElement reportCreatedSuccessMessage;
	
	@FindBy(xpath = "//span[text()='Report updated successfully']")
	private WebElement updateSuccessMessage;
	
	@FindBy(xpath = "//span[text()='Report deleted successfully']")
	private WebElement reportDeletedSuccessMessage;

	public WebElement getMaintenanceReportDrawerName() {
		return maintenanceReportDrawerName;
	}

	public WebElement getMaintenanceReport() {
		return maintenanceReport;
	}

	public WebElement getMaintenanceReportTitleName() {
		return MaintenanceReportTitleName;
	}

	public WebElement getAllsiteDropDownButton() {
		return allsiteDropDownButton;
	}

	public WebElement getNewReportsTabButton() {
		return newReportsTabButton;
	}

	public WebElement getApprovedReportsTabButton() {
		return approvedReportsTabButton;
	}

	public WebElement getAddNewReportButton() {
		return addNewReportButton;
	}

	public WebElement getCloseNewReportdialoguePage() {
		return closeNewReportdialoguePage;
	}

	public WebElement getMaintenanceNotificationSlide() {
		return maintenanceNotificationSlide;
	}

	public WebElement getMaintenanceActivitySlide() {
		return maintenanceActivitySlide;
	}

	public WebElement getPumpInspectionSlide() {
		return pumpInspectionSlide;
	}

	public WebElement getShortTestimony1Slide() {
		return shortTestimony1Slide;
	}

	public WebElement getFinalDocumentation() {
		return finalDocumentation;
	}

	public WebElement getSiteIdDropDownButton() {
		return siteIdDropDownButton;
	}

	public WebElement getSelectSiteId() {
		return selectSiteId;
	}

	public WebElement getCommunityName() {
		return communityName;
	}

	public WebElement getDistrict() {
		return district;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getLifePumpId() {
		return lifePumpId;
	}

	public WebElement getReportedIssue() {
		return reportedIssue;
	}

	public WebElement getCareTakerName() {
		return careTakerName;
	}

	public WebElement getCareTakerPhone() {
		return careTakerPhone;
	}

	public WebElement getWaterPointCommitteeName() {
		return waterPointCommitteeName;
	}

	public WebElement getWaterPointCommitteePhone() {
		return waterPointCommitteePhone;
	}

	public WebElement getDatePerformed() {
		return datePerformed;
	}

	public WebElement getNameOfPersonPerformingMaintenance() {
		return nameOfPersonPerformingMaintenance;
	}

	public WebElement getPrimaryReasonForVisitingPumpOption() {
		return primaryReasonForVisitingPumpOption;
	}
	

	public WebElement getPrimaryReasonForVisitingPumpRepairOption() {
		return primaryReasonForVisitingPumpRepairOption;
	}

	public WebElement getWasIssueReslovedYesOption() {
		return wasIssueReslovedYesOption;
	}

	public WebElement getWasIssueReslovedNoOption() {
		return wasIssueReslovedNoOption;
	}

	public WebElement getWaspumpfunctionaluponleavingsiteYesOption() {
		return waspumpfunctionaluponleavingsiteYesOption;
	}

	public WebElement getWaspumpfunctionaluponleavingsiteNoOption() {
		return waspumpfunctionaluponleavingsiteNoOption;
	}

	public WebElement getNewLifePumpLinkInstalledYesOption() {
		return newLifePumpLinkInstalledYesOption;
	}

	public WebElement getNewLifePumpLinkInstalledNoOption() {
		return newLifePumpLinkInstalledNoOption;
	}

	public WebElement getNewGearboxAssemblyNumber() {
		return newGearboxAssemblyNumber;
	}

	public WebElement getNewGearboxAssemblyNumber1() {
		return newGearboxAssemblyNumber1;
	}

	public WebElement getNewGearboxAssemblyNumberOtherField() {
		return newGearboxAssemblyNumberOtherField;
	}

	public WebElement getNewGearboxAssemblyNumberTextField() {
		return newGearboxAssemblyNumberTextField;
	}

	public WebElement getNewGearboxDateCode() {
		return newGearboxDateCode;
	}

	public WebElement getNewStatorSerialNumber() {
		return newStatorSerialNumber;
	}

	public WebElement getMaintenanceNotes() {
		return maintenanceNotes;
	}

	public WebElement getPreviousButton() {
		return previousButton;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getNonstandardhardwareinstalledYesOption() {
		return nonstandardhardwareinstalledYesOption;
	}

	public WebElement getNonstandardhardwareinstalledNoOption() {
		return nonstandardhardwareinstalledNoOption;
	}

	public WebElement getNonstandardhardwareinstalled() {
		return nonstandardhardwareinstalled;
	}

	public WebElement getPeakhandletorque() {
		return Peakhandletorque;
	}

	public WebElement getHandlerotation() {
		return Handlerotation;
	}

	public WebElement getIsgearboxSealLeakingYesOption() {
		return isgearboxSealLeakingYesOption;
	}

	public WebElement getIsgearboxSealLeakingNoOption() {
		return isgearboxSealLeakingNoOption;
	}

	public WebElement getOptionalNotes() {
		return optionalNotes;
	}

	public WebElement getVisualAssessment() {
		return visualAssessment;
	}

	public WebElement getPumpmaintenanceperiodOption1() {
		return PumpmaintenanceperiodOption1;
	}

	public WebElement getPumpMaintenancePeriodOption2() {
		return PumpMaintenancePeriodOption2;
	}

	public WebElement getLifePumpBenefitedYourCommunity() {
		return lifePumpBenefitedYourCommunity;
	}

	public WebElement getUnderstandWhatTheProblem() {
		return understandWhatTheProblem;
	}

	public WebElement getNameOfPersonBeingInterviewed() {
		return nameOfPersonBeingInterviewed;
	}

	public WebElement getAgeOfPerson() {
		return AgeOfPerson;
	}

	public WebElement getPhotoCheckList() {
		return photoCheckList;
	}

	public WebElement getSaveApproveButton() {
		return saveApproveButton;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	

	public WebElement getOkButton() {
		return okButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getUpdateReportPage() {
		return updateReportPage;
	}

	public WebElement getUpdateSuccessMessage() {
		return updateSuccessMessage;
	}

	public WebElement getReportCreatedSuccessMessage() {
		return reportCreatedSuccessMessage;
	}

	public WebElement getReportDeletedSuccessMessage() {
		return reportDeletedSuccessMessage;
	}
	
	
		
}
