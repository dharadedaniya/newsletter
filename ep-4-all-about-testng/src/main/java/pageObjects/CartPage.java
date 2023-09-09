package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	public WebDriver driver;
	
	@FindBy (xpath="//span[text()='Shopping Bag']")
	public WebElement shoppingBag;
	
	@FindBy(xpath="//*[@data-widget='cart']/div/div/div/div[2]/div/a")
	public List<WebElement> addedProudctCountInCart;
	
	@FindBy(xpath="//*[@id='shoppingMenuNavBar']/div[2]/a")
	public WebElement checkoutButton;
	
	@FindBy(xpath="//div[@class='modal fade in']/div/div")
	public WebElement returnToCatalogPopUp;
	
	@FindBy(xpath="//div[@class='modal-footer text-center-mobile']/a[1]")
	public WebElement returnToCatalogButton;
	
	
	public CartPage(WebDriver driver) 
	{	
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
}
