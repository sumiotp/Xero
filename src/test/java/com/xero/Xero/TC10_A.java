package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC10_A extends getCommonDetails {

	public static void validateSubscriptionBilling() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTestData();
		login();
		getSubscriptionAndBilling();
		takeSnapShot("TC10_A");
		CloseTestCase();
		

	}

	private static void login() {
		{
			logger = report.startTest("TC10_A");
			try {

				WebElement loginBtn = driver.findElement(By.linkText("Login"));
				click(loginBtn, "Login ");
			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

	public static void getSubscriptionAndBilling() {

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


		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
