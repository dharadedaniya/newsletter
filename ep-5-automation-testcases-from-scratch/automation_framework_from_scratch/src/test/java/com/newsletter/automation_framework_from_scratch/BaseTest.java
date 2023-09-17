package com.newsletter.automation_framework_from_scratch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected WebDriver driver;
	protected String fileInputStream = "C://Users//eclipse-workspace//automation_framework_from_scratch//src//main//java//Resources//data.properties";

	@BeforeSuite
	public void beforeSuite() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileInputStream);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			//It executes in Chrome Browser
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
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
	}
	
 	@AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
	
	public WebDriver getDriver()
	{
		return driver;	
	}
}
