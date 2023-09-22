package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pageLogin.LoginPage_Swag;


public class Test_Swag extends BaseClass_Swag {

	
	@Test
	public void PositiveTest()
	{
		LoginPage_Swag login=new LoginPage_Swag(driver);
		login.Loginfun("standard_user", "secret_sauce");
	}
	
	@Test
	public void NegativeTest() throws FilloException
	{
		LoginPage_Swag login=new LoginPage_Swag(driver);
		
		Recordset recordset= connection.executeQuery("select * from data where TestName='NegativeTest'");
		recordset.next();
		
		String Username=recordset.getField("UserName");
		String password=recordset.getField("Password");
		login.Loginfun(Username,password);
		
		WebElement error=driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
		
		String Acterror=error.getText();
		String Experror="Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(Acterror, Experror);
	}
}
