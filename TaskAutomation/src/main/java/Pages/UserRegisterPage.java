package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends PageBase
{

	public UserRegisterPage(WebDriver driver) {
		super(driver);

	}
	// find Elements
	@FindBy (id="email")
	WebElement email ;
	@FindBy(id="passwd")
	WebElement pass;
    @FindBy(id="SubmitLogin")
    WebElement signin;
    
	@FindBy (id="email_create")
	public WebElement RegisterEmail ;
	
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]/span")
	public WebElement CreateButton ;
	
	@FindBy(linkText="Forgot your password?")
	public WebElement Forgetlink ;

	
	public void Login(String Email , String password)
	{
		setTextElement(email,Email);
		setTextElement(pass,password);

		ClickButton(signin);
		
	}
	public void createaccount(String Email1)
	{

		setTextElement(RegisterEmail,Email1);

		ClickButton(CreateButton);
	}
	

	public void Forgetpassword()
	{

		
		ClickButton(Forgetlink);
	}
	
	
	
	
}
