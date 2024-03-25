package Cucumber.LoginDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class StepsDefinition {
	WebDriver driver;
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		// if browser is Chrome
			System.setProperty("webdriver.chrome.driver", "D:\\Applications\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();
	}
	@Then("User navigates to login page")
	public void user_navigates_to_login_page() {
		WebElement loginLink= driver.findElement(By.linkText("Log In"));
		String linkText=loginLink.getText();
		System.out.println("\nLog in Link Attributes:");
		System.out.println("Link Text:"+linkText);
		WebElement logLink = driver.findElement(By.xpath("//a[normalize-space()='Log In']"));
        logLink.click();
		throw new io.cucumber.java.PendingException();
	}

	@Then("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		 WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
	     WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		 uname.sendKeys("abc@gmail.com");
		 pass.sendKeys("12345");
		throw new io.cucumber.java.PendingException();
	}
	@SuppressWarnings("deprecation")
	@Then("Keeping case as Valid")
	public void keeping_case_as_Valid() {
	    WebElement loggedInMessage = driver.findElement(By.xpath("//div[@class='loggedInMessage']"));
	    // Assert that the element indicating successful login is present
	    Assert.assertTrue("User is not logged in", loggedInMessage.isDisplayed());

	    // Additional validation can be added if required
	}
	@When("Clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().window().maximize();
		//Finding link using xpath
		WebElement logLink = driver.findElement(By.xpath("//a[normalize-space()='Log In']"));
        logLink.click();
        WebElement sub = driver.findElement(By.xpath("//button[@type='submit']"));
        sub.click();
        Thread.sleep(1000);
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Login Successful");
		throw new io.cucumber.java.PendingException();
	}

	@When("User enters invalid email address and invalid password")
	public void user_enters_invalid_email_address_and_invalid_password() throws InterruptedException {
		// Write code here that turns the phrase above into concrete action
        WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		 uname.sendKeys("abc1@gmail.com");
		 pass.sendKeys("dfsd2");
		 Thread.sleep(1000);
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Invalid Credentials");
		throw new io.cucumber.java.PendingException();
	}

}