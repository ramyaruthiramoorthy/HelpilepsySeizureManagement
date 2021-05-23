package com.hepilepsy.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.helpilepsy.core.BasePage;

/***
 * class HepilepsyDashboardPage implements element search and actions.
 * @author Ramya
 *
 */
public class HepilepsyDashboardPage extends BasePage {
	JavascriptExecutor executor;
	// Add Seizure Element
	@FindBy(xpath = "//div[text()='Add']")
	private WebElement addBtn;
	
	// Seizer Dash board Element
	@FindBy(xpath = "(//span[@class='ng-binding ng-scope'])[2]")
	private WebElement dayBtn;


    public HepilepsyDashboardPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    
    public void clickAddBtn(){
    	addBtn.click();
    }
    
    public HepilepsyJournalPage clickDayBtn(){
		executor.executeScript("arguments[0].scrollIntoView();", dayBtn);
		executor.executeScript("arguments[0].click();", dayBtn);
    	return new HepilepsyJournalPage(driver);
    }
    
}
