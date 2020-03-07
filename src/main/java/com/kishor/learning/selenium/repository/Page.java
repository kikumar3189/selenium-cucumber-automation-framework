package com.kishor.learning.selenium.repository;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "page")
public class Page {
	
	String pageName;
	
	List<UIElement> uiElements;

	@Override
	public String toString() {
		return "Page[ name="+pageName+", uiElements="+uiElements+"]";
	}
	
	public String getPageName() {
		return pageName;
	}
	
	@XmlAttribute(name = "name")
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<UIElement> getUiElements() {
		return uiElements;
	}

	@XmlElement(name = "uiElement")
	public void setUiElements(List<UIElement> uiElements) {
		this.uiElements = uiElements;
	}
	
	

}
