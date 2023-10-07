package Shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;

public class GeoLocation {
	public static void main(String[] args) throws InterruptedException 
	{
        // Set the path to the chrome driver executable
		System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");

		// Create ChromeOptions to enable DevTools Protocol
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--disable-geolocation");
	    options.addArguments("--start-maximized");
	    
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--disable-notifications");
	    
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    Map<String, Object> profile = new HashMap<String, Object>();
	    prefs.put("googlegeolocationaccess.enabled", true);
	    prefs.put("profile.default_content_setting_values.geolocation", 1);
	    prefs.put("profile.default_content_setting_values.notifications", 1);
	    prefs.put("profile.managed_default_content_settings", 1);
	    options.setExperimentalOption("prefs", prefs);
	    
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		
        // Create a new instance of ChromeDriver with options
		WebDriver driver = new ChromeDriver(options);
				
        // Enable DevTools
	    DevTools devTools = ((ChromeDriver) driver).getDevTools();
	    devTools.createSession();
	    
	    // Enable the Network domain to intercept network requests
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        
        devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5200), Optional.of(13.4050), Optional.of(100)));

        // Navigate to a website
        driver.get("https://my-location.org/");
        
        Thread.sleep(50000);


        // Close the browser session
        driver.quit();
	}
}
