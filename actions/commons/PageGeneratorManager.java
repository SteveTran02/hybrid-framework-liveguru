package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.liveguru.admin.AdminDashBoardObject;
import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageObjects.liveguru.user.UserAboutUsObject;
import pageObjects.liveguru.user.UserContactUsObject;
import pageObjects.liveguru.user.UserCustomerServiceObject;
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserLoginPageObject;
import pageObjects.liveguru.user.UserMyDashBoardObject;
import pageObjects.liveguru.user.UserPrivacyPolicyObject;
import pageObjects.liveguru.user.UserRegisterPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserMyDashBoardObject getUserMyDashBoardPage(WebDriver driver) {
		return new UserMyDashBoardObject(driver);
	}

	public static UserAboutUsObject getUserAboutUsPage(WebDriver driver) {
		return new UserAboutUsObject(driver);
	}

	public static UserContactUsObject getUserContactUsPage(WebDriver driver) {
		return new UserContactUsObject(driver);
	}

	public static UserCustomerServiceObject getUserCustomerServicePage(WebDriver driver) {
		return new UserCustomerServiceObject(driver);
	}

	public static UserPrivacyPolicyObject getUserPrivacyPolicyPage(WebDriver driver) {
		return new UserPrivacyPolicyObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashBoardObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardObject(driver);
	}

}
