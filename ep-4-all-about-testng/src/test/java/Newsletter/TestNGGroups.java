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

public class TestNGGroups {

	public WebDriver driver;
	@BeforeTest(alwaysRun = true)
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test(groups = {"smoke"})
	public void smokeTest()
	{	
		System.out.println("******************");
		System.out.println("Smoke Test");
		System.out.println("******************");
	}
	
	@Test(groups = {"regression"})
	public void regressionTest()
	{	
		System.out.println("Regression Test");
	}
	
		
	@AfterTest(alwaysRun = true)
	public void discontinueBRowser()
	{
		driver.close();
	}


}
