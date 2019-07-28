package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterAccount extends PageBase
{

	public RegisterAccount(WebDriver driver) {
		super(driver);

	}
	// find Elements
	
	
	@FindBy(id="customer_firstname")
	public WebElement Fname ;
	
	@FindBy(id="customer_lastname")
	public WebElement Lname ;
	
	@FindBy(id="passwd")
	public WebElement Pass ;
	
	@FindBy(id="firstname")
	public WebElement First ;
	
	@FindBy(id="lastname")
	public WebElement Last ;
	
	@FindBy(id="address1")
	public WebElement Add ;
	
	@FindBy(id="city")
	public WebElement City ;
	
	@FindBy(id="id_state")
	public WebElement State ;
	
	@FindBy(id="postcode")
	public WebElement Post ;
	
	@FindBy(id="id_country")
	public WebElement Country ;
	
	@FindBy(id="phone_mobile")
	public WebElement Mobile ;
	
	@FindBy(id="alias")
	public WebElement Alias ;
	
	@FindBy(id="submitAccount")
	public WebElement Regbutton ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void completeRegister(String fname, String lname, String pass,
			String add,String city,String Postal,String mob ,String alias)	
	
	{
		setTextElement(Fname,fname);
		setTextElement(Lname,lname);
		setTextElement(Pass,pass);
		setTextElement(Add,add);
		setTextElement(City,city);

		new Select(State).selectByVisibleText("Hawaii");
		setTextElement(Post,Postal);

		new Select(Country).selectByVisibleText("United States");
		setTextElement(Mobile,mob);
		setTextElement(Alias,alias);

		ClickButton(Regbutton);

		
	}
	
	

	
	
	
}
