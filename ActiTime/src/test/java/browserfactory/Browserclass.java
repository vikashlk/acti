package browserfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserclass {

	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver browserLaunch(String browser, String url) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
			driver= new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "./softwares/msedgedriver.exe");
			driver= new InternetExplorerDriver();
			
		}
		
	//	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(2000);
		
	return driver;
	}
	
	public static void tearDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		Thread.sleep(4000);
		driver.close();
	}
	
	
}
