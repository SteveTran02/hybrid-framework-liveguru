package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.liveGuru.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXT_BOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXT_BOX, lastName);
	}

	public void inputToEmailAddressTextbox(String userEmailAdress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXT_BOX, userEmailAdress);
	}

	public void inputToPasswordTextbox(String userPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, userPassword);
	}

	public void inputToConfirmPasswordTextbox(String userPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, userPassword);
	}

	public UserMyDashBoardObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserMyDashBoardPage(driver);
	}
}
