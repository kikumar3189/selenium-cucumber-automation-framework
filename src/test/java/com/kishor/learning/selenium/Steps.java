package com.kishor.learning.selenium;


import io.cucumber.java.en.Then;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.kishor.learning.selenium.driver.DriverFactory;

import io.cucumber.java.en.Given;

public class Steps {
	
	private static WebDriver driver;
	
	static {
		driver = DriverFactory.getDriver();	
	}
	
	@Given("^user navigates to google search page$")
	public void navigateToHomePage() {
		driver.get("https://www.google.com/");
	}
	
	@Then("^search box should be displayed$")
	public void isLoginPageDisplayed() throws  InterruptedException {
		System.out.println("Locating logo");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		WebElement searchBox = driver.findElement(By.name("q"));
		Assert.assertTrue( "Search box is not displayed", searchBox.isDisplayed());
		driver.close();
	}
}
