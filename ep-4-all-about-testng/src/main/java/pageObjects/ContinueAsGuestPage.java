package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContinueAsGuestPage
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Continue as Guest']")
	public WebElement continueAsGuest;
	
	@FindBy(xpath="//*[@id='hearAboutUsModal']/div/div/div[1]/h3/strong")
	public WebElement findAStylistText;
	
	@FindBy(xpath="/html/body/div[7]/div/main/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[1]/div/div[1]/input")
	public WebElement zipCode;
	
	@FindBy(xpath="/html/body/div[7]/div/main/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[1]/div/div[1]/a")
	public WebElement zipcodeSearchButton;
	
	@FindBy(xpath="//*[@id='hearAboutUsModal']/div/div")
	public WebElement listOfStylistPopup;
	
	@FindBy(xpath="//*[@id='zip-search-results']")
	public WebElement StylishResult;
	
	@FindBy(xpath="//*[@id='zip-search-results']/div/div[2]/a[2]")
	 public List<WebElement> getListOfStylist;
	
	
	public ContinueAsGuestPage(WebDriver driver) 
	{
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}

}
