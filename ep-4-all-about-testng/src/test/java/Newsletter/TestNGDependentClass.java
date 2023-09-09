package Newsletter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDependentClass {

	public WebDriver driver;
	@BeforeTest(alwaysRun = true)
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test(dependsOnMethods = {"LoginPage"})
	public void HomePage()
	{			
		System.out.println("Home Page");
	}
	
	@Test
	public void LoginPage()
	{	
		System.out.println("Login Page");
	}
	
		
	@AfterTest(alwaysRun = true)
	public void discontinueBRowser()
	{
		driver.close();
	}


}
