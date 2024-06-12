package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonsUtils;
import Utils.ElementUtils;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	
	private ElementUtils elementUtils; 
	
	
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	
	private WebElement pageHeading;
	
	
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
		elementUtils = new ElementUtils(driver);
		
		
	}
	
	
	public String getPageHeading() {
		
		return   elementUtils.getTextFromElement(pageHeading, CommonsUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	
	
	
	

}
