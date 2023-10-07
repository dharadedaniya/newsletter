package Shopping;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.log.Log;
import org.openqa.selenium.devtools.v113.network.Network;

import com.google.common.collect.ImmutableList;

public class CaptureConsoleLogs {
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
	    
        devTools.send(Log.enable());

	    // Monitor network events
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("log: "+logEntry.getText());
            System.out.println("level: "+logEntry.getLevel());
        });
	    
        // Navigate to URL
        driver.get("https://www.google.com");
        devTools.send(Log.clear());
        devTools.send(Log.disable());
        
        // Quit the WebDriver
        driver.quit();
	}
}
