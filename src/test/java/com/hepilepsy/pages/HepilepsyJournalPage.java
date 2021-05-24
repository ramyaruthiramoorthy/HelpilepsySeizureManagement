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
public class HepilepsyJournalPage extends BasePage {
	
	//Seizer for edit
	@FindBy(xpath = "(//div[@ng-click='editSeizure(s)'])[1]")
	private WebElement pickSeizerBtn;
	//
	// Home Button Element
	@FindBy(xpath = "(//div[@class='img'])[1]")
	private WebElement homeBtn;

    public HepilepsyJournalPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    } 
    
    public HepilepsyManageSeizurePage clickpickSeizerBtn(){
    	executor.executeScript("arguments[0].click();", pickSeizerBtn);
    	// force sleep to what option is selected
    	forceSleep(3000);
    	return new HepilepsyManageSeizurePage(driver);
    }
    
    public HepilepsyDashboardPage clickHomeBtn(){
    	executor.executeScript("arguments[0].click();", homeBtn);
    	// force sleep for service to respond
    	forceSleep(3000);
    	return new HepilepsyDashboardPage(driver);
    } 
  
}
