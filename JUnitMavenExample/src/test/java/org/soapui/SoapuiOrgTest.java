package org.soapui;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Oleksandr S.
 *
 */
public class SoapuiOrgTest {
	
	static WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		System.setProperty("webdriver.edge.driver", "D:\\Install\\BrowserDrivers\\msedgedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "D:\\Install\\BrowserDrivers\\chromedriver.exe");
//		System.setProperty("webdriver.opera.driver", "D:\\Install\\BrowserDrivers\\operadriver.exe");
//		System.setProperty("webdriver.gecko.driver", "D:\\Install\\BrowserDrivers\\geckodriver.exe");
//		System.setProperty("webdriver.ie.driver", "D:\\Install\\BrowserDrivers\\IEDriverServer.exe");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		FirefoxOptions options = new FirefoxOptions();
//		options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox 42\\firefox.exe");
//		driver = new FirefoxDriver(options);
		driver = new ChromeDriver();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testOpenCart() throws InterruptedException{
//		System.setProperty("webdriver.chrome.driver", "D:\\Install\\BrowserDrivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.soapui.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement link = driver.findElement(By.xpath("//a[@class='nav-link nav-link-cart']"));
		Actions actOne = new Actions(driver);
		actOne.moveToElement(link).perform();
		Thread.sleep(3000);
		actOne.click(link).perform();
//		if more than 1 operation, then with build().perform()
//		actOne.moveToElement(link).click().build().perform();
		Thread.sleep(3000);
}
	
	@Test
	public void testScreenshotTake() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "D:\\Install\\BrowserDrivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.soapui.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Taking screenshots logic
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("screenshots\\screenshot2.png"));
	}

}
