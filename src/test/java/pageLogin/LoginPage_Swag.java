package pageLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Swag {

	public WebDriver Pagedriver;
	
	//=============obj============
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(name="login-button")
	WebElement Login;
	
	//=============mtd================
	
	public LoginPage_Swag(WebDriver driver)
	{
		Pagedriver=driver;
		PageFactory.initElements(Pagedriver, this);
		
	}
	
	public void Loginfun(String username, String Passwordname)
	{
		Username.sendKeys(username);
		Password.sendKeys(Passwordname);
		Login.click();
	}
}
