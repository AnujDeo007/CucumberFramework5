package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonsUtils;
import Utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	
	
	private ElementUtils elementUtils; 
	
	public LoginPage(WebDriver driver) {
		
	
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		elementUtils = new ElementUtils(driver);
			
	}
	
	
	
	@FindBy(id="input-email")
	
	private WebElement emailField;
	
	
	@FindBy(name="password")
	
	private WebElement passwordfield;
	
	
	@FindBy(xpath ="//input[@value='Login']")
	
	private WebElement loginbtn;
	
	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
	
	private WebElement warningmsg;
	
	
	
	
	
	public void EnteremailAddress(String emailtext) {
		
		
		elementUtils.typeTextIntoElement(emailField, emailtext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	
	public void Enterpassword(String pwdtext) {
		
		elementUtils.typeTextIntoElement(passwordfield, pwdtext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	
	}
	
	
public AccountPage LoginBtn() {
	
	  elementUtils.clickOnElement(loginbtn, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	   return new AccountPage(driver);
		
	}


 public String getWaringmsgtext() {
	 
	 return elementUtils.getTextFromElement(warningmsg, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	

 }
 
 

 
 



	

}
