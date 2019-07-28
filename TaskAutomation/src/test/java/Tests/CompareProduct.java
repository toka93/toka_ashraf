package Tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserRegisterPage;
import Pages.ProductPage;

import junit.framework.Assert;

public class CompareProduct extends TestBase
{
	HomePage HomeObjects;
	UserRegisterPage UserPageObjects;
	ProductPage product;
	
	String Product="Blouse";

	
	@BeforeTest
	public static void init()
	{
		
	}
	@DataProvider(name="userData")
	 	public static Object[][] UserDatavalues()
	 	{
		  return new Object [][]
				  {
			  {"tokaashraf1993@gmail.com","P@ssw0rd"}
			  
				  };
	 	}
	@Test(dataProvider="userData")
	public void EditProduct(String Email , String password) throws InterruptedException
	{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		Reporter.log("Application Launch");
		HomeObjects = new HomePage(driver);
		HomeObjects.openRegisterPage();
		Reporter.log("Login With Valid Creditinals");
		UserPageObjects = new UserRegisterPage(driver);
		UserPageObjects.Login(Email, password);
        WebDriverWait wait = new WebDriverWait(driver, 60); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-account"))); 
      
    String accTitle= driver.findElement(By.linkText("My account")).getText();
	  Assert.assertEquals("My account",accTitle );

		Reporter.log("Login succeeded");
		HomeObjects.searchItem(Product);
		Reporter.log("Search for specific product");
		HomeObjects.addtocompare(driver);
		jsx.executeScript("window.scrollBy(0,450)", "");

		HomeObjects.gotoCompare();
		String comapretitle= driver.findElement(By.xpath("//*[@id=\'center_column\']/h1")).getText();		
		  Assert.assertEquals("PRODUCT COMPARISON",comapretitle );
		
		
			Reporter.log("Product is added to compare list");

		
		
		
		
		

	



        
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
