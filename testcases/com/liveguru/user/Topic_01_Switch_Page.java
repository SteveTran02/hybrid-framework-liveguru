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

public class Topic_01_Switch_Page extends BaseTest {
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
		userAboutUsPage = userHomePage.openUserAboutUsPage(driver);
		Assert.assertTrue(userAboutUsPage.isPageDisplayedByPageHeaderName(driver, "About Magento Store"));

		userContactUsPage = userAboutUsPage.openUserContactUsPage(driver);
		Assert.assertTrue(userContactUsPage.isPageDisplayedByPageHeaderName(driver, "Contact Us"));

		userCustomerServicePage = userContactUsPage.openUserCustomerServicePage(driver);
		Assert.assertTrue(userCustomerServicePage.isPageDisplayedByPageHeaderName(driver, "Customer Service"));

		userPrivacyPolicyPage = userCustomerServicePage.openUserPrivacyPolicyPage(driver);
		Assert.assertTrue(userPrivacyPolicyPage.isPageDisplayedByPageHeaderName(driver, "Privacy Policy"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}
}
