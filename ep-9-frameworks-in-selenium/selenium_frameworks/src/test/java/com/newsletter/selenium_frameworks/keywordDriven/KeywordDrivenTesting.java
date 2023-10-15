package com.newsletter.selenium_frameworks.keywordDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.newsletter.selenium_frameworks.BaseTest;

public class KeywordDrivenTesting extends BaseTest {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
    	String fileInputStream = "C://Users//dhara//eclipse-workspace//automation_framework_from_scratch//src//main//java//Resources//data.properties";

        Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileInputStream);
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));

		WebDriver driver = new ChromeDriver();

        // Read data from Excel or any other data source
        String[][] testData = {
                {"Open","", "https://secure02ea.chase.com/web/auth/#/logon/logon/chaseOnline?treatment=chase&lang=en"},
                {"Input", "username", "testuser"},
                {"Click", "loginButton", ""},
                {"Verify", "welcomeMessage", "Welcome, User"}
        };

        // Execute test steps from the testData array
        for (String[] row : testData) {
            String keyword = row[0];
            String locator = row[1];
            String value = row[2];

            // Perform actions based on the keywords
            switch (keyword) {
                case "Open":
                    driver.get(value);
                    driver.manage().window().maximize();
                    break;
                case "Input":
                    driver.findElement(By.id(locator)).sendKeys(value);
                    break;
                case "Click":
                    driver.findElement(By.id(locator)).click();
                    break;
                case "Verify":
                    String actualText = driver.findElement(By.id(locator)).getText();
                    assert actualText.equals(value) : "Verification failed!";
                    break;
                default:
                    System.out.println("Invalid keyword: " + keyword);
            }
        }

        // Close the browser
        driver.quit();
    }
}

