package com.kishor.learning.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.kishor.learning.selenium.driver.DriverFactory;

@Component
public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait shortWait;
	 
	
	public BasePage() {
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 10);
		shortWait = new WebDriverWait(driver, 5);
	}

}
