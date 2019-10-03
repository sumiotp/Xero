package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC03_A extends getCommonDetails {

	public static void main(String[] args) {

		try {
			testAllTabs();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void testAllTabs() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		login();
		getTestData();
		getCredentials();
		takeSnapShot("TC03_A");
		CloseTestCase();

	}

	private static void login() {
		{
			logger = report.startTest("TC03_A");
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
			// System.out.println("password>>>>>>>>>>>>" + password);
			WebElement Uname = driver.findElement(By.id("email"));
			enterText(Uname, username, "UserName");
			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, password, "Password");
			WebElement loginBtn = driver.findElement(By.id("submitButton"));
			click(loginBtn, "Login ");
			WebElement s = driver.findElement(
					By.xpath("//div[@class='xui-page-title xdash-setupwidget__setup--header-title___1obD5']"));
			Assert.assertEquals(s.getText(), objProp.getProperty("XERO_HOME_TEXT"));
			Thread.sleep(2000);
			// Dashboard
			WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
			click(dashboard, "dashboard ");

			// Accounting
			WebElement accountBtn = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
			click(accountBtn, "Accounting tab ");

			WebElement accountDropdwn = driver.findElement(By.xpath(
					"//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']"));
			Assert.assertTrue(accountDropdwn.isDisplayed());

			// Reports
			WebElement reportsBtn = driver.findElement(By.xpath("//a[contains(text(),'Reports')]"));
			click(reportsBtn, "Reports tab ");

			Thread.sleep(2000);
			// Contacts
			WebElement contactsBtn = driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
			click(contactsBtn, "Contacts tab ");

			Thread.sleep(2000);
			// Settings
			WebElement dropDwn = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
			click(dropDwn, "drop down tab ");

			WebElement settingsLink = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
			click(settingsLink, "Settings Link ");
			Thread.sleep(2000);

			// Create New
			WebElement createNewBtn = driver.findElement(By.xpath("//li[1]//button[1]//div[1]"));
			click(createNewBtn, "Create New Icon ");

			WebElement createNewDropDwn = driver.findElement(By.xpath(
					"//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']"));
			Assert.assertTrue(createNewDropDwn.isDisplayed());
			Thread.sleep(2000);
			// Files
			WebElement files = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']"));
			click(files, "files tab ");

			WebElement FilesLink = driver.findElement(By.xpath("//a[contains(text(),'Files')]"));
			click(FilesLink, "Files Link ");
			Thread.sleep(2000);

			// Search Icon
			WebElement searchBtn = driver.findElement(By.xpath(
					"//li[@class='xrh-addon xrh-addon-alwaysvisible']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			click(searchBtn, "Search Link ");
			Thread.sleep(2000);

			//WebElement searchArea = driver.findElement(By.cssSelector("#queryInput"));
			//Assert.assertTrue(searchArea.isDisplayed());
			Thread.sleep(2000);
			// Help
			WebElement helpIcon = driver.findElement(By.xpath(
					"//li[4]//button[1]//div[1]"));
			click(helpIcon, "Help Icon	 ");
			WebElement helpList = driver.findElement(By.xpath("//input[@id='menu_help']"));
			System.out.println("help:::"+helpList.getText());

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
