import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.model.RequestId;
import org.openqa.selenium.devtools.v113.network.Network;

public class HTTPResponseMonitoring{		
    public static void main(String[] args)
    {
        // Set the path to the chrome driver executable
        System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");

        // Create ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        
        // Create a new instance of ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
                
        // Enable DevTools
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        final RequestId[] requestIds = new RequestId[1];
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    
        // Monitor network events		    
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (responseReceived.getResponse().getUrl().contains("google.com")) {
                System.out.println("URL: " + responseReceived.getResponse().getUrl());
                System.out.println("Status: " + responseReceived.getResponse().getStatus());
                System.out.println("Type: " + responseReceived.getType().toJson());
                responseReceived.getResponse().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
                requestIds[0] = responseReceived.getRequestId();
                System.out.println(requestIds);
                System.out.println("Response Body: \n" + devTools.send(Network.getResponseBody(requestIds[0])).getBody() + "\n");
            }
        });
        
        // Navigate to a webpage
        driver.get("https://google.com/");
        
        // Quit the WebDriver
        driver.quit();
    }
}
