package Tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import Pages.HomePage;
import Pages.UserRegisterPage;
import junit.framework.Assert;

public class SearchProductCSV extends TestBase
{
	HomePage HomeObjects;
	UserRegisterPage UserPageObjects;
	CSVReader reader ;
	String CSVfile = (System.getProperty("user.dir")+"\\TestData\\UserTestData.csv");

	
	@BeforeTest
	public static void init()
	{
		
	}
	
	@Test
	public void SearchProduct() throws InterruptedException, IOException
	{
		
		reader = new CSVReader(new FileReader(CSVfile));
		String [] csvcell;
		while ((csvcell= reader.readNext()) != null)
		{
			String Product = csvcell[0];
			Reporter.log("Launch Application");
			HomeObjects = new HomePage(driver);
			HomeObjects.searchItem(Product);
			Reporter.log("Search For Product");
		String Assmsg=	driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
			Assert.assertTrue(Assmsg.contains("been found."));
			String proName= driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")).getText();
			  Assert.assertEquals(Product,proName );
				Reporter.log("Product appear in the search result");

			Thread.sleep(1000);
			HomeObjects.clearBar();
        //To clear Search bar to search with new value from CSV file.
			
			
	
		}
		

		

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
