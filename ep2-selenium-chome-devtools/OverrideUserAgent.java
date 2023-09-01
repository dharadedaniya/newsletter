package Shopping;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.security.Security;
import org.openqa.selenium.devtools.v113.network.Network;

import com.google.common.collect.ImmutableList;

public class LoadInsecureSite {
	public static void main(String[] args) throws InterruptedException 
	{
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
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        // Override User Agents
        devTools.send(Network.setUserAgentOverride("Mozilla/5.0 (iPhone; CPU iPhone OS 16_5 like Mac OS X) 
                    AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/114.0.5735.99 Mobile/15E148 Safari/604.1",Optional.empty(),
                    Optional.empty(),Optional.empty()));
                    
        // Navigate to URL
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
	}
}