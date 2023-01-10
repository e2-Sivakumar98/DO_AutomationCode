package Execution;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;
import Locators.*;
public class SuccessfullLogin extends Base_class {

	public SuccessfullLogin() {
		PageFactory.initElements(driver, this);
	}	

	@BeforeSuite
	private void browserlaunch() throws Exception {
		RequestedBrowserWillBelaunch("chrome");
		RequestedUrlwillBeLaunch("https://testdo.bridgetreedcc.com/bt-do/landing/login");
	}
	
	@Test(description="Here the user will login with their valid credentials and Dashboard page should be displayed.")
	public void UserShouldloginSuccessfully() throws Exception {
		
		Thread.sleep(3000);
		String userEmailAddress = getDataFromExcel("SuccessfullLoginCredentials",1,0); 
		String userPassword = getDataFromExcel("SuccessfullLoginCredentials",1,1); 
		String dashboardPageUrl = "https://testdo.bridgetreedcc.com/bt-do/home/pump-view";
		
		LoginPageLocators htmlElmentLocator = new LoginPageLocators();
		
		sendkeys(htmlElmentLocator.getEmailTextBox(),userEmailAddress);
		sendkeys(htmlElmentLocator.getPasswordTextBox(), userPassword);
		
		normalClick(htmlElmentLocator.getLoginButton());
		
		Thread.sleep(8000);
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals(currentUrl,dashboardPageUrl);
		
		
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
	
}
