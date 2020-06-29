package com.jjh.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SeleniumJUnitTest {

	private static SeleniumConfig config;

	@BeforeAll
	public static void setUp() {
		// Instantiate config object - start the web driver
		config = new SeleniumConfig();
		// Load the web page to be used for all tests
		config.getDriver().get("http://localhost:8080/index.html");
	}

	@AfterAll
	public static void tearDown() {
		// Shut down the Selenium web driver
		config.close();
	}

	@Test
	public void check_page_title_is_Hello_World() {
		// Get hold of title of web page
		String actualTitle = config.getDriver().getTitle();
		assertEquals("Hello World", actualTitle);
	}

	@Test
	public void check_heading_is_Welcome() {
		String heading = 
				config.getDriver()
				      .findElement(By.className("heading"))
				      .getText();
		assertEquals("Welcome", heading);
	}

}
