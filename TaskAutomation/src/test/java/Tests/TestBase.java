package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase 
{
	// initalize driver and close driver
	static String ChromePath = (System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");	

	public static WebDriver driver;
	@BeforeTest
	@Parameters({"browser"})
	public void init( @Optional("chrome") String BrowserName)
	{
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
		System.out.println("launching chrome browser"); 
		System.setProperty("webdriver.chrome.driver",ChromePath);
		}
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void closeDriver ()
	{
		//driver.quit();
	}

}
