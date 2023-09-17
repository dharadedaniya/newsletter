package com.newsletter.automation_framework_from_scratch;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage 
{      
    By userName = By.xpath("//*[@id='userId-text-input-field']");
    By passWord = By.xpath("//*[@id='password-text-input-field']");
        
    public LoginPage(WebDriver driver) throws IOException {
       super(driver);
    }
     
    public void enterUsername(String username) {
    	driver.findElement(userName).sendKeys("Username123");
    }
    public void enterPassword(String password){
    	driver.findElement(passWord).sendKeys("Password123");
    }        
}

