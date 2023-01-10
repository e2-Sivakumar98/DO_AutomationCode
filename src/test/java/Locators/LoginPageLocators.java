package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base_class;

public class LoginPageLocators extends Base_class{
	public LoginPageLocators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='login-title']")
	private WebElement loginTitleName;
	
	@FindBy(xpath = "//span[text()='Forgot Password']")
	private WebElement forgotPasswordTitleName;
	
	@FindBy(id = "email")
	private WebElement email1TextBox;

	@FindBy(id = "password")
	private WebElement passwordTexBox;
	
    @FindBy(id="email-helper-text")
    private WebElement enterValidEmailAddress;
    
	@FindBy(xpath = "//div[@class='flexAlignCenterJustifyCenter response error']")
	private WebElement userDoesnotExistErrorMessage;
	
	@FindBy(xpath = "//div[@class='flexAlignCenterJustifyCenter response error']")
	private WebElement inValidPassword;
	
	@FindBy(xpath = "//div[@class='flexAlignCenterJustifyCenter response success']")
	private WebElement mailSentSuccessMessage;
	
	@FindBy(id="password-helper-text")
	private WebElement minimumSixCharactersRequired;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Forgot Password?']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement cancelButton;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
	private WebElement ShowPasswordEyeIcon;
	
	public WebElement getLoginTitleName() {
		return loginTitleName;
	}
	public WebElement getforgotPasswordTitleName() {
		return forgotPasswordTitleName;
	}

	public WebElement getEmailTextBox() {
		return email1TextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTexBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getValidEmailAddressErrorMessage() {
		return enterValidEmailAddress;
	}
	public WebElement getInvalidPasswordsErrorMessage() {
		return  inValidPassword;
	}
	
	public WebElement getuserDoesnotExistErrorMessage() {
		return userDoesnotExistErrorMessage;
	}
	
	public WebElement getmailSentSuccessMessage() {

		return mailSentSuccessMessage;
	}
	
	public WebElement getMiniumSixCharactersRequiredErrorMessage() {
		return minimumSixCharactersRequired;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getShowPasswordEyeIcon() {
		return ShowPasswordEyeIcon;
	}
	
	public WebElement getForgotPasswordPageLink() {
		return forgotPassword;
	}

}
