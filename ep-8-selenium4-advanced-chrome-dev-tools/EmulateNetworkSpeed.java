package Shopping;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;

import com.google.common.collect.ImmutableList;

public class EmulateNetworkSpeed {
	public static void main(String[] args) throws InterruptedException 
	{
        // Set the path to the chrome driver executable
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");

		// Create ChromeOptions to enable DevTools Protocol
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--remote-allow-origins=*");
	    
        // Create a new instance of ChromeDriver with options
		WebDriver driver = new ChromeDriver(options);
				
        // Enable DevTools
	    DevTools devTools = ((ChromeDriver) driver).getDevTools();
	    devTools.createSession();
	    
	    // Enable network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Emulate Slow 3G network conditions
        devTools.send(Network.emulateNetworkConditions(false, 100, 10000, 5000, Optional.of(ConnectionType.CELLULAR3G)));
	    
        // Navigate to URL
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
	}
}
