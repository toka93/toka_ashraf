package Tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserRegisterPage;
import junit.framework.Assert;

public class SearchAndView extends TestBase
{
	HomePage HomeObjects;
	UserRegisterPage UserPageObjects;
	String Product="Blouse";

	
	@BeforeTest
	public static void init()
	{
		
	}
	
	@Test
	public void SearchAndView() 
	{
		
		
			Reporter.log("Launch Application");
			HomeObjects = new HomePage(driver);
			HomeObjects.searchItem(Product);
			Reporter.log("Search For Product");
		String Assmsg=	driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
			Assert.assertTrue(Assmsg.contains("been found."));
			String proName= driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")).getText();
			  Assert.assertEquals(Product,proName );
				Reporter.log("Product appear in the search result");
				JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");
				HomeObjects.viewproduct(driver);
				
				Reporter.log("Product pop upis opened successfully");


			
			
	
		

		

	}
	@AfterMethod
	public  void takescreenshot(ITestResult result) throws IOException
	{
	
			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File("./Images/"+result.getName()+".png"));
		
		
	}

	
	@AfterTest
	public static void close()
	{
    	driver.quit();
	}


	
}
