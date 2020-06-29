package com.jjh.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Provides a generic SeleniumConfig class
 * that can be referenced by numerous Selenium Test classes.
 */
public class SeleniumConfig {

	/** The Drive instance **/
	private WebDriver driver;

	public SeleniumConfig() {
		// Set up thew appropriate Web Drive instance
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Statics are executed when the class is loaded
	static {
		// Setting system properties of ChromeDriver
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}

	public void close() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
