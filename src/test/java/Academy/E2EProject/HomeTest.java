package Academy.E2EProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class HomeTest extends base{

	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@Test(dataProvider = "getData")
	public void baseNavigation(String username, String password) throws IOException, InterruptedException 
	{
		
		driver = initializeDriver();
		log.info("Driver is initialized");
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("Navigate to the homepage");	
		LoginPage loginOb = new LoginPage(driver);
	//	l.getLogin().click();
		loginOb.enterUsername().sendKeys(username);
		loginOb.enterPassword().sendKeys(password);
		loginOb.Login().click();
		Thread.sleep(5000);
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][2];
		data[0][0] = "nishankjain09@gmail.com";
		data[0][1] = "nishankjain09";
		data[1][0] = "divya09@gmail.com";
		data[1][1] = "divyajain09";
		
		return data;
		
	}
}
	