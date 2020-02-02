package com.kishor.learning.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummaryPage extends BasePage {
	
	@FindBy(how=How.ID, using="order-list")
	private WebElement ordersTable;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOrdersTableDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(ordersTable));
		return ordersTable.isDisplayed();
	}
	
	public boolean checkPresenceOfOrder(String orderRef) {
		WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(orderRef)));
		return order.isDisplayed();
	}
	
	

}
