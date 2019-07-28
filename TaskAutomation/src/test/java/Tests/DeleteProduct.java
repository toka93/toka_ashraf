package Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import Pages.ProductPage;

public class DeleteProduct extends TestBase
{
	HomePage HomeObjects;
	UserRegisterPage UserPageObjects;
	ProductPage product;
	
	String Product="Blouse";

	
	@BeforeTest
	public static void init()
	{
		
	}
	
	@Test
	public void DeleteProduct( ) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		Reporter.log("Application Launch");
		HomeObjects = new HomePage(driver);
		HomeObjects.openRegisterPage();
		
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

		HomeObjects.deleteProduct();
		Reporter.log("Product is succesfully deleted");

		/*jsx.executeScript("window.scrollBy(0,450)", "");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your shopping cart is empty.")));

		

		String cardemptymsg= driver.findElement(By.xpath("//*[@id=\'center_column\']/p")).getText();		
		  Assert.assertEquals("Your shopping cart is empty.",cardemptymsg );
		
		*/


        
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
