package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.liveguru.admin.AdminDashBoardObject;
import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserLoginPageObject;
import pageObjects.liveguru.user.UserMyDashBoardObject;
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

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashBoardObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardObject(driver);
	}
}
