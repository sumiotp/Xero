package com.xero.Xero;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC02_B extends getCommonDetails {

	public static void main(String[] args) {

		try {
			validateTrialVersion();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void validateTrialVersion() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTrial();
		login();
		takeSnapShot("TC02_B");
		CloseTestCase();

	}

	private static void getTrial() {
		logger = report.startTest("TC02_B");
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
			try {

				driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();
				// error 1
				String strFnameEmpty =driver.findElement(By.id("signup-form-error-message-1")).getText();
				Assert.assertEquals(strFnameEmpty, objProp.get("ERROR1"));
				// error 2
				String strLnameEmpty =driver.findElement(By.id("signup-form-error-message-2")).getText();
				Assert.assertEquals(strLnameEmpty, objProp.get("ERROR2"));
				// error 3
				String strEmailEmpty =driver.findElement(By.id("signup-form-error-message-3")).getText();
				Assert.assertEquals(strEmailEmpty, objProp.get("ERROR3"));
				// error 4
				String strPhoneEmpty =driver.findElement(By.id("signup-form-error-message-4")).getText();
				Assert.assertEquals(strPhoneEmpty, objProp.get("ERROR4"));
				
				WebElement emailAdd = driver.findElement(By.name("EmailAddress"));
				enterText(emailAdd, "test", "UserName");
				
				String invalidEmail =driver.findElement(By.id("signup-form-error-message-3")).getText();
				Assert.assertEquals(invalidEmail, objProp.get("EMAIL_INVALID"));
				
				driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();

			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

}
