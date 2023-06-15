package org.soapui;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class WebDriverManagerTest {
	
	private String username;
	private String password;
	
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	
	public WebDriverManagerTest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "1st case username";
		obj[0][1] = "1st case password";
		obj[1][0] = "2nd case username";
		obj[1][1] = "2nd case password";
//		obj[2][0] = "3 case username";
//		obj[2][1] = "3 case password";
//		obj[3][0] = "4 case username";
//		obj[3][1] = "4 case password";
		return Arrays.asList(obj);	
	}
	
	@Ignore
	@Test
	public void testLaunchingBrowserWithWebDriverManager() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// з 4.6 версії Selenium потрібно буде замінити WebDriverManager на Selenium Manager
		
		driver.get("https://github.com/SeleniumHQ/selenium/releases/tag/selenium-4.8.0");
		
		WebElement userLogo = driver.findElement(By.cssSelector("#id"));
		userLogo.click();
		Assert.assertTrue("Passed with true", 1 == 1);
	}
	
	@Test
	public void onemoreTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		WebElement wait = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		try {
			// needs to evaluate to false to trigger an exception of some kind
		Assert.assertTrue(!wait.isDisplayed());
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			// if Exception class object is thrown and caught, the test will be marked as Failure and driver will not go further and will not quit
			// if Throwable class object is thrown and caught, the test will go further and driver will quit:
				// but there will not be any java.lang.AssertionError at org.junit.Assert.fail and the test will be marked as successfully passed
				// unless ErrorCollector class object is used: 
					// thus, if used, then the test will be marked as Failure, and there will be java.lang.AssertionError at org.junit.Assert.fail
			errorCollector.addError(e);
		}
		// lines below will not be executed if an Exception class object is caught instead of Throwable
		Thread.sleep(1000);
		driver.quit();
	}

}
