package com.hepilepsy.core;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * Class BaseTest defines basic functions of testing framework to initiate 
 * webdriver and manage it's life cycle.
 * 
 * @author Ramya
 *
 */
public class BaseTest {
	
	protected static WebDriver driver;
	
	@Parameters({ "browserType"})
	@BeforeSuite
	public void beforeSuite(String browserType) throws IOException {
		
		if(browserType.equalsIgnoreCase("Chrome"))
		{
			// trigger chrome browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("Edge"))
		{
			// ms edge browser
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("Firefox"))
		{
			//geckodriver - firefox browser
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	/***
	 * afterSuite function closes the driver and quit from the execution.
	 */
	@AfterSuite
	public void afterSuite() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}