package Academy.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By signin = By.cssSelector("a[href*='sign_in']");
	By username = By.id("user_email");
	By password = By.id("user_password");
	By LoginButton = By.name("commit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement enterUsername(){
		return driver.findElement(username);
	}
	
	public WebElement enterPassword(){
		return driver.findElement(password);
	}
	
	public WebElement Login(){
		return driver.findElement(LoginButton);
	}
}
