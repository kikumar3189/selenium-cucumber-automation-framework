package com.kishor.learning.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {
	@FindBy(how=How.LINK_TEXT, using="Sign out")
	private WebElement signOutLink;
	@FindBy(how=How.XPATH, using="(//a[@title=\"T-shirts\"])[2]")
	private WebElement tShirtsLink;
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]/h1/span[1]")
	private WebElement tShirtsLabel;
	@FindBy(how=How.XPATH, using="//*[@id=\"add_to_cart\"]/button")
	private WebElement addToCart;
	@FindBy(how=How.XPATH, using="//*[@id=\"layer_cart\"]//a[@title=\"Proceed to checkout\"]")
	private WebElement checkOut_1;
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]//a[@title=\"Proceed to checkout\"]")
	private WebElement checkOut_2;
	@FindBy(how=How.NAME, using="processAddress")
	private WebElement checkOut_3;
	@FindBy(how=How.ID, using="uniform-cgv")
	private WebElement agreeToTermsCheckbox;
	@FindBy(how=How.NAME, using="processCarrier")
	private WebElement checkOut_4;
	@FindBy(how=How.XPATH, using="//*[@id=\"cart_navigation\"]/button")
	private WebElement confirmOrder;
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]/div")
	private WebElement orderConfirmationSummary;	
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]//a[@title=\"Back to orders\"]")
	private WebElement backToOrders;
	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]//a[@title=\"View my customer account\"]")
	private WebElement myaccount ;


	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHomePageDisplayed() {
		shortWait.until(ExpectedConditions.elementToBeClickable(signOutLink));
		return signOutLink.isDisplayed();
	}
	
	public MyAccount goToMyAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(myaccount));
		myaccount.click();
		return new MyAccount();
	}

	public void navigateToTShirts() {
		wait.until(ExpectedConditions.elementToBeClickable(tShirtsLink));
		tShirtsLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(tShirtsLabel));
	}
	
	public boolean isTShirtsSectionDisplayed() {
		return tShirtsLabel.isDisplayed();
	}
	
	public void addItemToCart(String itemName) {
		String itemXpathFormat = "//div[@id=\"center_column\"]//a[@title=\"%s\" and @class=\"product-name\"]";
		String itemXpath = String.format(itemXpathFormat, itemName);
		logger.info("Locating item with XPATH {}", itemXpath);
		WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemXpath)));
		item.click();
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkOut_1));
		
	}
	
	public void selectPaymentMethod(String method) {
		String paymentXpathFormat = "//*[@id=\"HOOK_PAYMENT\"]//a[@title=\"%s\"]";
		String paymentXpath = String.format(paymentXpathFormat, method);
		logger.info("Locating payment method with XPATH {}", paymentXpath);
		WebElement paymentMethod = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(paymentXpath)));
		paymentMethod.click();

	}

	public void proceedToCheckout() {
		checkOut_1.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkOut_2));
		checkOut_2.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkOut_3));
		checkOut_3.click();
		wait.until(ExpectedConditions.visibilityOf(agreeToTermsCheckbox));
		if(!agreeToTermsCheckbox.isSelected()) {
			agreeToTermsCheckbox.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(checkOut_4));
		checkOut_4.click();
			
	}	
	
	public void confirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
		confirmOrder.click();
		wait.until(ExpectedConditions.visibilityOf(orderConfirmationSummary));
	}
	
	public String getOrderReference() {
		String summary = orderConfirmationSummary.getAttribute("innerText");
		String orderRef = summary.split("order reference")[1].trim().split(" ")[0];
		logger.info("Order reference is {}", orderRef.trim());
		return orderRef.trim();
		
	}

	public OrderSummaryPage navigateToOrderSummary() {
		wait.until(ExpectedConditions.visibilityOf(backToOrders));
		backToOrders.click();
		return new OrderSummaryPage();
		
	}

}
