package com.kishor.learning.selenium;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import com.kishor.learning.selenium.pages.HomePage;
import com.kishor.learning.selenium.pages.LoginPage;
import com.kishor.learning.selenium.pages.MyAccount;
import com.kishor.learning.selenium.pages.OrderSummaryPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = SeleniumCucumberFrameworkApplication.class, 
loader = SpringBootContextLoader.class)
public class Steps {
	
	@Autowired
	private LoginPage loginPage; 
	private HomePage homePage;
	private OrderSummaryPage orderSummaryPage;
	private MyAccount myAccount;
	private static final Logger logger = LoggerFactory.getLogger(Steps.class);
	HashMap<String, String> variables = new HashMap<>();
	
	
	@When("user logs in by entering below credentials")
	public void user_logs_in_by_entering_below_credentials(DataTable dataTable) {

	    List<Map<String, String>> params = dataTable.asMaps();
	    String username = params.get(0).get("username");
	    String password = params.get(0).get("password");
	    homePage = loginPage.performLogin(username, password);
	    Assert.assertTrue("Login Error: Home page is not displayed", homePage.isHomePageDisplayed());
	    
	}


	@When("user navigates to TShirts section")
	public void user_navigates_to_tshirts() {
		homePage.navigateToTShirts();	    
		Assert.assertTrue(homePage.isTShirtsSectionDisplayed());
	
	}

	@When("user adds item {string} to the cart")
	public void add_item_to_cart(String item) {
	    homePage.addItemToCart(item);
	}
	
	@And("user proceeds to checkout")
	public void proceed_to_checkout() {
	    homePage.proceedToCheckout();
	}
	
	@And("user selects payment method as {string}")
	public void user_selects_payment_method(String method) {
	    homePage.selectPaymentMethod(method);
	}
	
	@And("user confirms the order")
	public void user_confirms_order() {
		homePage.confirmOrder();
	}
	
	@And("user saves order reference in {string}")
	public void user_saves_order_reference(String variable) {
		String orderRef = homePage.getOrderReference();
		variables.put(variable, orderRef);
	}
	
	@And("user navigates back to orders")
	public void navigateToOrderSummary() {
		orderSummaryPage = homePage.navigateToOrderSummary();
		Assert.assertTrue("Order summary not displayed", orderSummaryPage.isOrdersTableDisplayed());
	}
	
	@And("user validates that order {string} is present in order history")
	public void check_order(String orderReference) {
		if(orderReference.startsWith("$")) {
			//$ indicates that orderReference is a variable
			orderReference = variables.get(orderReference);
		}
		logger.info("Validating order {}", orderReference);
		Assert.assertTrue("Order refernce " + orderReference + " not found"
				, orderSummaryPage.checkPresenceOfOrder(orderReference));
		
	}
	
	@And("user navigates to my account")
	public void navigateToMyAccount() {
		myAccount = homePage.goToMyAccount();
	}



	@When("user updates first name as {string} using password {string}")
	public void user_updates_firstname_as(String name, String password) {
	    myAccount.updateFirstName(name, password);
	   
	}
	
	@Then("validate account name is {string}")
	public void validate_account_name(String expectedName) {
		String actualName = myAccount.getAccountName();
		Assert.assertTrue("Error: Expected Name= " + expectedName + ", Actual Name= "+
		actualName, actualName.equalsIgnoreCase(expectedName));
	}
	
	



}
