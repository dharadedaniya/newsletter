import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.BlockedReason;
import org.testng.Assert;

import com.google.common.collect.ImmutableList;

public class BlockURL {
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
	    
	    String urlToBlock = "https://fonts.gstatic.com/";
        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of(urlToBlock)));

	    // Monitor network events
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println("Blocking reason: " + loadingFailed.getBlockedReason().get());
        });
	    
        // Navigate to URL
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
	}


}
