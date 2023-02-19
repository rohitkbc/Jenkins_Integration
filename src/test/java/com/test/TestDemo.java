package com.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
	
	WebDriver driver;
	
	@Before
	public void beforePre() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome-stable");
		options.setHeadless(true);
        driver = new ChromeDriver(options);
	}
	
	@Test
	public void firstTest()
    {
        driver.get("https://www.saucedemo.com/");
    }
	
	@Test
    public void smarterTest()
    {
        driver.get("https://www.saucedemo.com/");
        assertEquals("Swag Labs", driver.getTitle());
    }
	
	@Test
	public void orangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        assertEquals("OrangeHRM", driver.getTitle());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void orangeHRMLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        assertEquals("Dashboard", text);
	}
	
	@After
	public void afterEnd() {
		driver.quit();
	}
}
