package pageObjects.liveguru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.liveGuru.admin.AdminDashBoardPageUI;

public class AdminDashBoardObject extends BasePage {
	WebDriver driver;

	public AdminDashBoardObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closeToAlert() {
		cancelAlert(driver);
	}

	public boolean isNewUsernameDisplay(String userEmailAdress, String fullName) {
		return isElementDisplayed(driver, AdminDashBoardPageUI.FULLNAME_BY_EMAIL_ADDRESS_NEW_ACCOUNT, userEmailAdress, fullName);
	}

	public void checkToCheckBoxByEmailAdress(String userEmailAdress) {
		waitForElementClickable(driver, AdminDashBoardPageUI.CHECKBOX_BY_EMAIL_ADDRESS_NEW_ACCOUNT, userEmailAdress);
		checkToDefaultCheckboxOrRadio(driver, AdminDashBoardPageUI.CHECKBOX_BY_EMAIL_ADDRESS_NEW_ACCOUNT, userEmailAdress);
	}

	public void selectToDeleteAtActionsDropdownList(String itemName) {
		waitForElementClickable(driver, AdminDashBoardPageUI.PARENT_ACTIONS_DROPDOWN_LIST);
		selectItemInCustomDropdown(driver, AdminDashBoardPageUI.PARENT_ACTIONS_DROPDOWN_LIST, AdminDashBoardPageUI.CHILD_ACTIONS_DROPDOWN_LIST, itemName);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, AdminDashBoardPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.SUBMIT_BUTTON);
	}

	public void acceptToAlert() {
		acceptAlert(driver);
	}

	public AdminLoginPageObject clickToLogOutLink() {
		waitForElementClickable(driver, AdminDashBoardPageUI.LOG_OUT_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.LOG_OUT_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public void closeTopPopUp() {
		waitForElementClickable(driver, AdminDashBoardPageUI.CLOSE_BUTTON_AT_POPUP);
		clickToElement(driver, AdminDashBoardPageUI.CLOSE_BUTTON_AT_POPUP);
	}

	public void inputToEmailTextbox(String userEmailAdress) {
		waitForElementVisible(driver, AdminDashBoardPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminDashBoardPageUI.EMAIL_TEXTBOX, userEmailAdress);
	}

	public void clickToSearchTextbox() {
		waitForElementClickable(driver, AdminDashBoardPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.SEARCH_BUTTON);
	}

	public void clickToCloseAtPopup() {
		waitForElementClickable(driver, AdminDashBoardPageUI.CLOSE_BUTTON_AT_POPUP);
		clickToElement(driver, AdminDashBoardPageUI.CLOSE_BUTTON_AT_POPUP);
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}

}
