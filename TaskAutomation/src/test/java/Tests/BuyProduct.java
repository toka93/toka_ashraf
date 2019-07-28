package Tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class BuyProduct extends TestBase
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
	public void BuyProduct(String Email , String password) throws InterruptedException
	{
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

		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		HomeObjects.viewproduct(driver);
		Reporter.log("click on product Quick View");

		Thread.sleep(2000);
		 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		HomeObjects.AddToCart();
		Reporter.log("Add Product to cart");

		HomeObjects.proceedToCheckout1();
		Reporter.log("Start Order product process");

		jsx.executeScript("window.scrollBy(0,450)", "");
		HomeObjects.proceedToCheckout1();
		jsx.executeScript("window.scrollBy(0,800)", "");
		HomeObjects.proceedToCheckout2();
		jsx.executeScript("window.scrollBy(0,800)", "");
		HomeObjects.CheckTerms();
		jsx.executeScript("window.scrollBy(0,800)", "");
		HomeObjects.proceedToCheckout3();
		jsx.executeScript("window.scrollBy(0,800)", "");
		HomeObjects.payBank();
		jsx.executeScript("window.scrollBy(0,800)", "");
		HomeObjects.confirmOrder();
		String orderinfo= driver.findElement(By.xpath("//*[@id='center_column']/div/p/strong")).getText();		
		  Assert.assertEquals("Your order on My Store is complete.",orderinfo );

			Reporter.log("Order is created succesfully");

		
		
		
		
		

	



        
	}

	@AfterMethod
	public  void takescreenshot(ITestResult result) throws IOException
	{
	
			// create reference of take screenshot
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
