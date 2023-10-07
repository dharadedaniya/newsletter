package Shopping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Cookie;

public class ValidatingCookie {
	public static void main(String[] args) throws InterruptedException 
	{
        // Set the path to the chrome driver executable
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");

		// Create ChromeOptions to enable DevTools Protocol
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--headless");
	    options.addArguments("--remote-allow-origins=*");
	    
        // Create a new instance of ChromeDriver with options
		WebDriver driver = new ChromeDriver(options);
				
        // Enable DevTools
	    DevTools devTools = ((ChromeDriver) driver).getDevTools();
	    devTools.createSession();
	    
	    // Enable the Network domain to intercept network requests
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Navigate to a website
        driver.get("https://google.com");

        // Retrieve cookies from the DevTools session
        List<Cookie> cookies = devTools.send(Network.getAllCookies());
        cookies.forEach(cookie -> System.out.println(cookie.getName()));

        // Close the browser session
        driver.quit();
	}
}
