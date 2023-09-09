package Newsletter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataProvider {

	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	
	@Test(dataProvider ="loginPageData",dataProviderClass = Newsletter.TestNGDataProvider.class)
	public void testmethodA(String username, String password)
	{	
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
	}
		
	@DataProvider(name="loginPageData")
	public Object[][] getLoginData(){
		return new Object[][] {
			{"username123","password123"},
			{"username456","password456"},
			{"username789","password789"},
		};
	}
	@AfterMethod
	public void discontinueBrowser()
	{
		driver.close();
	}


}
