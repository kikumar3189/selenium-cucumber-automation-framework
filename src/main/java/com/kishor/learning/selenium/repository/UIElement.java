package com.kishor.learning.selenium.repository;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uiElement")
public class UIElement {
	
	String name;
	String locatorType;
	String locatorValue;
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "UiElement[ name="+name+", locatorType="+locatorType+
				", locatorValue="+locatorValue+"]";
	}
	
	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	public String getLocatorType() {
		return locatorType;
	}
	@XmlAttribute(name = "locatorType")
	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}
	
	
	public String getLocatorValue() {
		return locatorValue;
	}
	
	@XmlElement(name="locator")
	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}
	
	

}
