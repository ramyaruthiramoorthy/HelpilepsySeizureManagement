package com.hepilepsy.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hepilepsy.core.BasePage;

/***
 * class HepilepsyDashboardPage implements element search and actions.
 * @author Ramya
 *
 */
public class HepilepsyDashboardPage extends BasePage {
	// Add Seizure Element
	@FindBy(xpath = "//div[text()='Add']")
	private WebElement addBtn;
	@FindBy(xpath = "//div[@class='title'][text()='Add an event']")
	private WebElement addEventWindowTitle;
	@FindBy(xpath = "//div[text()='Seizure']")
	private WebElement seizerEventBtn;
	
	// Seizer Dash board Element
	@FindBy(xpath = "//div[@class='label ng-binding now']")
	private WebElement dayBtn;
	
	// Logout  elements
	@FindBy(xpath = "//i[@class='helpi-settings']")
	private WebElement settingsBtn;


    public HepilepsyDashboardPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    
    public void clickAddBtn(){
    	addBtn.click();
    }
    
    public String validateAddEventWindowTitle(){
    	waitForElementToAppear(addEventWindowTitle);
    	return addEventWindowTitle.getText();
    }
    
    public HepilepsyManageSeizurePage clickSeizureEventBtn(){
	  	executor.executeScript("arguments[0].click();", seizerEventBtn);
	  	return new HepilepsyManageSeizurePage(driver);
    }
  
    public HepilepsyJournalPage clickDayBtn(){
		executor.executeScript("arguments[0].scrollIntoView();", dayBtn);
		executor.executeScript("arguments[0].click();", dayBtn);
    	return new HepilepsyJournalPage(driver);
    }
    
    public HepilepsySettingsPage clickSettingsBtn(){
    	executor.executeScript("arguments[0].click();", settingsBtn);
    	forceSleep(3000);
    	return new HepilepsySettingsPage(driver);
    }
    
}
