package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatelogPage
{
	public WebDriver driver;
	
	 @FindBy(xpath="//ul[@id='desktop-nav-menu']/li/a/span")
	 public List<WebElement> getMenuElements;
	 
	 @FindBy (xpath="//*[@class='sub-menu']/div[2]/div/div[1]/ul[2]/li/a")
	 public List<WebElement> getSubmenuElements;
	 
	 @FindBy(xpath="//*[@id='view-item-list']/div/div/div[3]/div")
	 public List<WebElement> getListItems;
	 
	 @FindBy(xpath="//*[@id='view-item-list']/div/div/div[3]/div/div/div/div/div[2]/button")
	 public List<WebElement> addToCartButton;
	 
	 @FindBy(xpath="//*[@id='top-header-bar']/div/div[2]/div/a[2]/span[2]/span")
	 public WebElement addedProducts;
	 
	 public CatelogPage(WebDriver driver) 
		{
			this.driver = driver;
			//PAGE FACTORY
			PageFactory.initElements(driver, this);
		}
}
