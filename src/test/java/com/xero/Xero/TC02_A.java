package com.xero.Xero;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC02_A extends getCommonDetails {

	public static void main(String[] args) {

		try {
			getTrialVersion();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void getTrialVersion() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTrial();
		login();
		takeSnapShot("TC02_A");
		//CloseTestCase();

	}

	private static void getTrial() {
		logger = report.startTest("TC02_A");
		try {
			Thread.sleep(2000);

			WebElement freetrialBtn = driver
					.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			freetrialBtn.click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	private static void login() {
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;

			try {
				String firstName = objProp.getProperty("fName");
				String lastName = objProp.getProperty("lName");
				String emailAddress = objProp.getProperty("emailAddress");
				String phoneNo = objProp.getProperty("phNo");

				WebElement fName = driver.findElement(By.name("FirstName"));
				enterText(fName, firstName, "UserName");

				WebElement lName = driver.findElement(By.name("LastName"));
				enterText(lName, lastName, "UserName");

				//js.executeScript("window.scrollBy(0,1000)");

				WebElement emailAdd = driver.findElement(By.name("EmailAddress"));
				enterText(emailAdd, emailAddress, "UserName");

				WebElement phNo = driver.findElement(By.name("PhoneNumber"));
				enterText(phNo, phoneNo, "UserName");

				WebElement locatCode = driver.findElement(By.name("LocationCode"));

				Select s = new Select(locatCode);
				s.selectByVisibleText("United States");
				
				List<WebElement> frames = driver.findElements(By.tagName("iframe"));
				String winHanaleBefore = driver.getWindowHandle();
				driver.switchTo().frame(0);
				driver.findElement(By.id("recaptcha-anchor")).click();
				driver.switchTo().window(winHanaleBefore);

			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

}
