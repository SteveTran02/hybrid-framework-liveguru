package apiLevel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo_Dropdown_list_Default {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://egov.danang.gov.vn/reg");
	}

	@Test
	public void TC_01_() {
		// List<WebElement> selectAllCitys = new Select(driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"))).getOptions();
		// System.out.println(selectAllCitys.size());
		// int i = 0;
		// for (WebElement optioncityName : selectAllCitys) {
		// if (optioncityName.getText().startsWith("thành") || (optioncityName.getText().startsWith("tỉnh"))) {
		// System.out.println(optioncityName.getText());
		// i++;
		// }
		// }
		// System.out.println(i);

		new Select(driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"))).selectByVisibleText("tỉnh Bình Định");
		sleepInSecond(3);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"))).getFirstSelectedOption().getText(), "tỉnh Bình Định");

	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
