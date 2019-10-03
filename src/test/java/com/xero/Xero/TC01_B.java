package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC01_B extends getCommonDetails {
	

	public static void incorrectPassword() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		login();
		getTestData();
		getCredentials();
		takeSnapShot("TC01_B");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC01_B");
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
			String password = objProp.getProperty("INCORRECT_PASSWORD");
			System.out.println("password>>>>>>>>>>>>" + password);
			WebElement Uname = driver.findElement(By.id("email"));
			enterText(Uname, username, "UserName");
			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, password, "Password");
			WebElement loginBtn = driver.findElement(By.id("submitButton"));
			click(loginBtn, "Login ");
			WebElement errorText = driver
					.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
			System.out.println("text>>>" + errorText.getText());
			Assert.assertEquals(errorText.getText(), objProp.getProperty("ERROR_TEXT"));

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
