package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
  @Test
  public void successfullLogin_Test() {
	  login.enterUsername("standard_user");
	  login.enterPassword("secret_sauce");
	  login.Submit();
	  login.selectItems();
	  
  }
  
  @Test
  public void wrongUsername_Test() {
	  login.enterUsername("invalid_user");
	  login.enterPassword("secret_sauce");
	  login.Submit();
	  
	  // Verify error message is displayed
	  Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message should be displayed for wrong username");
	  String errorText = login.getErrorMessage();
	  Assert.assertTrue(errorText.contains("Epic sadface") || errorText.contains("do not match"), 
			  "Error message should indicate login failure");
  }
  
  @Test
  public void wrongPassword_Test() {
	  login.enterUsername("standard_user");
	  login.enterPassword("wrong_password");
	  login.Submit();
	  
	  // Verify error message is displayed
	  Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message should be displayed for wrong password");
	  String errorText = login.getErrorMessage();
	  Assert.assertTrue(errorText.contains("Epic sadface") || errorText.contains("do not match"), 
			  "Error message should indicate login failure");
  }
  
  @Test
  public void wrongUsernameAndPassword_Test() {
	  login.enterUsername("invalid_user");
	  login.enterPassword("wrong_password");
	  login.Submit();
	  
	  // Verify error message is displayed
	  Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message should be displayed for wrong credentials");
	  String errorText = login.getErrorMessage();
	  Assert.assertTrue(errorText.contains("Epic sadface") || errorText.contains("do not match"), 
			  "Error message should indicate login failure");
  }
  
  @Test
  public void lockedOutUser_Test() {
	  login.enterUsername("locked_out_user");
	  login.enterPassword("secret_sauce");
	  login.Submit();
	  
	  // Verify error message is displayed
	  Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message should be displayed for locked out user");
	  String errorText = login.getErrorMessage();
	  Assert.assertTrue(errorText.contains("locked out"), 
			  "Error message should indicate user is locked out");
  }
}
