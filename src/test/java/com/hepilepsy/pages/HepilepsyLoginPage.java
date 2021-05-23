package com.hepilepsy.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hepilepsy.core.BasePage;

/***
 * 
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
    }
    
    public HepilepsyDashboardPage clickLoginBtn(){
    	forceSleep(3000);
    	logInBtn.click();
    	forceSleep(3000);
    	return new HepilepsyDashboardPage(driver);
    	
    }
    
}
