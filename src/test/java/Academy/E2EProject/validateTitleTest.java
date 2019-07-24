package Academy.E2EProject;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;


public class validateTitleTest  extends base{
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url"));
	}
	@Test
	
	public void validateAppTitle() throws IOException
	{
		
		//one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
		 System.out.println("Test completed");
		 
		;
	
		
		}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}


}
