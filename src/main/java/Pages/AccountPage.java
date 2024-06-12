package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonsUtils;
import Utils.ElementUtils;

public class AccountPage {
	
	
	WebDriver driver;
	
	
	private ElementUtils elementUtils; 
	

	@FindBy(xpath = "[contains(text(),'Edit your account information'))]")
	
	private WebElement EdityourAccountInformation;
	
	
	

	public AccountPage(WebDriver driver) {
		
		  this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		 elementUtils = new ElementUtils(driver);
		
	}
	
	
	public  boolean displayStatusEditYourInformationoption() {
		
		return elementUtils.displayStatusOfElement(EdityourAccountInformation, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	
		
	
	}
	
	

}
