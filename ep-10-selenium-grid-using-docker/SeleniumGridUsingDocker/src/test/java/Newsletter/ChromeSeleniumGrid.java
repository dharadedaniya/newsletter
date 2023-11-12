package Newsletter;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeSeleniumGrid {

	public WebDriver driver;
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{	
		ChromeOptions chromeOptions = new ChromeOptions();


		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		driver.get("https://www.google.com/");






	}
	
	@Test
	@Parameters({ "browser"})
	public void testmethodA(String browser)
	{	
		System.out.println("BrowserName: "+ browser);		
	}
		
	@AfterMethod
	public void discontinueBrowser()
	{
		driver.close();
	}


}
