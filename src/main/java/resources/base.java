package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Nishank.Jain\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					".\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else{
			System.setProperty("webdriver.ie.driver",
						".\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\Nishank.Jain\\Desktop\\SeleniumJava\\automation"+result+"screenshot.png"));
		}
	
}
