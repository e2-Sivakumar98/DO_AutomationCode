package Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest testcase;
	public static ExtentTest log;
	public static ExtentTest extentTest;

	public static final CellType STRING = null;
	public static final CellType NUMERIC = null;

	public static WebDriver driver;
	
	

	// Browser Launch

	public static void RequestedBrowserWillBelaunch(String s) {
		
//		ChromeOptions load = new ChromeOptions();
//		load.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		switch (s) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			break;
		}

	}

	
	
	
	// URL Launch
	public static void RequestedUrlwillBeLaunch(String url) {
		driver.get(url);
	}

	public static boolean normalClick1(WebElement element) {
		element.click();
		return false;
	}

	// click
	public static void normalClick(WebElement element) {
		element.click();
	}

	// Sendkeys
	public static void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	// LocatorByID
	public static WebElement findElementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	// LocatorByName
	public static WebElement findlocatorByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	// LocatorbyXpath
	public static WebElement findElementByXpath(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		return element;
	}

	// LocatorByclassName
	public static WebElement findElementByClassName(String attribute) {
		WebElement element = driver.findElement(By.className(attribute));
		return element;
	}

	// Get Text
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// GetAttribute -type1
	public static String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	// GetAttribute -Type2
	public static String getAttribute(WebElement element, String string) {
		String text = element.getAttribute(string);
		return text;
	}

	// GetTitle
	public static String getTitle() {
		String text = driver.getTitle();
		return text;
	}

	// SelectOptionByText
	public static void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// SelectoptionByIndex
	public static void selectOptionByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// SelectOptionByAttributeValue
	public static void selectOptionByAttributeValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	// TyPE JS
	public static void typeJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value'," + text + "')", element);
	}

	// Navigate
	public static void navigate(String url) {
		driver.navigate().to(url);
	}

	// forward-Navigate
	public static void forward() {
		driver.navigate().forward();
	}

	// Back-Navigate
	public static void back() {
		driver.navigate().back();
	}

	// Refresh-Navigate
	public static void refresh() {
		driver.navigate().refresh();
	}

	// Maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// FullScreen
	public static void fullscreen() {
		driver.manage().window().fullscreen();
	}

	// MouseOverAction-movetothe element
	public static void moveToTheElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// dragAndDrop
	public static void drapAndDrop(WebElement element, WebElement element2) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element2);
	}

	// DoubleClick
	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();;
	}

	// Context Click
	public static void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// KEY UP
	public static void keyUp(String key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key);
	}

	// Click ok
	public static void accept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Confirm Alert
	public static void dismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// PromptAlert
	public static void promptAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	// ScreenShot-Syntax
	public static void getScreenshot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File Destination = new File(path);
		FileUtils.copyFile(source, Destination);

	}

	// ScreenShot-Custom
	public String ScreenshotPath() throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// String path = System.getProperty("user.dir") + "/Screenshots/" +
		// System.currentTimeMillis() + ".png";
		String path = "./Reports/Screenshots/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}

	// Js Click
	public static void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	// ScrollDown
	public static void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

	// ScrollDown
	public static void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	// DropDown-getoptions
	public static List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		return list;
	}

	// allselectedoption
	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> list = select.getAllSelectedOptions();
		return list;
	}

	// firstselectedoption
	public static WebElement getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	// is Multiple
	public static boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// deselectbyindex
	public static void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// deselectbyVisibletext
	public static void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// deselectall
	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// deselectbyvalue
	public static void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// Framebyid
	public static void frameId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// FrameElement
	public void frameElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	// FrameIndex
	public void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	// parentframe
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	// WindowsHandle-parent
	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	// WindowsHandle-parent,child
	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	// Webdriver Wait
	public boolean waitForElementToBeClickableBool(WebDriver driver, WebElement webElement, long duration) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, duration).ignoring(Exception.class)
					.until(ExpectedConditions.elementToBeClickable(webElement));
			flag = true;
			return flag;

		} catch (Exception Ex) {
			return flag;
		}
	}

	public static void WebdriverWaitVisible(WebElement element) throws Exception {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public static void WebdriverWaitClickable(WebElement element) throws Exception {
		WebDriverWait w = new WebDriverWait(driver, 120);
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Fluent Wait

	// Robot Escape
	public void robotEsc() throws Exception {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

	}

	// excelSheet
	public static String getdata(String filepath, String SheetName, int rownum, int cellnum) throws IOException {
		String res = null;
		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
				res = dateformat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				// int num = (int)Math.round(d);
				// BigDecimal num = BigDecimal.valueOf(d);
				// res = num.toString();
				int integer = (int) Math.round(d);
				res = Integer.toString(integer);

			}
		default:
			break;
		}
		return res;

	}

	public static void UpdateData(String filepath, String sheetname, int rownum, int cellnum, String olddata,
			String newdata) throws IOException {
		String res = null;
		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		res = cell.getStringCellValue();
		if (res.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	public static void WriteData(String filepath, String sheetname, int rownum, int cellnum, String value)
			throws IOException {
		String res = null;
		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	public static String properties(String filepath, String s) throws Exception {

		Properties p = new Properties();
		FileReader reader = new FileReader(filepath);
		p.load(reader);
		String string = p.get(s).toString();
		return string;

	}

	public void currentUrl() {
		driver.getCurrentUrl();
	}

	// excelSheet
	public static String getdataforNoOfInputs(String filepath, String SheetName, int rowstart, int cellstart, int rowend,
			int cellend) throws Exception {
		String res = null;
		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);

		for (int i = rowstart; i <= rowend; i++) {
			Row row = sheet.getRow(i);
			System.out.println(i);

			for (int j = cellstart; j <= cellend; j++) {

				Cell cell = row.getCell(j);
				System.out.println(j);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					res = cell.getStringCellValue();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
						res = dateformat.format(dateCellValue);
					} else {
						double d = cell.getNumericCellValue();
						BigDecimal num = BigDecimal.valueOf(d);
						res = num.toString();
					}
				default:
					break;
				}
			}
		}
		return res;

	}

	public static void robotDelete() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
	}

	public static void robotTabEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static String getDataFromExcel(String SheetName, int rownum, int cellnum) throws IOException {
		String path = System.getProperty("user.dir") + "/target/bt_DO_DB.xlsx";
		String res = null;
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(SheetName);
		XSSFRow row = sheet.getRow(rownum);

		DataFormatter dataFormatter = new DataFormatter();
		res = dataFormatter.formatCellValue(row.getCell(cellnum));
		workbook.close();
		return res;
		
	}

	public static void selectAll() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void copy() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent. VK_COPY);
	}
	public static String paste() throws AWTException {
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent. VK_PASTE);

		return null;
	}

}
