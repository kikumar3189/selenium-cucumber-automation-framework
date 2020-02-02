package com.kishor.learning.selenium;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.kishor.learning.selenium.driver.DriverFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@SpringBootTest
@CucumberOptions(
features = "src/test/resources/bdd",
plugin = {"pretty", "html:target/cucumber"},
monochrome = true)
public class TestRunner {
	
	@AfterClass
	public static void tearDown() {
		WebDriver driver = DriverFactory.getDriver();
		driver.close();
	}
		
	

}
