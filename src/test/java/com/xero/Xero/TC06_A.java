package com.xero.Xero;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC06_A extends getCommonDetails {

	public static void main(String[] args) {

		try {
			validateProfileSettings();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void validateProfileSettings() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTestData();
		login();
		getProfileSettings();
		takeSnapShot("TC06_A");
		// CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC06_A");
			try {

				WebElement loginBtn = driver.findElement(By.linkText("Login"));
				click(loginBtn, "Login ");
			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

	public static void getProfileSettings() {

		try {
			String username = data[1][1];
			String password = data[1][2];

			WebElement Uname = driver.findElement(By.id("email"));
			enterText(Uname, username, "UserName");

			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, password, "Password");

			WebElement loginBtn = driver.findElement(By.id("submitButton"));
			click(loginBtn, "Login ");
			Thread.sleep(3000);

			WebElement profileBtn = driver.findElement(By.xpath(
					"//li[@class='xrh-addon xrh-addon-lastvisible']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			click(profileBtn, "Profile  ");

			WebElement profileSettings = driver
					.findElement(By.xpath("//span[@class='xrh-verticalmenuitem--subheading']"));
			click(profileSettings, "Profile Settings ");

			WebElement profilePhoto = driver.findElement(By.xpath("//a/span[contains(text(),'Upload Image')]"));

			boolean blnUpload = profilePhoto.isDisplayed();
			System.out.println("blnUpload>>>" + blnUpload);

			if (blnUpload) {

				click(profilePhoto, "Profile Photo ");
				Thread.sleep(3000);

				WebElement photoUpload = driver
						.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));

				String strPhotoLocation = objProp.getProperty("PHOTO_LOCATION");
				photoUpload.sendKeys(strPhotoLocation);

				WebElement upload = driver.findElement(By.xpath("//a[@id='button-1178-btnEl']"));
				click(upload, "Profile Photo ");
				Thread.sleep(3000);
			}

			WebElement save = driver.findElement(By.xpath("//a/span[contains(text(),'Save')]"));
			click(save, "save ");

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
