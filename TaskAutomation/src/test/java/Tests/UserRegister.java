package Tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import Pages.RegisterAccount;
import junit.framework.Assert;

public class UserRegister extends TestBase
{
	HomePage HomeObjects;
	UserRegisterPage UserPageObjects;
	ProductPage product;
	RegisterAccount RegisterAccount;
	
	@BeforeTest
	public static void init()
	{
		
	}
	@DataProvider(name="RegisterInfo")
	 	public static Object[][] UserDatavalues()
	 	{
		  return new Object [][]
				  {
			  {"friendseason2@outlook.com","Mon","Geller","P@ssw0rd","Add.231ST","SomeWhere","00000","01000000331","AddM"}
			  
				  };
	 	}
	@Test(dataProvider="RegisterInfo")
	public void UserRegister(String Email , String fname,String lname,String pass,String add,String city,String Postal,String mob,String alias)
	{
		Reporter.log("Application Launch");
		HomeObjects = new HomePage(driver);
		HomeObjects.openRegisterPage();
		Reporter.log("Create an Account");
		UserPageObjects = new UserRegisterPage(driver);
		UserPageObjects.createaccount(Email);
		RegisterAccount = new RegisterAccount(driver);
		RegisterAccount.completeRegister(fname, lname, pass, add, city, Postal, mob, alias);
		
       WebDriverWait wait = new WebDriverWait(driver, 60); 
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-account"))); 
        
   String accTitle= driver.findElement(By.linkText("My account")).getText();
	 Assert.assertEquals("My account",accTitle );

		Reporter.log("Account Registered Successfully");

        
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
