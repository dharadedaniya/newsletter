package com.newsletter.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
	}
}