package com.newsletter.selenium_frameworks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected WebDriver driver;
	protected String fileInputStream = "C://Users//dhara//data.properties";

	@BeforeSuite
	public void beforeSuite() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileInputStream);
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		Boolean headlessBrowser =  System.getProperty("headless") != null ? Boolean.parseBoolean(System.getProperty("headless")) : false;
		
		if(browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(headlessBrowser) {
				options.addArguments("headless");
			}
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			//It executes in Firefox Browser
			System.setProperty("webdriver.gecko.driver",  prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equals("IE"))
		{
			//It executes in Internet Explorer
			System.setProperty("webdriver.ie.driver",  prop.getProperty("internetExplorerPath"));
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
 	@AfterSuite
    public void afterSuite() {
        if(null != driver) {
        	driver.quit();        
            
        }
    }
	
	public WebDriver getDriver()
	{
		return driver;	
	}
}
