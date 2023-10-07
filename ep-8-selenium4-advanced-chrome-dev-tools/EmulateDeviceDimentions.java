package Shopping;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;
import org.openqa.selenium.devtools.v113.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v113.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v113.page.model.Viewport;

import com.google.common.collect.ImmutableList;

public class EmulateDeviceDimentions {
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
	    
        // Enable device emulation with specific dimensions
        devTools.send(Emulation.setDeviceMetricsOverride(500, 800, 50, true, Optional.<Number> empty(),
                Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
                Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
                Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));	
        
        // Navigate to URL
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
	}
}
