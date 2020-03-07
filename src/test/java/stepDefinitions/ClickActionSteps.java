package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kishor.learning.selenium.context.WebPageContext;

import io.cucumber.java.en.When;

public class ClickActionSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(ClickActionSteps.class);
	@Autowired
	private WebPageContext context;
	
	@When("clicks {string} button")
	public void clicks_button(String elementName) throws Exception {
		WebElement element = context.findWebPageElement(elementName);
	    element.click();
	    logger.debug("Clicked button {}", elementName);
	    
	}


}
