package Academy.E2EProject;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validationNavigationTest extends base{
	
@BeforeTest

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
		
	driver.get(prop.getProperty("url"));
}
	
	@Test
	
	public void validateAppNavBar() throws IOException
	{

		//one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
	
		//compare the text from the browser with actual text.- Error..
	    Assert.assertTrue(l.getNavigationBar().isDisplayed());
	    
		 System.out.println("Test completed");
	 //   Assert.assertFalse(false);
		;
	
		
		}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	
}
