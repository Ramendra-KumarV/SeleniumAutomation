package com.auto.test.DriverPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.auto.test.Utility.DriverPath;

public class InitilizeWebDriver {
	static WebDriver driver =null;
	public static WebDriver DriverObject(String browserName) {
		if(browserName.equalsIgnoreCase("CHROME") && driver== null) {
			System.setProperty("webdriver.chrome.driver", DriverPath.chromeBrowser);
					
		}else if(browserName.equalsIgnoreCase("FIREFOX") && driver== null) {
			System.setProperty("webdriver.gecko.driver", DriverPath.fireFoxBrowser);
			driver = new FirefoxDriver();
		}
		return driver;
	}
			
	
}
