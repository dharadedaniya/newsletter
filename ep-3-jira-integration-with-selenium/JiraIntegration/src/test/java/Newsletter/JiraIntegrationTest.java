package Newsletter;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.utility.JiraCreateIssue;

public class JiraIntegrationTest {

	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setup() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C://data.properties");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void JiraHomePageText()
	{
		driver.get(baseUrl);
		WebElement el2 = driver.findElement(By.xpath("//h1[0]"));
		assertEquals(el2.getText(),"Home Page","Comparsirion of Home Page Header Text");
	}
}
