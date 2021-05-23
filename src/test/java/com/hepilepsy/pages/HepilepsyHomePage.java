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
public class HepilepsyHomePage extends BasePage {

	// Login Page elements
	@FindBy(xpath = "(//div[@class='nb-swipe-selector ng-scope'])[2]")
	private WebElement swipeBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Let')][contains(text(),'s go')]")
	private WebElement letsGoBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]")
	private WebElement navigateToLoginPageBtn;
	
    public HepilepsyHomePage(WebDriver driver) {
        super(driver);
    }	
    
    public void loadHomePage(String homePageUrl){
    	driver.get(homePageUrl);
    }
    
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    
    public Boolean isClickSwipeBtnVisible(){
    	return swipeBtn.isDisplayed();
    }
    
    public void clickSwapButton(){
    	waitForElementToAppear(swipeBtn);
    	swipeBtn.click();
    }
    
    public boolean isLetsGoBtnVisible(){
    	return letsGoBtn.isDisplayed();
    }
    
    public void clickLetsGoButton(){
    	waitForElementToAppear(letsGoBtn);
    	letsGoBtn.click();
    }
    
    public HepilepsyLoginPage clickNavigateToLoginBtn(){
    	waitForElementToAppear(navigateToLoginPageBtn);
    	navigateToLoginPageBtn.click();
    	forceSleep(2000);
    	return new HepilepsyLoginPage(driver);
    }
    
}
