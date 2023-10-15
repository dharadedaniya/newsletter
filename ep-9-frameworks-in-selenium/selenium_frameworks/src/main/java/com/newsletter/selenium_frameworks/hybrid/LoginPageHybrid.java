package com.newsletter.selenium_frameworks.hybrid;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.newsletter.common.BasePage;

public class LoginPageHybrid extends BasePage{
		By userName = By.xpath("//*[@id='userId-text-input-field']");
	    By passWordLocator = By.xpath("//*[@id='password-text-input-field']");
	    By loginLocator = By.xpath("//*[@id='login']");
	    By logoutLocator = By.xpath("//*[@id='logout']");
	        
	    public LoginPageHybrid(WebDriver driver) throws IOException {
	       super(driver);
	    }
	     
	    public void enterUsername(String username) {
	    	driver.findElement(userName).sendKeys(username);
	    }

		public void enterPassword(String password){
	    	driver.findElement(passWordLocator).sendKeys(password);
	    } 
		
		public void clickLogin(){
			driver.findElement(loginLocator).click();
	    }
		
		public void logout(){
	    	driver.findElement(logoutLocator).click();
	    } 
}
