package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC01_C extends getCommonDetails {

	public static void incorrectEmail() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		login();
		getTestData();
		getCredentials();
		takeSnapShot("TC01_C");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC01_C");
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
			String username = objProp.getProperty("INCORRECT_EMAIL");
			String password = data[1][2];
			System.out.println("username>>>>>>>>>>>>" + username);
			WebElement Uname = driver.findElement(By.id("email"));
			enterText(Uname, username, "UserName");
			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, password, "Password");
			WebElement loginBtn = driver.findElement(By.id("submitButton"));
			click(loginBtn, "Login ");
			WebElement s = driver.findElement(
					By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
			System.out.println("text>>>"+s.getText());
			Assert.assertEquals(s.getText(),objProp.getProperty("ERROR_TEXT") );

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
