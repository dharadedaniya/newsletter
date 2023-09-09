package Newsletter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseWithAndWithoutPriority {

	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test(priority = 1)
	public void testmethodA()
	{	
		System.out.println("Test Method A");
	}
	
	@Test(priority = 2)
	public void testmethodB()
	{		
		System.out.println("Test Method B");
	}
	
	@Test
	public void testmethodC()
	{		
		System.out.println("Test Method C");
	}
	
		
	@AfterMethod
	public void discontinueBRowser()
	{
		driver.close();
	}


}
