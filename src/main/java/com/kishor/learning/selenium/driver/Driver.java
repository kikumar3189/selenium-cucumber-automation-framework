package com.kishor.learning.selenium.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Driver {
	
	private static WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(Driver.class);
		
	public static void navigateToUrl(String url) {
		logger.info("Navigating to URL: {}", url);
		driver.get(url);
		driver.manage().window().maximize();
	}

}
