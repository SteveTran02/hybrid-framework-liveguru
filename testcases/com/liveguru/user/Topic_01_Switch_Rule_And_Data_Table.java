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
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserLoginPageObject;
import pageObjects.liveguru.user.UserMyDashBoardObject;
import pageObjects.liveguru.user.UserRegisterPageObject;

public class Topic_01_Switch_Rule_And_Data_Table extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "pure";
		lastName = "insight";
		fullName = firstName + " " + lastName;
		userEmailAdress = "pure" + "insight" + getRandomNumber() + "@gmail.com";
		userPassword = "123456";
		adminUserName = "user01";
		adminPassword = "guru99com";
	}

	@Test
	public void TC_01_Register_New_User() {
		userLoginPage = userHomePage.clickToMyAccountLink();
		Assert.assertEquals(userLoginPage.getPageTitle(driver), "Customer Login");
		userRegisterPage = userLoginPage.clickToCreatAnAccountLink();
		Assert.assertEquals(userRegisterPage.getPageTitle(driver), "Create New Customer Account");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailAddressTextbox(userEmailAdress);
		System.out.println(userEmailAdress);
		System.out.println(userPassword);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		userMyDashBoardPage = userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userMyDashBoardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");

		userMyDashBoardPage.clickToMyAccountMenuLink();
		userHomePage = userMyDashBoardPage.clickToLogOutLink();
		userHomePage.sleepInSecond(6);
		Assert.assertEquals(userHomePage.getPageTitle(driver), "Home page");

		// User Home Page -> open Admin Page -> Admin Login page
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// Login Admin Role with username and password
		adminLoginPage.inputToUserNameTextbox(adminUserName);
		adminLoginPage.inputToPasswordTextbox(adminPassword);
		adminDashBoardPage = adminLoginPage.clickToLoginButton();
		adminDashBoardPage.closeTopPopUp();
		// Customer grid filter email
		adminDashBoardPage.inputToEmailTextbox(userEmailAdress);
		adminDashBoardPage.clickToSearchTextbox();
		// Veridy new user upload displayed into Data grid
		Assert.assertTrue(adminDashBoardPage.isNewUsernameDisplay(userEmailAdress, fullName));
		adminDashBoardPage.checkToCheckBoxByEmailAdress(userEmailAdress);
		adminDashBoardPage.selectToDeleteAtActionsDropdownList("Delete");
		adminDashBoardPage.clickToSubmitButton();
		adminDashBoardPage.acceptToAlert();
		Assert.assertFalse(adminDashBoardPage.isNewUsernameDisplay(userEmailAdress, fullName));
		// Veridy new user is not displayed into Data grid
		// Assert.assertFalse(adminDashBoardPage.isNewUsernameDisplay(userEmailAdress, fullName));
		adminLoginPage = adminDashBoardPage.clickToLogOutLink();

		// Switch role at User
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToMyAccountLink();
		Assert.assertEquals(userLoginPage.getPageTitle(driver), "Customer Login");

		// Login with User Name and passwork
		userLoginPage.inputToEmailAddressTextbox(userEmailAdress);
		userLoginPage.inputToPasswordTextbox(userPassword);
		userMyDashBoardPage = userLoginPage.clickToLoginButton();
		// Verify login unsuccessfully
		Assert.assertEquals(userLoginPage.getUnSuccessfullyMessage(), "Invalid login or password.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserMyDashBoardObject userMyDashBoardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardObject adminDashBoardPage;

	private String firstName, lastName, fullName;
	private String userEmailAdress, userPassword;
	private String adminUserName, adminPassword;

}
