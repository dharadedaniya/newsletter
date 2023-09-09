package Newsletter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test
	@Parameters({ "username", "password"})
	public void testmethodA(String username, String password)
	{	
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
	}
		
	@AfterMethod
	public void discontinueBrowser()
	{
		driver.close();
	}


}
