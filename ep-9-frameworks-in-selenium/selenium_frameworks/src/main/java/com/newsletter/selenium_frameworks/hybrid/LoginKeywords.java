package com.newsletter.selenium_frameworks.hybrid;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class LoginKeywords {
	private final WebDriver driver;

    public LoginKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) throws IOException {
        LoginPageHybrid loginPage = new LoginPageHybrid(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    
    public void logout() throws IOException {
        LoginPageHybrid loginPage = new LoginPageHybrid(driver);
        loginPage.logout();
    }
}
