package stepDefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import com.kishor.learning.selenium.context.WebPageContext;

import io.cucumber.java.en.When;

public class NavigationActionSteps {
	@Autowired
	private WebPageContext context;
	
	@When("user navigates to {string} page")
	public void user_navigates_to_page(String pageName) {
	    context.setCurrentPageContext(pageName);
	}

  
}
