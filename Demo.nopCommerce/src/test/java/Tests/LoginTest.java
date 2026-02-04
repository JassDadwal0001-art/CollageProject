package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest {
  @Test
  public void successfullLogin_Test() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUsername("standard_user");
//	  login.wrongUsername("locked_out_user");
	  login.enterPassword("secret_sauce");
	  login.Submit();
	  login.selectItems();
	  
  }
}
