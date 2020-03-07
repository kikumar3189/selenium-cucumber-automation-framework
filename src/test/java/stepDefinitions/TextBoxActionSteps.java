package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kishor.learning.selenium.context.WebPageContext;
import com.kishor.learning.selenium.repository.ObjectRepository;

import io.cucumber.java.en.When;

public class TextBoxActionSteps  {
	
	private static final Logger logger = LoggerFactory.getLogger(TextBoxActionSteps.class);
	@Autowired
	private WebPageContext context;
	
	@When("enters {string} as {string}")
	public void enters_as(String elementName, String value) throws Exception {	    
	    
	    WebElement textBox = context.findWebPageElement(elementName);
	    textBox.click();
	    textBox.clear();
	    textBox.sendKeys(value);	 
	    logger.debug("Entered value {} in textbox {}", value, elementName);
	    
	}
}
