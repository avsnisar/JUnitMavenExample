package com.Google.GenTests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleGenTest {

	static WebDriver driver = new ChromeDriver();
	static WebElement query = null;

	@BeforeClass
	public static void setData() {
		System.out.println("run before 3 tests and @Before annotation");
		driver.get("https://google.com.ua");
		query = driver.findElement(By.name("q"));
		query.sendKeys("testing it");
		query = driver.findElement(By.cssSelector("input[type='submit'][name='btnK']"));
		query.submit();
	}

	@Before
	public void clearStep() {
		System.out.println("run before EACH of 3 tests BUT after @BeforeClass annotation");
	}

	@Test
	public void test1() {
		System.out.println("1 run");
	}

	@Test
	public void test2() {
		System.out.println("2 run");
	}

	@Test
	public void test3() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void test4() {
		boolean y = true;
		assertTrue(y != false);
		System.out.println("TRUE");
	}

	@After
	public void cleanStep() {
		System.out.println("run after EACH of 3 tests BUT before @After annotation");
	}

	@AfterClass
	public static void tearData() {
		driver.close();
		System.out.println("run after 3 tests and @After annotation");
	}

}
