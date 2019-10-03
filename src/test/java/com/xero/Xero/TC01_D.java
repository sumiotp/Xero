package com.xero.Xero;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC01_D extends getCommonDetails {

	public static void main(String[] args) {

		try {
			forgotPassword();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void forgotPassword() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		login();
		getTestData();
		getCredentials();
		takeSnapShot("TC01_D");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC01_D");
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
			WebElement forgotPwdBtn = driver.findElement(By.linkText("Forgot your password?"));
			click(forgotPwdBtn, "Forgot password ");
			WebElement Uname = driver.findElement(By.id("UserName"));
			enterText(Uname, username, "UserName");
			WebElement sendLink = driver.findElement(By.xpath("//span[@class='text']"));
			click(sendLink, "Login ");
			WebElement passwordResetMsg = driver
					.findElement(By.xpath("//p[contains(text(),'A link to reset your password has been sent to')]"));
			System.out.println("text>>>" + passwordResetMsg.getText());
			String s = passwordResetMsg.getText();
			//Assert.assertEquals(s, objProp.getProperty("Password_Reset_Msg") +Keys.chord(Keys.ENTER) + username);

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
