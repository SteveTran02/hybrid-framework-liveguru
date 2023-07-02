package com.jquery;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

public class Topic_04_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	Set<String> actualAllCountryValue;
	Set<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("9");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("9"));

		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("11");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("11"));

	}

	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.inputToHeaderTextboxByLable("Females", "12253515");
		homePage.inputToHeaderTextboxByLable("Country", "AFRICA");
		homePage.inputToHeaderTextboxByLable("Males", "12599691");
		homePage.inputToHeaderTextboxByLable("Total", "24853148");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isValueByLabelDisplayed("females", "12253515"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("country", "AFRICA"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("males", "12599691"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("total", "24853148"));

		homePage.refreshCurrentPage(driver);
		homePage.inputToHeaderTextboxByLable("Females", "276880");
		homePage.inputToHeaderTextboxByLable("Country", "Angola");
		homePage.inputToHeaderTextboxByLable("Males", "276472");
		homePage.inputToHeaderTextboxByLable("Total", "553353");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isValueByLabelDisplayed("females", "276880"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("country", "Angola"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("males", "276472"));
		Assert.assertTrue(homePage.isValueByLabelDisplayed("total", "553353"));

	}

	public void Table_03_Value_At_Each_Row() {
		// Đọc data từ file CountryData.txt => lưu vào Set<String> => expectedAllCountryValue

		actualAllCountryValue = homePage.getValueEachRowAtAllPage();

		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);
	}

	public void Table_04_Action_At_Any_Textbox() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(1);
		homePage.clickToInsertRowAboveButtonAtRowOne();
		homePage.sleepInSecond(1);
		// Verify row one is created
		Assert.assertTrue(homePage.getAttributeValue("Company", "1").equals(""));
		Assert.assertTrue(homePage.getAttributeValue("Contact Person", "1").equals(""));
		Assert.assertTrue(homePage.getFirstOption("Country", "1").equals(""));
		Assert.assertFalse(homePage.isCheckToCheckbox("NPO?", "1"));
		Assert.assertTrue(homePage.getAttributeValue("Order Placed", "1").equals(""));

		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Bosch");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Stephen Guise");
		homePage.selectValueAtDropdownlistByColumNameAndRowNumber("Country", "1", "Taiwan");
		homePage.checkToCheckboxByColumNameAndRowNumber("NPO?", "1");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "9");
	}

	public void Table_05() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.getAttributeValue("Company", "1").equals(""));

		String attributeValueAtCompanyColumnAndFourthRow = homePage.getAttributeValue("Company", "4");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.sleepInSecond(2);
		String attributeValueAtCompanyColumnAndThirdRow = homePage.getAttributeValue("Company", "3");
		Assert.assertEquals(attributeValueAtCompanyColumnAndThirdRow, attributeValueAtCompanyColumnAndFourthRow);

		String attributeValueAtCompanyColumnAndSecondRow = homePage.getAttributeValue("Company", "2");
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.sleepInSecond(1);
		String attributeValueAtCompanyColumnAndFirstRow = homePage.getAttributeValue("Company", "1");
		Assert.assertEquals(attributeValueAtCompanyColumnAndFirstRow, attributeValueAtCompanyColumnAndSecondRow);

		attributeValueAtCompanyColumnAndFourthRow = homePage.getAttributeValue("Company", "4");
		homePage.clickToIconByRowNumber("4", "Move Down");
		String attributeValueAtCompanyColumnAndFifthRow = homePage.getAttributeValue("Company", "5");
		Assert.assertEquals(attributeValueAtCompanyColumnAndFifthRow, attributeValueAtCompanyColumnAndFourthRow);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowser();
	}

}
