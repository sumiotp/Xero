package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC02_E extends getCommonDetails {

	public static void main(String[] args) {

		try {
			testbookKeeperDetails();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void testbookKeeperDetails() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		bookKeeperDetails();
		takeSnapShot("TC02_E");
		CloseTestCase();

	}

	public static void bookKeeperDetails() {

		logger = report.startTest("TC02_E");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0,600)");
			
			Thread.sleep(2000);

			WebElement fullOfferDetails = driver
					.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
			fullOfferDetails.click();

			WebElement checkTitle = driver.findElement(By.xpath("//h2[contains(text(),'Xero partner program signup form')]"));
			Assert.assertTrue(checkTitle.isDisplayed());

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
