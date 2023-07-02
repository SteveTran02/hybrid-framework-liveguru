package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFiles.HomePageObject;
import pageObject.jQuery.uploadFiles.PageGeneratorManager;

public class Topic_05_Upload_Verify_Multiple_Files extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private String caoHung = "caohung.jpg";
	private String daiNam = "dainam.jpg";
	private String taiPei = "taipei.jpg";
	private String multipleFileName[] = { caoHung, daiNam, taiPei };

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, caoHung);

		Assert.assertTrue(homePage.isFileLoadedByFileName(caoHung));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByFileName(caoHung));
		Assert.assertTrue(homePage.isFileImageUpLoadedByFileName(caoHung));
		Assert.assertTrue(homePage.isFileImage(caoHung));

	}

	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.uploadMultipleFiles(driver, multipleFileName);

		Assert.assertTrue(homePage.isFileLoadedByFileName(multipleFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByFileName(multipleFileName));

		Assert.assertTrue(homePage.isFileImageUpLoadedByFileName(multipleFileName));

		Assert.assertTrue(homePage.isFileImage(multipleFileName));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}

}
