package StepDefination;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Factory.DriverFactory;
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Utils.CommonsUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	
	
	WebDriver driver;
	 
	private RegisterPage  registerPage;
	 
	private AccountSuccessPage accountsuccesspage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		 driver = DriverFactory.getDriver();
		 
		 HomePage homepage = new HomePage(driver);
		 
		 homepage.clickonMyAccount();
		  
		 registerPage = homepage.SelectRegisterOption();
		  
		
	   
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
	Map<String, String> datamap = dataTable.asMap(String.class, String.class);
	
	registerPage.EnterfirstName(datamap.get("firstName"));
	registerPage.EnterlastName(datamap.get("lastName"));
	registerPage.Enteremail(CommonsUtils.getEmailWithTimestamp());
	registerPage.Entertelephone(datamap.get("telephone"));
	registerPage.Enterpasswordtext(datamap.get("password"));
	registerPage.Enterpassconfirmfield(datamap.get("password"));

	

	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		
			registerPage.EnterfirstName(datamap.get("firstName"));
			registerPage.EnterlastName(datamap.get("lastName"));
			registerPage.Enteremail(CommonsUtils.getEmailWithTimestamp());
			registerPage.Entertelephone(datamap.get("telephone"));
			registerPage.Enterpasswordtext(datamap.get("password"));
			registerPage.Enterpassconfirmfield(datamap.get("password"));

	  
	}
	
	

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
	   registerPage.SelectPrivacypolicyOptionsfield();
	
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountsuccesspage = registerPage.ContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
	
		Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading());
		
		
		
		/*
		 * String Excepted = "Your Account Has Been Created!";
		 * 
		 * String Actual = driver.findElement(By.
		 * xpath("//h1[contains(text(),'Your Account Has Been Created!')]")).getText();
		 * 
		 * Assert.assertEquals(Excepted,Actual);
		 */
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() throws InterruptedException {
		
		Thread.sleep(2000);
		
		 registerPage.SelectYesNewsLetter();
		
		driver.findElement(By.xpath("(//input[@type='radio' and @value='1'])[2]")).click();
	
	}



	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
		
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields1() {
		

		registerPage.EnterfirstName("");
		registerPage.EnterlastName("");
		registerPage.Enteremail("");
		registerPage.Entertelephone("");
		registerPage.Enterpasswordtext("");
		registerPage.Enterpassconfirmfield("");

		
		
	 
	}
	

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field1() {
	  
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
		
	    Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarningMessage());
		
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningMessage());
	
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarningMessage());
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarningMessage());
		
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningMessage());
	}
		
	
	


	

}
