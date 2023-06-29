package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.liveGuru.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreatAnAccountLink() {
		waitForElementClickable(driver, UserLoginPageUI.CREAT_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREAT_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public void inputToEmailAddressTextbox(String userEmailAdress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, userEmailAdress);
	}

	public void inputToPasswordTextbox(String userPassword) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, userPassword);
	}

	public UserMyDashBoardObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserMyDashBoardPage(driver);

	}

	public String getUnSuccessfullyMessage() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.ERROR_MESSAGE);
	}

	public UserMyDashBoardObject loginAsUser(String userEmailAddress, String userPassword) {
		inputToEmailAddressTextbox(userEmailAddress);
		inputToPasswordTextbox(userPassword);
		return clickToLoginButton();
	}
}
