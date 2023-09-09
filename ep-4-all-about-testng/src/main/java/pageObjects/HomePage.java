package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	
	 @FindBy(name="Country")
	 public WebElement country;
	 
	 @FindBy(name="Language")
	 public WebElement language;
	 
	 @FindBy(xpath="//*[text()='Submit']")
	 public WebElement submitButton;
	 
	 @FindBy(xpath="//div[@id='view-cart-preview']/following-sibling::a/span")
	 public WebElement getCountryName;
	 
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}		
}
