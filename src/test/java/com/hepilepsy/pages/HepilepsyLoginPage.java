package com.hepilepsy.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hepilepsy.core.BasePage;

/***
 * class HepilepsyLoginPage implements functions related to login page.
 * @author Ramya
 *
 */
public class HepilepsyLoginPage extends BasePage {
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement userEmailId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement userPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement logInBtn;

    public HepilepsyLoginPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    
    public void setUserId(String emailId){
       // set EmailId
    	userEmailId.sendKeys(emailId);
    }
    
    public void setUserPassword(String password){
        //set Password
       	userPassword.sendKeys(password);	
    	// force wait to show users/testers what values are entered
    	forceSleep(3000);
    }
    
    public HepilepsyDashboardPage clickLoginBtn(){
    	logInBtn.click();
    	forceSleep(5000);
    	return new HepilepsyDashboardPage(driver);
    }
    
}
