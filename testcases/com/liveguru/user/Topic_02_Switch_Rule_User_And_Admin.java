package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.liveguru.admin.AdminDashBoardObject;
import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageObjects.liveguru.user.UserAboutUsObject;
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserLoginPageObject;
import pageObjects.liveguru.user.UserMyDashBoardObject;

public class Topic_02_Switch_Rule_User_And_Admin extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserMyDashBoardObject userMyDashboardPage;
	private UserAboutUsObject userAboutUsPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardObject adminDashboardPage;

	private String userEmailAddress, userPassword;
	private String adminUserName, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "pureinsight2000@gmail.com";
		userPassword = "123456";
		adminUserName = "user01";
		adminPassword = "guru99com";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToMyAccountLink();
		// Login as User role
		userMyDashboardPage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userMyDashboardPage.isDashboardHeaderDisplayed());
		// My Dashboard Page -> About Us Page
		userAboutUsPage = userMyDashboardPage.openUserAboutUsPage(driver);
		// About Us Page -> click Logout -> Home page
		userHomePage = userAboutUsPage.clickToLogoutLinkAtUserPage(driver);
		// User Home Page -> Open Admin url -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminUserName, adminPassword);
		adminDashboardPage.clickToCloseAtPopup();
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		// Dashboard Page -> click logout link -> Login page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login page (Admin) -> Open User url -> HomePage (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		// HomePage (User) ->Login Page User
		userLoginPage = userHomePage.clickToMyAccountLink();
		// Login as User role
		userMyDashboardPage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userMyDashboardPage.isDashboardHeaderDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}

}
