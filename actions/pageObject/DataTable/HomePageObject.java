package pageObject.DataTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTextboxByLable(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		sendKeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isValueByLabelDisplayed(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_LABEL, headerLabel, value);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_LABEL, headerLabel, value);
	}

	public Set<String> getValueEachRowAtAllPage() {
		List<WebElement> totalPage = getListWebElement(driver, HomePageUI.TOTAL_PAGINATION);
		Set<String> allRowValueUniqueAllPage = new HashSet<String>();

		for (int i = 1; i <= totalPage.size(); i++) {
			waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(i));
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(i));

			List<WebElement> allRowAtEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);

			for (WebElement eachRow : allRowAtEachPage) {
				allRowValueUniqueAllPage.add(eachRow.getText());
			}
		}

		for (String value : allRowValueUniqueAllPage) {
			System.out.println(value);
		}
		return allRowValueUniqueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		// defined index textbox
		// tbody/tr[rowNumber]/td[INDEX_COLUMN]
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void selectValueAtDropdownlistByColumNameAndRowNumber(String columnName, String rowNumber, String selectOption) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, selectOption, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByColumNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}

	public void clickToInsertRowAboveButtonAtRowOne() {
		waitForElementClickable(driver, HomePageUI.INSERT_ROW_ABOVE_BUTTON);
		clickToElement(driver, HomePageUI.INSERT_ROW_ABOVE_BUTTON);
	}

	public String getAttributeValue(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementAttribute(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, "value", rowNumber, String.valueOf(columnIndex));
	}

	public String getFirstOption(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return getFirstSelectedItemDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public boolean isCheckToCheckbox(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return isElementSelected(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToRemoveCurrentRowButtonAtRowTwo() {
		waitForElementClickable(driver, HomePageUI.REMOVE_CURRENT_ROW_ABOVE_BUTTON_AT_ROW_TWO);
		clickToElement(driver, HomePageUI.REMOVE_CURRENT_ROW_ABOVE_BUTTON_AT_ROW_TWO);
	}

	public String getValueAtTextboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementAttribute(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, "value", rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_BUTTON_BY_ROW_NUMBER_AND_ICON_NAME, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_BUTTON_BY_ROW_NUMBER_AND_ICON_NAME, rowNumber, iconName);
	}

}
