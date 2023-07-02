package pageUIs.jQuery.dataTable;

public class HomePageUI {

	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']//li//a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUE_BY_LABEL = "xpath=//tbody//tr[not(@style='display: none;')]//td[@data-key='%s'  and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']//li";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody//tr//td[@data-key='country']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead/tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input";

	public static final String LOAD_DATA_BUTTON = "css=button#load";
	public static final String INSERT_ROW_ABOVE_BUTTON = "css=button[id*='insert_1']";
	public static final String REMOVE_CURRENT_ROW_ABOVE_BUTTON_AT_ROW_TWO = "css=button[id*='remove_2']";

	public static final String ICON_BUTTON_BY_ROW_NUMBER_AND_ICON_NAME = "xpath=//tr[@data-unique-index='%s']//button[@title='%s']";
}
