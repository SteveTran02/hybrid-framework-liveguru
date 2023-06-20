package parameter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Javascript_Executor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	Random rand = new Random();
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String mobileLink = "//a[text()='Mobile']";
	String samsungGalaxyAddToCartButton = "//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	String customerServiceLink = "//a[text()='Customer Service']";
	String newsletterTextbox = "//input[@id='newsletter']";
	String validemailAddress = "pureinsight" + String.valueOf(rand.nextInt(999)) + "@gmail.com";
	String subcribeButton = "//button[@title='Subscribe']";
	String name = "pure";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_TechPanda() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(3);

		Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");

		hightlightElement(mobileLink);
		clickToElementByJS(mobileLink);
		sleepInSecond(3);
		Assert.assertEquals(executeForBrowser("return document.title;"), "Mobile");

		hightlightElement(samsungGalaxyAddToCartButton);
		clickToElementByJS(samsungGalaxyAddToCartButton);
		sleepInSecond(3);
		// verify success message
		Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));

		hightlightElement(customerServiceLink);
		clickToElementByJS(customerServiceLink);
		sleepInSecond(3);
		Assert.assertEquals(executeForBrowser("return document.title;"), "Customer Service");

		// scroll to newsletter textbox in bottom page
		scrollToElementOnDown(newsletterTextbox);
		sleepInSecond(2);
		// sendkeys to textbox
		hightlightElement(newsletterTextbox);
		getElement(newsletterTextbox).sendKeys(validemailAddress);
		sleepInSecond(2);
		// click to subcribe button
		hightlightElement(subcribeButton);
		clickToElementByJS(subcribeButton);
		sleepInSecond(2);
		Assert.assertTrue(areExpectedTextInInnerText("Thank you for your subscription."));

		// navigate to bankguru.com
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		sleepInSecond(2);
		Assert.assertEquals(executeForBrowser("return document.domain;"), "demo.guru99.com");
	}

	public void TC_02_Rode() {
		// navigate Login Page
		driver.get("https://warranty.rode.com/login");
		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='email']").sendKeys(validemailAddress);
		sleepInSecond(1);

		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='password']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='password']").sendKeys("123456");

		// navigate Register Page
		driver.get("https://warranty.rode.com/register");

		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='name']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='name']").sendKeys(name);
		sleepInSecond(1);

		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='email']").sendKeys(validemailAddress);
		sleepInSecond(1);

		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='password']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='password']").sendKeys("123456");
		sleepInSecond(1);

		getElement("//button").click();
		sleepInSecond(1);

		Assert.assertEquals(getElementValidationMessage("//input[@id='password_confirmation']"), "Please fill out this field.");
		sleepInSecond(1);

		getElement("//input[@id='password_confirmation']").sendKeys("123456");
		sleepInSecond(1);
	}

	@Test
	public void TC_03_BankGuru() {
		driver.get("http://demo.guru99.com/v4");
		getElement("//input[@name='uid']").sendKeys("mngr508172");
		getElement("//input[@name='password']").sendKeys("suvunan");
		getElement("//input[@name='btnLogin']").click();
		sleepInSecond(2);

		getElement("//ul[@class='menusubnav']//a[text()='New Customer']").click();
		sleepInSecond(2);

		getElement("//input[@name='name']").sendKeys("pure");
		getElement("//input[@name='rad1' and @value='m']").click();

		removeAttributeInDOM("//input[@id='dob']", "type");
		sleepInSecond(2);
		getElement("//input[@id='dob']").sendKeys("01/01/2020");
		sleepInSecond(2);

		getElement("//textarea").sendKeys("Sai Gon City");
		sleepInSecond(2);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 4px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
