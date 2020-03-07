package com.kishor.learning.selenium.repository;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pages")
public class Pages {
	
	List<Page> webPages;
	
	@Override
	public String toString() {
		return "Pages = ["+webPages+"]";
	}

	public List<Page> getWebPages() {
		return webPages;
	}
	
	@XmlElement(name = "page")
	public void setWebPages(List<Page> webPages) {
		this.webPages = webPages;
	}	

}
