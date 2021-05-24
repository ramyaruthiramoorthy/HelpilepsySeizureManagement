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
public class HepilepsySettingsPage extends BasePage {
	// Logout  element
	@FindBy(xpath = "//div[text()='Log out']")
	private WebElement logoutBtn;

    public HepilepsySettingsPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    } 
    
	public HepilepsyLoginPage clickLogout()
	{	
		executor.executeScript("window.scrollBy(0,1000)");
		// force sleep to see if the screen is scrolled
		forceSleep(5000);
		logoutBtn.click();
		// force sleep to see what value is selected
		forceSleep(5000);
		return new HepilepsyLoginPage(driver); 
	}

  
}
