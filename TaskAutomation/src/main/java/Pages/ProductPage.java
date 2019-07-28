package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase
{

	public ProductPage(WebDriver driver) {
		super(driver);

	}
	// find Elements
	
	
	@FindBy(linkText="Sign out")
	public WebElement SignoutButton ;
	
  

	
	public void Signout( )
	{
		
		ClickButton(SignoutButton);
		
	}
	

	

	
	
	
}
