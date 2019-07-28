package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase 
{
	protected WebDriver driver;
	// create constructor take webdriver as param
	public PageBase(WebDriver driver )
	{
		//this mean the current class what you will use to read page
		PageFactory.initElements(driver, this);

	}
	
	
	
	// refactor 
	protected static void ClickButton(WebElement button)
	{
		button.click();
	}
	
	protected static void setTextElement(WebElement textElement , String Text)
	{
		textElement.sendKeys(Text);
	}
	
	


}
