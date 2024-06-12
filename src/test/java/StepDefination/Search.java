package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.SearchResultPage;
import io.cucumber.java.en.*;

public class Search {
	
	public WebDriver driver;
	
	private HomePage homepage ;
	
	private SearchResultPage searchresultpage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
		
	}
	
	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validproduct) {
		

         homepage.enterProductIntoSearchbox(validproduct);
		
		 driver.findElement(By.name("search")).sendKeys(validproduct);
	  
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchresultpage = homepage.ClickonSerachbutton();
		
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
	  
	  Assert.assertTrue(searchresultpage.displaystatusoftheValidProduct());
	   
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
		
		   
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchbox(invalidproduct);

	   
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
	
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchresultpage.getmessageText());
	   
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		homepage =  new HomePage(driver);
	    
	}

}
