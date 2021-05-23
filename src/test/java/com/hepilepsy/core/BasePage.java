package com.hepilepsy.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * 
 * The BasePage class abstracts all the common functions used across the application by page classes.
 * @author Ramya
 *
 */
public class BasePage {
	
    protected WebDriver driver;
    private WebDriverWait wait;

    // poll for every ms
    private static final int POLLING = 1000;
    // timeout for page loading
	private static final int LOADING_TIMEOUT = 5;
    

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, LOADING_TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, LOADING_TIMEOUT), this);
    }

    // not required at this moment
    protected void waitForTextToDisappear(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }
    
    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

   /***
    * force wait to see the actions and navigations
    * @param sleepInMillis
    */
   protected void forceSleep(long sleepInMillis){
	   try {
           Thread.sleep(sleepInMillis);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
	
}