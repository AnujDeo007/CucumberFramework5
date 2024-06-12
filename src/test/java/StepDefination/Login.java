package StepDefination;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.CommonsUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	 WebDriver driver ;
	
	private	LoginPage loginpage ;
	
	private AccountPage accountPage;
	 
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		
		HomePage homepage = new HomePage(driver);
		
		homepage.clickonMyAccount();
	 
		loginpage = homepage.SelectLoginOption();
	  
	}
	
	
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailtext) {
		
	
		  loginpage.EnteremailAddress(emailtext);
		
	}

    @And("^User enters valid password (.+)into password field$")
	public void user_enters_valid_password_into_password_field(String passwordtext) {
    	
    	loginpage.Enterpassword(passwordtext);
    	
    
	}

	/*
	 * @When("User enters valid email address {string} into email field") public
	 * void user_enters_valid_email_address_into_email_field(String emailtext) {
	 * 
	 * 
	 * loginpage.EnteremailAddress(emailtext);
	 * 
	 * }
	 * 
	 * @And("User enters valid password {string} into password field") public void
	 * user_enters_valid_password_into_password_field(String passwordtext) {
	 * 
	 * loginpage.Enterpassword(passwordtext);
	 * 
	 * 
	 * }
	 */

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
	     accountPage= loginpage.LoginBtn();
	    
	}

	@Then("User should get successfully Logged in")
	public void user_should_get_successfully_logged_in() {
				
		Assert.assertTrue(accountPage.displayStatusEditYourInformationoption());
	    
	}

//-------------------------------------Scenario 2------------------------------------------------------
	
	@Given("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	    
		loginpage.EnteremailAddress(CommonsUtils.getEmailWithTimestamp());
		
		
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasswordtext) {
	 
		
		 loginpage.Enterpassword(invalidpasswordtext);
		
	}

	@And("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		
		
		Assert.assertTrue(loginpage.getWaringmsgtext().contains("Warning: No match for E-Mail Address and/or Password."));
	 

	}
	/*
	 * @And("User enters invalid email address into email field") public void
	 * user_enters_invalid_email_address_into_email_field() {
	 * 
	 * 
	 * //driver.findElement(By.id("input-email")).sendKeys();
	 * 
	 * 
	 * }
	 */

	@Then("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginpage.EnteremailAddress("");
	   
	}
	
	

	@Then("User dont enter password into password field")
	public void User_dont_enter_password_into_password_field() {
		
		loginpage.Enterpassword("");
	   
	}
	
	

	

	
	
	
	
	
}
