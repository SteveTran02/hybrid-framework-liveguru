package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.liveguru.user.UserAboutUsObject;
import pageObjects.liveguru.user.UserContactUsObject;
import pageObjects.liveguru.user.UserCustomerServiceObject;
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserPrivacyPolicyObject;

public class Topic_03_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserAboutUsObject userAboutUsPage;
	private UserContactUsObject userContactUsPage;
	private UserCustomerServiceObject userCustomerServicePage;
	private UserPrivacyPolicyObject userPrivacyPolicyPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void TC_01_Navigate_Page_In_Footer() {
		userAboutUsPage = (UserAboutUsObject) userHomePage.openPagesAtFooterByName(driver, "About Us");
		Assert.assertTrue(userAboutUsPage.isPageDisplayedByPageHeaderName(driver, "About Magento Store"));

		userContactUsPage = (UserContactUsObject) userAboutUsPage.openPagesAtFooterByName(driver, "Contact Us");
		Assert.assertTrue(userContactUsPage.isPageDisplayedByPageHeaderName(driver, "Contact Us"));

		userCustomerServicePage = (UserCustomerServiceObject) userContactUsPage.openPagesAtFooterByName(driver, "Customer Service");
		Assert.assertTrue(userCustomerServicePage.isPageDisplayedByPageHeaderName(driver, "Customer Service"));

		userPrivacyPolicyPage = (UserPrivacyPolicyObject) userCustomerServicePage.openPagesAtFooterByName(driver, "Privacy Policy");
		Assert.assertTrue(userPrivacyPolicyPage.isPageDisplayedByPageHeaderName(driver, "Privacy Policy"));
	}

	@Test
	public void TC_02_Navigate_Page_In_Footer() {
		userPrivacyPolicyPage.openPagesAtFooterByPageName(driver, "Contact Us");
		Assert.assertTrue(userContactUsPage.isPageDisplayedByPageHeaderName(driver, "Contact Us"));

		userContactUsPage.openPagesAtFooterByPageName(driver, "Customer Service");
		Assert.assertTrue(userCustomerServicePage.isPageDisplayedByPageHeaderName(driver, "Customer Service"));

		userCustomerServicePage.openPagesAtFooterByPageName(driver, "About Us");
		Assert.assertTrue(userAboutUsPage.isPageDisplayedByPageHeaderName(driver, "About Magento Store"));

		userCustomerServicePage.openPagesAtFooterByPageName(driver, "Privacy Policy");
		Assert.assertTrue(userPrivacyPolicyPage.isPageDisplayedByPageHeaderName(driver, "Privacy Policy"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}
}
