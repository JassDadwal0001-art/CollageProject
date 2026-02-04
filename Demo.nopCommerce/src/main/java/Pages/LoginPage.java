package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		private By username = By.id("user-name");
		private By password = By.id("password");
		private By submit = By.id("login-button");
		private By selectItem = By.xpath("//*[@id=\"item_4_title_link\"]/div");
		private By errorMessage = By.cssSelector("[data-test='error']");
		
		public void enterUsername(String user)
		{
			driver.findElement(username).sendKeys(user);
		}
		
		public void enterPassword(String pass)
		{
			driver.findElement(password).sendKeys(pass);
		}
		
		public void Submit()
		{
			driver.findElement(submit).click();;
		}
		
		
		public void selectItems()
		{
			driver.findElement(selectItem).click();
		}
		
		public String getErrorMessage()
		{
			return driver.findElement(errorMessage).getText();
		}
		
		public boolean isErrorMessageDisplayed()
		{
			try {
				return driver.findElement(errorMessage).isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
}
