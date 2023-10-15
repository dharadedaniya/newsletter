package com.newsletter.selenium_frameworks.hybrid;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newsletter.selenium_framework_pages.DataDriven.LoginPage;
import com.newsletter.selenium_frameworks.BaseTest;
import com.newsletter.utilities.TestData;

public class HybridTest extends BaseTest
{
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() throws IOException {
    	driver = getDriver();
        driver.get("https://secure02ea.chase.com/web/auth/#/logon/logon/chaseOnline?treatment=chase&lang=en");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "testData")
    public void validLoginTest(String testcase,String username,String password) throws IOException 
    {
    	LoginKeywords keywords = new LoginKeywords(driver);
    	keywords.login(username, password);
   	 	 System.out.println("Testcase: " + testcase);
    	 System.out.println("Username: " + username);
         System.out.println("Password: " + password);

    }
}
