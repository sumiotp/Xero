package com.xero.Xero;

import org.testng.annotations.Test;

public class XeroScriptsTest {

	@Test(priority = 0)
	public void TC01_A() throws Exception {
		TC01_A.navigateToZero();
	}

	@Test(priority = 1)
	public void TC01_B() throws Exception {
		TC01_B.incorrectPassword();
	}

	@Test(priority = 2)
	public void TC01_C() throws Exception {
		TC01_C.incorrectEmail();
	}

	@Test(priority = 3)
	public void TC01_D() throws Exception {
		TC01_D.forgotPassword();
	}

	@Test(priority = 4)
	public void TC02_A() throws Exception {

		TC02_A.getTrialVersion();
	}

	@Test(priority = 5)
	public void TC02_B() throws Exception {
		TC02_B.validateTrialVersion();
	}

	@Test(priority = 6)
	public void TC02_C() throws Exception {
		TC02_C.testTermsOFUSe();
	}

	@Test(priority = 7)
	public void TC02_D() throws Exception {
		TC02_D.getFullOffer();
	}

	@Test(priority = 8)
	public void TC02_E() throws Exception {
		TC02_E.testbookKeeperDetails();
	}

	@Test(priority = 9)
	public void TC03_A() throws Exception {
		TC03_A.testAllTabs();
	}

	@Test(priority = 10)
	public void TC04_A() throws Exception {
		TC04_A.testLogOut();
	}

	@Test(priority = 11)
	public void TC06_A() throws Exception {
		TC06_A.validateProfileSettings();
	}

	//@Test(priority = 12)
	public void TC08_A() throws Exception {
		TC08_A.addOrganisation();
	}

	@Test(priority = 13)
	public void TC10_A() throws Exception {
		TC10_A.validateSubscriptionBilling();
	}

}
