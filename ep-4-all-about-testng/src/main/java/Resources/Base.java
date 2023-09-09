package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.CatelogPage;
import pageObjects.ContinueAsGuestPage;
import pageObjects.HomePage;

public class Base 
{
	protected static WebDriver driver;	
	protected static DevTools devtools;
	protected String siteUrl;
	protected String countryName;
	protected String language;
	protected String expectedCountryName;
	protected static String menuElementName;
	protected static String nailsColor;
	protected static HomePage homepage;
	protected static CatelogPage catelog;
	protected static ContinueAsGuestPage conAsGuest;
	protected static CartPage cart;
	protected static Actions action;
	protected static JavascriptExecutor javascript;
	protected static WebDriverWait wait;
	protected static String expectedSolidColorPageTitle;
	protected static String expectedAddedProductCount;
	protected static String expectedAddedProudctCountInCart;
	protected static String expectedAddedProudctCountInCartAfterAddition;
	protected static String expectedFindAStylistPopupText;
	protected static String expectedGetSignInPageTitle;
	protected static String zipcode;
	protected static String expectedGetShippingPageTitle;

	public WebDriver initilizeDriver() throws IOException
	{		
		Properties prop = new Properties();	
		FileInputStream fis  = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//data.properties");
		prop.load(fis);
		siteUrl = prop.getProperty("siteURL");
		countryName = prop.getProperty("countryName");
		language = prop.getProperty("language");
		expectedCountryName = prop.getProperty("expectedCountryName");
		menuElementName= prop.getProperty("menuElementsName");
		nailsColor = prop.getProperty("nailsColor");
		expectedSolidColorPageTitle = prop.getProperty("solidColorPageTitle");
		expectedAddedProductCount = prop.getProperty("expectedAddedProductCount");
		expectedAddedProudctCountInCart = prop.getProperty("expectedAddedProudctCountInCart");
		expectedAddedProudctCountInCartAfterAddition = prop.getProperty("expectedAddedProudctCountInCartAfterAddition");
		expectedFindAStylistPopupText = prop.getProperty("expectedFindAStylistPopupText");
		expectedGetSignInPageTitle = prop.getProperty("expectedGetSignInPageTitle");
		zipcode = prop.getProperty("zipcode");
		expectedGetShippingPageTitle = prop.getProperty("expectedGetShippingPageTitle");	
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			//It executes in Chrome Browser
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        devtools = ((ChromeDriver) driver).getDevTools();
	        devtools.createSession();
			driver = new ChromeDriver(options);			
		}
		else if(browserName.equals("firefox"))
		{
			//It executes in Firefox Browser
			System.setProperty("webdriver.gecko.driver",  prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equals("IE"))
		{
			//It executes in Internet Explorer
			System.setProperty("webdriver.ie.driver",  prop.getProperty("internetExplorerPath"));
			driver = new InternetExplorerDriver();
		}

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;	
		
		
	}
}
