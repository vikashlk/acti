package objectfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElements {
	WebDriver driver;
	
	@FindBy(name="username")
	private WebElement user;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(id="loginButton")
	private WebElement button;
	
	public void action(String usernames, String passcode) throws InterruptedException {
		Thread.sleep(3000);
	 user.sendKeys(usernames);
	 password.sendKeys(passcode);
	 button.click();
	}

	
	

}
