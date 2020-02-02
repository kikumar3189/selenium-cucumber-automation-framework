package com.kishor.learning.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccount extends BasePage {
	
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]//a[@title=\"Information\"]")
	private WebElement personalInformationLink ;
	@FindBy(how=How.ID, using="firstname")
	private WebElement firstName;
	@FindBy(how=How.ID, using="old_passwd")
	private WebElement currentPassword;
	@FindBy(how=How.NAME, using="submitIdentity")
	private WebElement saveButton;
	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]//a[@title=\"View my customer account\"]/span")
	private WebElement myaccountName ;
	
	
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void updateFirstName(String name, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(personalInformationLink));
		personalInformationLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		firstName.sendKeys(name);
		currentPassword.clear();
		currentPassword.sendKeys(password);
		saveButton.click();
		
		
	}
	
	public String getAccountName() {
		wait.until(ExpectedConditions.visibilityOf(myaccountName));
		return myaccountName.getText().trim();
	}

}
