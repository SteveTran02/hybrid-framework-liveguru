package seleniumLocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Opening Register page
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		sleepInSeconds(3);
		driver.findElement(By.id("gender-male")).click();
	}

	@Test
	public void TC_02_Class() {
		sleepInSeconds(3);
		driver.findElement(By.className("female")).click();
	}

	@Test
	public void TC_03_Name() {
		sleepInSeconds(3);
		driver.findElement(By.name("FirstName")).sendKeys("automation");
	}

	@Test
	public void TC_04_TagName() {

	}

	@Test
	public void TC_05_PartialLinkText() {

	}

	@Test
	public void TC_06_LinkText() {

	}

	@Test
	public void TC_07_CssSelector() {

	}

	@Test
	public void TC_08_XPath() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public void sleepInSeconds(long timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
