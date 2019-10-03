package com.xero.Xero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class getCommonDetails {

	static WebDriver driver;
	static Properties objProp = new Properties();
	static String[][] data;
	static String[][] signInData;
	static String URL;
	static ExtentReports report;
	static ExtentTest logger;
	static String fileWithPath = "D:\\Sumi\\Development\\SeleniumTraining\\Xero\\screenshots\\Xero_";

	/*
	 * Name of the method: initialize_driver BriefDescription : browser
	 * intialization Created date :09/20/19 LastModified Date:09/20/19
	 */

	public static void initialize_driver() {
		try {
			getPoperties();

			String strBrowser = objProp.getProperty("Browser");

			if (strBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\Sumi\\jars\\new jars\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (strBrowser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver",
						"D:\\Sumi\\Development\\jar downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (strBrowser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "D:\\Sumi\\jars\\chromedriver_win32\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			}
			System.out.println("driver>>>" + driver);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	/*
	 * Name of the method: getPoperties BriefDescription : Getting value from
	 * properties intialization Created date :09/20/19 LastModified Date:09/20/19
	 */

	public static void getPoperties() throws IOException {
		FileInputStream objStreaam;
		try {
			objStreaam = new FileInputStream(
					"D:\\Sumi\\Development\\SeleniumTraining\\Xero\\properties\\Repository.properties");
			objProp.load(objStreaam);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * name of the method: getURL BriefDescription : Launch browser Created date
	 * :09/20/19 LastModified Date:09/20/19
	 */
	public static void getURL() {
		try {
			driver.get(objProp.getProperty("URL"));
			URL = objProp.getProperty("URL");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * name of the method: geTestData BriefDescription : Getting username and
	 * password created date :09/20/19 LastModified Date:09/20/19
	 */
	public static String[][] getTestData() {

		try {
			ReadXL r = new ReadXL();
			data = r.readXlData(objProp.getProperty("EXCEL_PATH"), objProp.getProperty("SHEET_NAME"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public static void enterText(WebElement obj, String textval, String objName) throws InterruptedException

	{
		if (obj.isDisplayed() && obj != null) {
			Thread.sleep(4000);
			obj.clear();
			obj.sendKeys(textval);
			logger.log(LogStatus.INFO, textval + " value is entered in " + objName + " field");

		} else {

			logger.log(LogStatus.ERROR, textval + " field does not exist please check application ");

		}
	}

	public static void click(WebElement obj, String objName) {
		if (obj.isDisplayed()) {
			obj.click();
			logger.log(LogStatus.INFO, objName + " button is clicked ");

		} else {

			logger.log(LogStatus.ERROR, objName + " button is not displayed ,please check the application\"");

		}

	}

	public static void checkMe(WebElement chBox) throws InterruptedException {
		if (!chBox.isSelected()) {
			Thread.sleep(3000);
			chBox.click();
			logger.log(LogStatus.INFO, chBox + " is selected  ");
		} else {
			logger.log(LogStatus.ERROR, "Unable to select the object ,please check appliaction ");
		}
	}

	public static void getText(WebElement element) throws InterruptedException {

		if (element != null) {
			String message = element.getText();
			System.out.println("Text is ::" + message);
			logger.log(LogStatus.INFO, "getText is" + message);
		} else
			logger.log(LogStatus.ERROR, "Unable to get Text ,Please check the Webelement");
	}

	public static void compareTwoStrings(String str1, String str2) throws InterruptedException {
		if (str1 != null && str2 != null) {
			if (str1.equalsIgnoreCase(str2)) {
				logger.log(LogStatus.INFO, "Both string match ");
			} else {
				logger.log(LogStatus.ERROR, "Both string do not  match");
			}

		}

	}

	public static void switchToFrame(WebElement element) throws InterruptedException {

		if (element != null) {
			driver.switchTo().frame(element);
			driver.switchTo().activeElement();
			logger.log(LogStatus.INFO, "Successfully switched to frame ");
		} else {
			logger.log(LogStatus.ERROR, "Unable to switch to frame");
		}
	}

	public static void selectByVisibleText(WebElement element, String visibleText) throws InterruptedException {

		if (element != null) {

			Select s = new Select(element);
			s.selectByVisibleText(visibleText);
			logger.log(LogStatus.INFO, "Text selected successfully is  " + visibleText);
		}
	}

	public static void InitializeExtentReport() {
		String fileName = new SimpleDateFormat("'Xero_'yyyyMMddHHmm'.html'").format(new Date());
		String path = "D:\\Sumi\\Development\\SeleniumTraining\\Xero\\reports\\XeroReport\\" + fileName;
		report = new ExtentReports(path);
	}

	public static void CloseTestCase() {
		report.endTest(logger);
		driver.quit();
		report.flush();
	}

	public static void takeSnapShot(String methodNAme) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath + methodNAme + ".jpeg");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}
}
