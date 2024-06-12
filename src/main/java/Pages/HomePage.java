package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonsUtils;
import Utils.ElementUtils;

public class HomePage {
	
	
	WebDriver driver ;
	
	private ElementUtils elementUtils; 
	
	  public HomePage(WebDriver driver) {
		  
		  this.driver = driver;
		  
		  PageFactory.initElements(driver, this);
		  
		  elementUtils = new ElementUtils(driver);
		  
	  }
	  
	  @FindBy(xpath = "//span[text()='My Account']")
	  private WebElement myAccountDropDownmeanu;
	  
	  
	  @FindBy(linkText = "Login")
	  private WebElement loginOption;
	  
	  @FindBy(linkText = "Register")
	  private WebElement Regsiterlink;
	  
	  @FindBy(name = "search")
	  private WebElement  searchBoxfield;
	  
	  @FindBy(xpath = "//button[@type='button' and @class='btn btn-default btn-lg']")
	  private WebElement  searchbtn;
	  
	  
	  
	  public void clickonMyAccount() {
		  
		  elementUtils.clickOnElement(myAccountDropDownmeanu, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		  
	  }
	  
	  
  public LoginPage SelectLoginOption() {
	  
	      elementUtils.clickOnElement(loginOption, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		  
		  return new LoginPage(driver);
		  
	  }
	
  
  public RegisterPage SelectRegisterOption() {
	  
	  elementUtils.clickOnElement(Regsiterlink, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	 
	  return new RegisterPage(driver);
	  
  }
	
  
  
  public void enterProductIntoSearchbox(String producttext) {
	  
	  elementUtils.typeTextIntoElement(searchBoxfield, producttext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	   
  }
  
 public SearchResultPage  ClickonSerachbutton() {
	  
	 
	 elementUtils.clickOnElement(searchbtn, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	  
	 return new SearchResultPage(driver);
	  
	  
  }
	
	

}
