package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC02_C extends getCommonDetails {

	public static void main(String[] args) {

		try {
			testTermsOFUSe();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void testTermsOFUSe() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getTrial();
		getTermsOfUse();
		takeSnapShot("TC02_C");
		CloseTestCase();

	}

	private static void getTrial() {
		logger = report.startTest("TC02_C");
		try {
			Thread.sleep(2000);

			WebElement freetrialBtn = driver
					.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
			freetrialBtn.click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void getTermsOfUse() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("window.scrollBy(0,500)");
			WebElement termsOfUSeLink = driver.findElement(By.linkText("Terms of Use"));
			termsOfUSeLink.click();

			WebElement privacyLink = driver.findElement(By.xpath("//a[contains(text(),'www.xero.com/privacy/')]"));
			privacyLink.click();

			WebElement checkTitle = driver.findElement(By.xpath("//h1[@class='title title-1']"));
			Assert.assertTrue(checkTitle.isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();

			logger.log(LogStatus.ERROR, "Error Occurred Check Trace" + e.getMessage());

		}

	}
}
