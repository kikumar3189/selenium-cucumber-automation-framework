package com.kishor.learning.selenium.repository;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ObjectRepository {
	/*
	 * To fetch locator attributes for application objects
	 */
	
	private Pages webPages;
	private static final Logger logger = LoggerFactory.getLogger(ObjectRepository.class);
	
	@PostConstruct
	public void loadRepository() throws JAXBException {
		/*
		 * Loads object repository on start
		 */
		File file = new File("src/main/resources/objectRepository.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pages.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		webPages = (Pages) jaxbUnmarshaller.unmarshal(file);
		
	}
	
	public By getElementLocator(String pageName, String elementName) throws Exception {
		
		Page page;
		page = getWebPage(pageName);
		
		for (UIElement element: page.getUiElements()) {
			if(element.getName().equals(elementName)) {
				return getLocator(element);
			}
		}		
		throw new ElementNotFoundInRepositoryException("Element: " + elementName + " not found in repository");
	}

	private By getLocator(UIElement element) throws Exception {
		
		if(element.getLocatorType().equalsIgnoreCase("id")) {
			return By.id(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("xpath")) {
			return By.xpath(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("className")) {
			return By.className(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("name")) {
			return By.name(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("cssSelector")) {
			return By.cssSelector(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("linkText")) {
			return By.linkText(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("partialLinkText")) {
			return By.partialLinkText(element.getLocatorValue());
		}else if(element.getLocatorType().equalsIgnoreCase("tagName")) {
			return By.tagName(element.getLocatorValue());
		}else {
			throw new Exception("Invalid locator type: " + element.getLocatorType());
		}
		
		
	}

	private Page getWebPage(String pageName) throws PageNotFoundException {
		for(Page page : webPages.getWebPages()) {
			if(page.getPageName().equals(pageName)) {
				return page;
			}
		}
		throw new PageNotFoundException("WebPage" + pageName + " not found");
	}
	
	

	

}
