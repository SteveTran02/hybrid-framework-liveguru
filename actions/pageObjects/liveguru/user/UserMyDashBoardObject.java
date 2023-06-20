package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.liveGuru.user.UserDashBoardPageUI;

public class UserMyDashBoardObject extends BasePage {
	WebDriver driver;

	public UserMyDashBoardObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, UserDashBoardPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserDashBoardPageUI.SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserDashBoardPageUI.LOG_OUT_LINK);
		clickToElement(driver, UserDashBoardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickToMyAccountMenuLink() {
		waitForElementClickable(driver, UserDashBoardPageUI.MY_ACCOUNT_MENU_LINK);
		clickToElement(driver, UserDashBoardPageUI.MY_ACCOUNT_MENU_LINK);
	}

}
