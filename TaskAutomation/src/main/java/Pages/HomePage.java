package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);

	}
	// find Elements
	
	
	@FindBy(linkText="Sign in")
	public WebElement SigninButton ;
	
	@FindBy(id="search_query_top")
	public WebElement SearchBar ;
	
  
	@FindBy(xpath="//*[@id=\'center_column\']/ul/li/div/div[1]/div/a[1]/img")
	public WebElement hoverElement ;
	
	@FindBy(xpath="//*[@id=\'center_column\']/ul/li/div/div[1]/div/a[2]")
	public WebElement quickView ;
	
	@FindBy(xpath="//*[@id=\'add_to_cart\']/button")
	public WebElement addToCart ;
	
	@FindBy(linkText="Proceed to checkout")
	public WebElement Checkout1 ;
	
	@FindBy(name="processAddress")
	public WebElement Checkout2 ;
	
    @FindBy(id="cgv")
    public WebElement TermsBox ;

    @FindBy(name="processCarrier")
    public WebElement Checkout3 ;
    
    @FindBy(xpath="//*[@id=\'HOOK_PAYMENT\']/div[1]/div/p/a")
    public WebElement PayBank ;

    @FindBy(xpath="//*[@id=\'cart_navigation\']/button")
    public WebElement ConfirmOrder ;

    
    @FindBy(linkText="Add to Compare")
    public WebElement AddToCompare ;

    @FindBy(xpath="//*[@id=\'center_column\']/div[2]/div/form/button")
    public WebElement Compare ;

    @FindBy(xpath="//*[@id=\'quantity_wanted_p\']/a[2]/span/i")
    public WebElement IncreaseQuantity ;
    
    @FindBy(xpath="//*[@id=\'2_7_0_0\']/i")
    public WebElement DeleteButton ;

	
	
	
	public void openRegisterPage( )
	{
		
		ClickButton(SigninButton);
		
	}
	
	
	public void searchItem(String Product )
	{
		
		setTextElement(SearchBar,Product);
		SearchBar.submit();
		
		
	}
	

	
	public void viewproduct(WebDriver driver )
	{
		
		Actions builder = new Actions(driver);
		builder.moveToElement(hoverElement).perform();
		ClickButton(quickView);
		
	}
	public void addtocompare(WebDriver driver )
	{
		
		Actions builder = new Actions(driver);
		builder.moveToElement(hoverElement).perform();
		ClickButton(AddToCompare);
		
	}
	
	
	public void clearBar( )
	{
		
		SearchBar.clear();
		
	}
	
	public void AddToCart( )
	{
		
		ClickButton(addToCart);
		
	}
	
	
	
	public void proceedToCheckout1( )
	{
		
		ClickButton(Checkout1);
		
	}
	
	
	public void proceedToCheckout2( )
	{
		
		ClickButton(Checkout2);
		
	}
	
	
	public void CheckTerms( )
	{
		
		ClickButton(TermsBox);
		
	}
	
	public void proceedToCheckout3( )
	{
		
		ClickButton(Checkout3);
		
	}
	
	
	public void payBank( )
	{
		
		ClickButton(PayBank);
		
	}
	
	public void confirmOrder( )
	{
		
		ClickButton(ConfirmOrder);
		
	}

	public void gotoCompare( )
	{
		
		ClickButton(Compare);
		
	}
	
	public void increasequantity( )
	{
		
		ClickButton(IncreaseQuantity);
		
	}
	public void deleteProduct( )
	{
		
		ClickButton(DeleteButton);
		
	}
	
}


