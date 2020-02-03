package com.kishor.learning.selenium.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
	
	private static WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
	private static ChromeOptions chromeOptions;
	
	public static WebDriver getDriver()  {
		if(driver == null) {
			try {
				setDriver();
				driver.get(System.getProperty("appUrl"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	private static void setDriver() throws MalformedURLException {
		switch(System.getProperty("browser")) {
			case "chrome":
				DriverFactory.setChromeOptions();
				String os = System.getProperty("os.name").toLowerCase();
				if(os.contains("win")) {
					logger.info("Initialising chrome driver for windows...");
					System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
					driver = new ChromeDriver(chromeOptions);
					driver.manage().window().maximize();
					
				}else {
					logger.info("Initialising chrome driver for linux...");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
					URL serverUrl = new URL(System.getProperty("gridUrl"));
					driver = new RemoteWebDriver(serverUrl, capabilities);
				}
				
				break;
			case "IE":
				logger.info("Initialising IE driver...");
				System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				//Not implemented yet, still work in progress
				break;
			default:
				logger.info("Invalid browser specified, defaulting to chrome");
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver(chromeOptions);
				break;
		}
		
	}
	
	private static void setChromeOptions() {
		logger.debug("Setting chrome options...");
		chromeOptions = new ChromeOptions();
		if(System.getProperty("headless").equalsIgnoreCase("true")) {
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("start-maximized");		
		
		}
		
	}

}
