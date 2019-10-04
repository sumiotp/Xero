package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC08_A extends getCommonDetails {

	public static void addOrganisation() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTestData();
		login();
		addOrganisationDetails();
		takeSnapShot("TC08_A");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC08_A");
			try {

				WebElement loginBtn = driver.findElement(By.linkText("Login"));
				click(loginBtn, "Login ");
			} catch (Exception e) {
				e.printStackTrace();

				logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

			}

		}

	}

	public static void addOrganisationDetails() {

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

			WebElement dashboard = driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
			click(dashboard, "dashboard  ");

			WebElement addOrg = driver
					.findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"));

			boolean isAddOrgFound = addOrg.isDisplayed();

			if (isAddOrgFound) {

				click(addOrg, "addOrg  ");
				Thread.sleep(3000);

				WebElement name = driver
						.findElement(By.xpath("//input[@data-automationid='organisation-name--input']"));
				enterText(name, "Self", "NAme of Organisation");

				WebElement web = driver
						.findElement(By.xpath("//input[@data-automationid='timezone-autocompleter--input']"));
				Thread.sleep(2000);
				web.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				web.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(2000);
				web.sendKeys("Pacific Time", Keys.ARROW_DOWN, Keys.ENTER);

				WebElement orgDo = driver
						.findElement(By.xpath("//input[@data-automationid='industry-autocompleter--input']"));
				orgDo.sendKeys("Accounting", Keys.ARROW_DOWN, Keys.ENTER);

				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Select one from the list')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@class='xui-pickitem--text'][contains(text(),'Xero')]")).click();

				WebElement startTrial = driver.findElement(By.xpath(
						"//button[@class='xui-button xui-actions--primary xui-actions--button-spacing xui-button-main xui-button-medium']"));
				click(startTrial, "startTrial ");

				Thread.sleep(2000);

				WebElement OrgCheck = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
				Assert.assertEquals(OrgCheck.getText(), "Self");
			}

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
