package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.kishor.learning.selenium.context.WebPageContext;

import io.cucumber.java.en.Then;

public class VerifyActionSteps {
	
	@Autowired
	private WebPageContext context;
	
	@Then("{string} should be displayed as {string}")
	public void should_be_displayed_as(String elementName, String expectedValue) throws Exception {
		WebElement element = context.findWebPageElement(elementName);
		String actualValue = element.getText().trim();
		Assert.assertTrue("Error: Expected value:" + expectedValue
				+ ", actual value:" + actualValue, expectedValue.equals(actualValue));
	
	}

}
