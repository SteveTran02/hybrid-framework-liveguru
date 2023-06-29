package pageUIs.liveGuru.admin;

public class AdminDashBoardPageUI {
	public static final String CLOSE_BUTTON_AT_POPUP = "xpath=//div[@id='message-popup-window']//span[text()='close']";
	public static final String FULLNAME_BY_EMAIL_ADDRESS_NEW_ACCOUNT = "xpath=//tbody/tr/td[contains(text(),'%s')]/preceding-sibling::td[contains(text(),'%s')]";
	public static final String CHECKBOX_BY_EMAIL_ADDRESS_NEW_ACCOUNT = "xpath=//tbody/tr[@class='even pointer']/td/input[@class='massaction-checkbox']";
	public static final String PARENT_ACTIONS_DROPDOWN_LIST = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String CHILD_ACTIONS_DROPDOWN_LIST = "xpath=//select[@id='customerGrid_massaction-select']/option";
	public static final String SUBMIT_BUTTON = "xpath=//button[@title='Submit']/span";
	public static final String LOG_OUT_BUTTON = "xpath=//a[text()='Log Out']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='customerGrid_filter_email']";
	public static final String SEARCH_BUTTON = "xpath=//td[@class='filter-actions a-right']//button//span[text()='Search']";
	public static final String DASHBOARD_HEADER = "xpath=//div[@id='anchor-content']//h3[text()='Manage Customers']";

}
