package pageObject.jQuery.uploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFiles.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByFileName(String... filesName) {
		waitForElementVisible(driver, HomePageUI.FILE_LOADED_LINK_BY_FILE_NAME, filesName);
		return isElementDisplayed(driver, HomePageUI.FILE_LOADED_LINK_BY_FILE_NAME, filesName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtonElement = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement eachStartButton : startButtonElement) {
			eachStartButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileLinkUpLoadedByFileName(String... filesName) {
		waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_LINK_BY_FILE_NAME, filesName);
		return isElementDisplayed(driver, HomePageUI.FILE_UPLOADED_LINK_BY_FILE_NAME, filesName);
	}

	public boolean isFileImageUpLoadedByFileName(String... filesName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_UPLOADED_SUCCESSED_BY_FILE_NAME, filesName);
		return isElementDisplayed(driver, HomePageUI.IMAGE_UPLOADED_SUCCESSED_BY_FILE_NAME, filesName);
	}

	public boolean isFileImage(String... filesName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_UPLOADED_SUCCESSED_BY_FILE_NAME, filesName);
		return isImageLoaded(driver, HomePageUI.IMAGE_UPLOADED_SUCCESSED_BY_FILE_NAME, filesName);
	}

}
