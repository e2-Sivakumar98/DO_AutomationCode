package Locators;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.Base_class;

public class LocatorsofDashboardListViewPage extends Base_class {
	public LocatorsofDashboardListViewPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@title='List View'])[1]")
	private WebElement listview;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
	private WebElement cancelbutton;

	public WebElement getlist() {
		return listview;
	}

	public WebElement getcancelbutton() {
		return cancelbutton;
	}
	
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
	@Test
	public void siteusage() throws Exception {

		implicitWait(15);
		// Thread.sleep(10000);
	//	WebdriverWaitClickable(getlist());
		normalClick(getlist());
		WebElement PageListout = driver.findElement(
				By.xpath("//div[@class='MuiInputBase-root MuiTablePagination-input MuiTablePagination-selectRoot']"));
		PageListout.click();

		WebElement p100page = driver.findElement(By.xpath("//li[text()='100']"));
		p100page.click();

		Thread.sleep(6000);
	
		List<WebElement> redalert = driver.findElements(By.xpath("//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-error']"));
		List<WebElement> yellowalert = driver.findElements(By.xpath("//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-warning']"));
		List<WebElement> orangealert = driver.findElements(By.xpath("//*[local-name()='svg'and @class='MuiSvgIcon-root indication-color-orange']"));
		Thread.sleep(2000);
		List<WebElement> cancelbutton = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root']"));
		Thread.sleep(6000);
		List<WebElement> usagebutton = driver.findElements(By.xpath("//*[local-name()='svg'and @class='MuiSvgIcon-root']"));

		for (int i = 9; i < redalert.size(); i++) {
			try {
				redalert.get(i).click();
				Thread.sleep(2000);
				normalClick(getcancelbutton());
				for (int j = 9; j<usagebutton.size();j++) {
					usagebutton.get(i).click();
					Thread.sleep(3000);
					normalClick(getcancelbutton());

				}

			}
			catch(Exception e) {
				System.out.println("Not treasable");
			}
		}
	}

}
