package com.xero.Xero;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class TC02_D extends getCommonDetails {

	
	public static void getFullOffer() throws Exception

	{
		initialize_driver();
		InitializeExtentReport();
		getURL();
		getFullOfferDetails();
		takeSnapShot("TC02_D");
		CloseTestCase();

	}

	private static void getFullOfferDetails() {
		logger = report.startTest("TC02_D");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);

			WebElement fullOfferDetails = driver
					.findElement(By.xpath("//a[contains(text(),'See full offer details')]"));
			fullOfferDetails.click();

			WebElement checkTitle = driver.findElement(By.xpath("//h2[@class='title title-2']"));
			Assert.assertTrue(checkTitle.isDisplayed());

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void getCredentials() {

	}
}
