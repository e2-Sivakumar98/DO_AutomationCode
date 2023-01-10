package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base_class;

public class PartnerAdministrationPageLocators extends Base_class {
	
	public PartnerAdministrationPageLocators() {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Partner Administration']")
	private WebElement partnerAdministration;
	
	@FindBy(xpath = "//div[text()='Partner Administration']")
	private WebElement partnerAdministrationTitle;	
	
	@FindBy(id = "agencyName")
	private WebElement partnerBusinessName;
	
	@FindBy(id = "agencyAddress1")
	private WebElement addressLine1;
	
	@FindBy(id = "agencyAddress2")
	private WebElement addressLine2;
	
	@FindBy(id = "agencyCity")
	private WebElement city;
	
	@FindBy(id = "agencyState")
	private WebElement state;
	
	@FindBy(id = "agencyCountry")
	private WebElement country;
	
	@FindBy(id = "agencyZipcode")
	private WebElement pinCode;
	
	@FindBy(id = "aagencyFirstName")
	private WebElement fName;
	
	@FindBy(id = "agencyLastName")
	private WebElement lName;
	@FindBy(id = "agencyName")
	private WebElement Name;
	
	@FindBy(id = "agencyContactNumber")
	private WebElement contactNumber;
	
	@FindBy(id = "agencyContactEmail")
	private WebElement emailAdress;
	
	@FindBy(id = "agencyContactPassword")
	private WebElement password;
	@FindBy(id = "agencyContactConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id = "(//button[@type='button'])[6]")
	private WebElement passwordMaskIcon;
	
	public WebElement getPartnerAdministration() {
		return partnerAdministration;
	}

	public WebElement getPartnerAdministrationTitle() {
		return partnerAdministrationTitle;
	}

	public WebElement getPartnerBusinessName() {
		return partnerBusinessName;
	}

	public WebElement getAddressLine1() {
		return addressLine1;
	}

	public WebElement getAddressLine2() {
		return addressLine2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getPinCode() {
		return pinCode;
	}

	public WebElement getfName() {
		return fName;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getContactNumber() {
		return contactNumber;
	}

	public WebElement getEmailAdress() {
		return emailAdress;
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

}
