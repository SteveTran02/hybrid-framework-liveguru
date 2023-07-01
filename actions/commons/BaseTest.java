package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		if (browser == BrowserList.FIREFOX) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browser == BrowserList.CHROME) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser == BrowserList.EDGE) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().window().maximize();
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		if (browser == BrowserList.FIREFOX) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browser == BrowserList.CHROME) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser == BrowserList.EDGE) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";
		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com/";
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "https://admin-demo.nopcommerce.com/";
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://admin-demo.nopcommerce.com/";
		} else {
			throw new RuntimeException("Environmnet name invalid");
		}
		return envUrl;
	}

	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("Browser is closed");
		} else {
			driver.quit();
		}
	}

}
