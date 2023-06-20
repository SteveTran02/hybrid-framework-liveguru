package parameter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Multiple_Browser_And_Environment {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextbox = By.xpath("//*[@id='email']");
	By passwordTextbox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getMultipleBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters("environment")
	@Test(invocationCount = 5)
	public void TC_01_LoginToSystem(String environmentName) {
		getMultipleEnvironment(environmentName);

		driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("111111");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public WebDriver getMultipleBrowserDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is invalid");
		}
		return driver;
	}

	public void getMultipleEnvironment(String environmentName) {
		String url = null;
		switch (environmentName.toLowerCase()) {
		case "dev":
			url = "live";
			driver.get("http://" + url + ".techpanda.org/index.php/customer/account/login/");
			break;
		case "testing":
			url = "testing";
			driver.get("http://" + url + ".techpanda.org/index.php/customer/account/login/");
			break;
		case "staging":
			url = "live";
			driver.get("http://" + url + ".techpanda.org/index.php/customer/account/login/");
			break;
		default:
			throw new RuntimeException("Environment name is not supported");
		}
	}

}
