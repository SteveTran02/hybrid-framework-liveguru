package pageObjects.liveguru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.liveGuru.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX, adminUserName);
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, adminPassword);
	}

	public AdminDashBoardObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
}
