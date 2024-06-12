package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class SearchResultPage {
	
	
	
	WebDriver driver;
	
	
	private ElementUtils elementUtils; 
	
	
	public SearchResultPage(WebDriver driver) {
		
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
		elementUtils = new ElementUtils(driver);
		
	}
	
	
	@FindBy(linkText = "HP LP3065")
	
	 private WebElement validproduct;
	
	

	 @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	
	 private WebElement messagetext;
	
	
	public boolean displaystatusoftheValidProduct() {
		
		return validproduct.isDisplayed();
	}
	
	
	public String getmessageText() {
		
		return elementUtils.getTextFromElement(messagetext, 30);
	
	}
	

}
