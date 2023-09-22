package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Swag {

public WebDriver driver;
	
	public ExtentReports report;
	public ExtentTest test;
	
	Fillo fillo;
	Connection connection;
	
	@BeforeTest
	public void ReportSetup() throws FilloException {
		report= new ExtentReports("ExtentReport.html");
		
		fillo =new Fillo();
		connection=fillo.getConnection("Sheets.xlsx");
	}
	
	@BeforeMethod
	public void setup(Method method)
	{
		WebDriverManager.firefoxdriver().setup();
		
		test=report.startTest(method.getName());
		test.log(LogStatus.INFO, "Test should be started","test case started successfully");
		
		this.driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);	
		
		
	}
	@AfterMethod
	public void Teardown() {
		report.endTest(test);
		driver.quit();
		
	}
@AfterTest
	
	public void Reportclean() {
		
		report.flush();
		report.close();
	}
}
