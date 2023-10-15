package com.newsletter.selenium_framework_pages.DataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newsletter.common.BasePage;


public class LoginPage extends BasePage 
{      
    By userName = By.xpath("//*[@id='userId-text-input-field']");
    By passWordLocator = By.xpath("//*[@id='password-text-input-field']");
        
    public LoginPage(WebDriver driver) throws IOException {
       super(driver);
    }
     
    public void enterUsername(String username) {
    	driver.findElement(userName).sendKeys(username);
    }

	public void enterPassword(String password){
    	driver.findElement(passWordLocator).sendKeys(password);
    }        
}

