package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base_class;

public class UserManagementPageLocators extends Base_class{
	
	
	public UserManagementPageLocators() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[text()='System Administration ']")
	private WebElement sytemAdministration;
	
	@FindBy(xpath = "//div[text()='User Administration ']")
	private WebElement userAdministration;
	
	@FindBy(xpath = "//a[text()='User Management']")
	private WebElement userManagement;
	
	public WebElement getUserManagementTitleName() {
		return userManagementTitleName;
	}

	@FindBy(xpath = "//div[text()='User Management']")
	private WebElement userManagementTitleName;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement addUserButton;
	
	@FindBy(xpath = "//label[text()='Title']")
	private WebElement title;
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "userContact")
	private WebElement contactNumber;
	
	@FindBy(id = "userEmail")
	private WebElement emailAddress;
	
	@FindBy(id = "userPassword")
	private WebElement password;
	
	@FindBy(id = "userConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[2]")
	private WebElement passwordMaskIcon;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[3]")
	private WebElement confirmPasswordMaskIcon;

	@FindBy(xpath = "//div[@aria-labelledby='userType']")
	private WebElement userRole;
	
	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement userRolePrivilege;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement radioButton;

	@FindBy(xpath = "(//div[@role='button'])[3]")
	private WebElement partnerNameDropdown;
	
	@FindBy(xpath = "//li[text()='1QA Tester']")
	private WebElement selectPartnerName;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[1]")
	private WebElement addUserDialogPageCancelButton;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement emailIdAlreadyExists;
	
	//This is for delete icon button xpath
	//(//*[local-name()='svg'and @class='MuiSvgIcon-root'])[4]
	
	public WebElement getSytemAdministration() {
		return sytemAdministration;
	}

	public WebElement getUserAdministration() {
		return userAdministration;
	}

	public WebElement getUserManagement() {
		return userManagement;
	}

	public WebElement getAddUserButton() {
		return addUserButton;
	}

	public WebElement getUserTitle() {
		return title;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getContactNumber() {
		return contactNumber;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getPasswordMaskIcon() {
		return passwordMaskIcon;
	}

	public WebElement getConfirmPasswordMaskIcon() {
		return confirmPasswordMaskIcon;
	}

	public WebElement getUserRole() {
		return userRole;
	}

	public WebElement getUserRolePrivilege() {
		return userRolePrivilege;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getPartnerNameDropdown() {
		return partnerNameDropdown;
	}

	public WebElement getSelectPartnerName() {
		return selectPartnerName;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAddUserDialogPageCancelButton() {
		return addUserDialogPageCancelButton;
	}

	public WebElement getEmailIdAlreadyExists() {
		return emailIdAlreadyExists;
	}

	
}
