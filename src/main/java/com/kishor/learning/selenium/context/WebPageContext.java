package com.kishor.learning.selenium.context;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kishor.learning.selenium.driver.DriverFactory;
import com.kishor.learning.selenium.repository.ElementNotFoundInRepositoryException;
import com.kishor.learning.selenium.repository.ObjectRepository;
import com.kishor.learning.selenium.repository.PageNotFoundException;

@Component
public class WebPageContext {
	
	private WebDriver driver;	
	private WebDriverWait wait;
	@Autowired
	private ObjectRepository objectRepo;
	private String currentPageContext;
	private static final Logger logger = LoggerFactory.getLogger(WebPageContext.class);
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public String getCurrentPageContext() {
		return currentPageContext;
	}

	public void setCurrentPageContext(String currentPageContext) {
		this.currentPageContext = currentPageContext;
	}

	@PostConstruct
	private void init() {
		driver = DriverFactory.getDriver();
		wait = DriverFactory.getWait();
	}
	
	public WebElement findWebPageElement(String elementName) throws Exception {
		logger.info("Finding element: {}", elementName);
		By elementLocator;
		try {
			elementLocator = objectRepo.getElementLocator(getCurrentPageContext(), elementName);
		} catch (PageNotFoundException | ElementNotFoundInRepositoryException ex) {
			logger.debug("Element {} not found in page {}", elementName, getCurrentPageContext());
			logger.debug("Searching {} in Default page", elementName);
			elementLocator = objectRepo.getElementLocator("Default", elementName);
		}
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		return element;
	}
	

}
