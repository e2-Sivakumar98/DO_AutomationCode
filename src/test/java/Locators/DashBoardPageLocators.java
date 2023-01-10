package Locators;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Base.Base_class;

public class DashBoardPageLocators extends Base_class {
	
	public DashBoardPageLocators() {

		PageFactory.initElements(driver, this);
	}

	public WebElement getPageExtendButton() {
		return pageExtendButton;
	}

	public WebElement getExtentPageTO100() {
		return extentPageTO100;
	}


	public WebElement getMenuButton() {
		return MenuButton;
	}

	public List<WebElement> getUsageDetailButton() {
		return usageDetailButton;
	}

	public List<WebElement> getRedAlertIconButton() {
		return redAlertIconButton;
	}

	@FindBy(xpath = "//div[@class='app-logo']")
	private WebElement dashBoardLogoName;

	@FindBy(xpath = "//div[@class='MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault']")
	private WebElement userProfileIconButton;

	@FindBy(xpath = "(//li[@role='menuitem'])[2]")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='gm-style']")
	private WebElement dashboardMapView;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement DashboardText;


	@FindBy(xpath = "(//div[@id='select'])[1]")
	//@FindBy(xpath = "(//span[text()='All Partners '])[1]")
//	@FindBy(xpath = "(//div[@class='select-native-material partner-select-dashboard bg-color flexAlignCenterJustifyCenter'])[1]")
	private WebElement allPartnersDropDownButton;

	@FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[4]")
	private WebElement selectPartnerByIndex;

	@FindBy(xpath = "(//div[@class='select-native-material partner-select-dashboard flexAlignCenterJustifyCenter cursor-pointer'])[1]")
	private WebElement unassignedLPLinksButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchField;

	@FindBy(xpath = "//span[@title='Map View']")
	private WebElement mapViewButton;

	@FindBy(xpath = "(//div[@class='MuiPaper-root MuiMenu-paper MuiPopover-paper MuiPaper-elevation8 MuiPaper-rounded'])[2]")
	private WebElement allPartnerListButton;

	@FindBy(xpath = "//button[@title='Zoom in']")
	private WebElement zoomInButton;

	@FindBy(xpath = "//button[@title='Zoom out']")
	private WebElement zoomOutButton;

	@FindBy(xpath = "(//span[@title='List View'])[1]")
	private WebElement dashboardListViewButton;

	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[7]")
	private WebElement selectedPartnerSite;

	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[1]")
	private WebElement searchingSiteByName;

	// Site Status Locators

	@FindBy(xpath = "//div[@class='battery-color-indication indication-success']")
	private WebElement BatteryGreenColor;
	@FindBy(xpath = "//div[@class='battery-color-indication indication-battery-life-color-orange']")
	private WebElement BatteryOrangeColor;

	@FindBy(xpath = "//div[@class='life-pump-color-indication indication-error']")
	private WebElement lifePumpUsageStatusRedColor;
	

	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-error']")
	private List<WebElement> redAlertIconButton;
	
	
	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[402]")
	private WebElement redAlertIconStatus;
			
			
	public WebElement getRedAlertIconStatus() {
		return redAlertIconStatus;
	}
	
	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[402]")
	private WebElement yellowAlertIconStatus;

	
	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[404]")
	private WebElement orangeAlertIconStatus;
	
	@FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[402]")
	private WebElement greyAlertIconStatus;
	
	public WebElement getYellowAlertIconStatus() {
		return yellowAlertIconStatus;
	}

	public WebElement getOrangeAlertIconStatus() {
		return orangeAlertIconStatus;
	}

	public WebElement getGreyAlertIconStatus() {
		return greyAlertIconStatus;
	}

	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-warning']")
	private List<WebElement> yellowAlertIconButton;
	
	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-orange']")
	private List<WebElement> orangeAlertIconButton;
	
	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-success']")
	private List<WebElement> greenlertIconButton;
	
	public List<WebElement> getYellowAlertIconButton() {
		return yellowAlertIconButton;
	}

	public List<WebElement> getOrangeAlertIconButton() {
		return orangeAlertIconButton;
	}

	public List<WebElement> getGreenlertIconButton() {
		return greenlertIconButton;
	}

	@FindBy(xpath = "//div[@class='life-pump-color-indication indication-warning']")
	private WebElement lifePumpUsageStatusYellowColor;

	@FindBy(xpath = "//div[@class='life-pump-color-indication indication-success']")
	private WebElement lifePumpUsageStatusGreenColor;

	@FindBy(xpath = "//div[@class='flexAlignCenterJustifyStart']")
	private WebElement lifePumpUsageAlertStatus;

	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-error']/../../../following-sibling::td/span/span//*[local-name()='svg'and @class='MuiSvgIcon-root']")
	private List<WebElement> usageDetailButton;
	
	@FindBy(xpath = "//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-warning']/../../../following-sibling::td/span/span//*[local-name()='svg'and @class='MuiSvgIcon-root']")
	private List<WebElement> yellowUsageDetails;

	public List<WebElement> getYellowUsageDetails() {
		return yellowUsageDetails;
	}

	@FindBy(xpath = "//div[text()='No data received yet']")
	private WebElement emptySite;
	
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl']")
	private WebElement selectDaysButton;
	
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> selectDay;
	
	
	public WebElement getSelectDaysButton() {
		return selectDaysButton;
	}

	public List<WebElement> getSelectDay() {
		return selectDay;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")
	private WebElement fromDate;
	
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")
	private WebElement toDate;
	
	
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiTablePagination-input MuiTablePagination-selectRoot']")
	private WebElement pageExtendButton;
	
	

	@FindBy(xpath = "//li[text()='100']")
	private WebElement extentPageTO100;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
	private WebElement cancelbutton;
	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement MenuButton;

	public WebElement getDashBoardLogoName() {
		return dashBoardLogoName;
	}

	public WebElement getUserProfileIconButton() {
		return userProfileIconButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getDashboardMapView() {
		return dashboardMapView;
	}

	public WebElement getDashboardText() {
		return DashboardText;
	}

	public WebElement getAllPartnersDropDownButton() {
		return allPartnersDropDownButton;
	}

	public WebElement getSelectPartnerByIndex() {
		return selectPartnerByIndex;
	}

	public WebElement getUnassignedLPLinksButton() {
		return unassignedLPLinksButton;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getMapViewButton() {
		return mapViewButton;
	}

	public WebElement getAllPartnerListButton() {
		return allPartnerListButton;
	}

	public WebElement getZoomInButton() {
		return zoomInButton;
	}

	public WebElement getZoomOutButton() {
		return zoomOutButton;
	}

	public WebElement getDashboardListViewButton() {
		return dashboardListViewButton;
	}

	public WebElement getSelectedPartnerSite() {
		return selectedPartnerSite;
	}

	public WebElement getSearchingSiteByName() {
		return searchingSiteByName;
	}

	public WebElement getdashBoardLogoName() {
		return dashBoardLogoName;
	}

	public WebElement getuserProfileIconButton() {
		return userProfileIconButton;
	}

	public WebElement getzoomInButton() {
		return zoomInButton;
	}

	public WebElement getzoomOutButton() {
		return zoomOutButton;
	}

	public WebElement getallPartnersDropDownButton() {
		return allPartnersDropDownButton;
	}

	public WebElement getunassignedLPLinksButton() {
		return unassignedLPLinksButton;
	}

	public WebElement getsearchField() {
		return searchField;
	}

	public WebElement getmapViewButton() {
		return mapViewButton;
	}

	public WebElement getallPartnerListButton() {
		return allPartnerListButton;
	}

	public WebElement getSelectedPartnerFromTheList() {
		return selectPartnerByIndex;
	}

	public WebElement getselectedPartnerSite() {
		return selectedPartnerSite;
	}

	public WebElement searchingSiteByName() {
		return searchingSiteByName;
	}

	public WebElement getBatteryGreenColor() {
		return BatteryGreenColor;
	}

	public WebElement getBatteryOrangeColor() {
		return BatteryOrangeColor;
	}

	public WebElement getLifePumpUsageStatusRedColor() {
		return lifePumpUsageStatusRedColor;
	}

	public WebElement getLifePumpUsageStatusYellowColor() {
		return lifePumpUsageStatusYellowColor;
	}

	public WebElement getLifePumpUsageStatusGreenColor() {
		return lifePumpUsageStatusGreenColor;
	}

	public WebElement getLifePumpUsageAlertStatus() {
		return lifePumpUsageAlertStatus;
	}

	public WebElement getEmptySite() {
		return emptySite;
	}

	public WebElement getextendPageTo100() {
		return extentPageTO100;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}

}
