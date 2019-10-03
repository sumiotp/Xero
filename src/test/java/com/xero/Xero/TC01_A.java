package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC01_A extends getCommonDetails {

	public static void navigateToZero() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTestData();
		login();
		getCredentials();
		takeSnapShot("TC01_A");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC01_A");
			try {

				WebElement loginBtn = driver.findElement(By.linkText("Login"));
				click(loginBtn, "Login ");
			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

	public static void getCredentials() {

		try {
			String username = data[1][1];
			String password = data[1][2];
			System.out.println("password>>>>>>>>>>>>" + password);
			WebElement Uname = driver.findElement(By.id("email"));
			enterText(Uname, username, "UserName");
			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, password, "Password");
			WebElement loginBtn = driver.findElement(By.id("submitButton"));
			click(loginBtn, "Login ");
			WebElement s = driver.findElement(
					By.xpath("//div[@class='xui-page-title xdash-setupwidget__setup--header-title___1obD5']"));
			System.out.println("text>>>" + s.getText());
			Assert.assertEquals(s.getText(), objProp.getProperty("XERO_HOME_TEXT"));

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
