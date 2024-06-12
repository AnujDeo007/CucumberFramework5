package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonsUtils;
import Utils.ElementUtils;

public class RegisterPage {
	
	
	WebDriver driver;
	
	private ElementUtils elementUtils; 
	
	@FindBy(id="input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastnamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
    @FindBy(id="input-password")
	private WebElement passwordfield;

    @FindBy(id="input-confirm")
     private WebElement confimfield;
	
    @FindBy(name="agree")
    private WebElement privacypolicyOptions1;
	
  
    @FindBy(xpath ="//input[@value='Continue']")
    private WebElement ContinueBtn;
    
   
    @FindBy(xpath ="(//input[@type='radio' and @value='1'])[2]")
    private WebElement YesNewLetteroption;
    
    
    @FindBy(xpath ="//div[contains(text(),'Warning: E-Mail Address is already registered!')]")
    private WebElement warningmessage;
    
    @FindBy(xpath ="//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement firstnamewarningmessage;
    
    @FindBy(xpath ="//div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement lastnamewarningmessage;
    
    
    @FindBy(xpath ="//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailwarningmessage;
    
    
    @FindBy(xpath ="//div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement telephonewarningmessage;
    
    @FindBy(xpath ="//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement passwordwarningmessage;

 


	
	public RegisterPage(WebDriver driver) {
		
		  this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		elementUtils = new ElementUtils(driver);
		
	}
	
	
	public void EnterfirstName(String firstnametext) {
		
		
		elementUtils.typeTextIntoElement(firstnamefield, firstnametext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	
	}
	
	
	
	public void EnterlastName(String lastnametext) {
		
		
		elementUtils.typeTextIntoElement(lastnamefield, lastnametext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	
	
	public void Enteremail(String emailtext) {
		
		
		elementUtils.typeTextIntoElement(emailfield, emailtext,CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
	
	
	
	public void Entertelephone(String telephonetext) {
		
		
		elementUtils.typeTextIntoElement(telephonefield, telephonetext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	
	public void Enterpasswordtext(String pwdtext) {
		
		elementUtils.typeTextIntoElement(passwordfield, pwdtext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	
		
	}
	
	
	public void Enterpassconfirmfield(String pwdconfirmtext) {
		
		
		elementUtils.typeTextIntoElement(confimfield, pwdconfirmtext, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		confimfield.sendKeys(pwdconfirmtext);
			
		}
		
	
	
	
	public void SelectPrivacypolicyOptionsfield() {
		
		
		elementUtils.clickOnElement(privacypolicyOptions1, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
			
		}
		
	
	public AccountSuccessPage ContinueButton() {
		
		
		elementUtils.clickOnElement(ContinueBtn, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	     return new AccountSuccessPage(driver);
			
		}
	
	
	
	public void SelectYesNewsLetter() {
		
		  elementUtils.clickOnElement(YesNewLetteroption, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	      YesNewLetteroption.click();
			
		}
	
	
	public String  getWarningMessageText() {
		
		
		return elementUtils.getTextFromElement(warningmessage,CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	 	
		}
	
	
  
     public String getFirstNameWarningMessage() {
    	 
    	 
    		return elementUtils.getTextFromElement(firstnamewarningmessage, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
 	
		}
	
     
     
     public String getLastNameWarningMessage() {
 		
    		return elementUtils.getTextFromElement(lastnamewarningmessage, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
  
			
		}
	
     
     public String getEmailWarningMessage() {
 		
 		return elementUtils.getTextFromElement(emailwarningmessage, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 
			
		}
	
     
     public String getTelephoneWarningMessage() {
  		
 		return elementUtils.getTextFromElement(telephonewarningmessage, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
			
 		}
 	
     
     public String getPasswordWarningMessage() {
  		
    		return elementUtils.getTextFromElement(passwordwarningmessage, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
			
 		}
 	
 	
	
	

}
