import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;

import java.util.Optional;


public class HTTPRequestMonitoring{
	
	@SuppressWarnings("deprecation")
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
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.send(Network.setRequestInterception(null));

	    // Monitor network events                  	 
	    devTools.addListener(Network.requestWillBeSent(), l -> {
	        System.out.println("--------------------------------------");
	        System.out.print("Request URL: ");
	        System.out.println(l.getRequest().getUrl());
	        System.out.println("--------------------------------------");
	    });

	    devTools.addListener(Network.requestWillBeSent(), l -> {
	        System.out.println("--------------------------------------");
	        System.out.print("Request Method: ");
	        System.out.println(l.getRequest().getMethod());
	        System.out.println("--------------------------------------");
	    });
	    
	    devTools.addListener(Network.requestWillBeSent(), l -> {
	        System.out.println("--------------------------------------");
	        System.out.print("Request Headers: ");
	        l.getRequest().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
	        System.out.println("--------------------------------------");
	    });
	    
        // Navigate to URL
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
	}
}
