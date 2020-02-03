package com.kishor.learning.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage{
	
	@FindBy(how=How.ID, using="email")
	private WebElement username;
	
	@FindBy(how=How.ID, using="passwd")
	private WebElement password;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	private WebElement submitLogin;
	@FindBy(how=How.LINK_TEXT, using="Sign in")
	private WebElement signInLink;
	@Autowired
	private HomePage homePage;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage performLogin(String user, String passwd) {
		try {
			homePage.isHomePageDisplayed();
			logger.info("User already logged in.");
		}catch(TimeoutException ex) {
			//Perform login if sign out link is not displayed.
			wait.until(ExpectedConditions.elementToBeClickable(signInLink));
			signInLink.click();
			wait.until(ExpectedConditions.elementToBeClickable(username));
			logger.info("Logging in as {}", user);
			username.clear();
			username.sendKeys(user);
			password.clear();
			password.sendKeys(passwd);
			submitLogin.click();


		}
		
		return new HomePage();
	}
	
	

}
