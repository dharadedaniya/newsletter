public class CaptureConsoleLogs {
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
	    
        devTools.send(Log.enable());

	    // Monitor network events
        devTools.addListener(Log.entryAdded(), log -> {
            System.out.println("log: "+log.getText());
            System.out.println("level: "+log.getLevel());
        });
	    
        // Navigate to URL
        driver.get("https://www.google.com");
        devTools.send(Log.clear());
        devTools.send(Log.disable());
        
        // Quit the WebDriver
        driver.quit();
	}
}