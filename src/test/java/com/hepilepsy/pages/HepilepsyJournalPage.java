package com.hepilepsy.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.helpilepsy.core.BasePage;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyJournalPage extends BasePage {
	
	JavascriptExecutor executor;
	@FindBy(xpath = "(//div[@ng-click='editSeizure(s)'])[1]")
	private WebElement pickSeizerBtn;

    public HepilepsyJournalPage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    } 
    
    public HepilepsyManageSeizurePage clickpickSeizerBtn(){
    	forceSleep(3000);
    	executor.executeScript("arguments[0].click();", pickSeizerBtn);
    	return new HepilepsyManageSeizurePage(driver);
    	
    }
  
}
