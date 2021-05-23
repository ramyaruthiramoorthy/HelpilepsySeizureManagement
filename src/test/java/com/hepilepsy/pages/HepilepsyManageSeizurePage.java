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
public class HepilepsyManageSeizurePage extends BasePage {
	
	JavascriptExecutor executor;
	
	// Add Seizure Elements
	@FindBy(xpath = "//div[text()='Seizure']")
	private WebElement seizerEventBtn;
	@FindBy(xpath = "//span[text()='Select type']")
	private WebElement seizerTypeDrpdwn;
	@FindBy(xpath = "(//span[text()='Generalized absence seizure '])[1]")
	private WebElement selectSeizerTypeOption;
	@FindBy(xpath = "//input[@id='felt_no']")
	private WebElement feltNoRadioBtn;
	@FindBy(xpath = "//span[text()='Save Seizure']")
	private WebElement saveSeizerBtn;
	//Info box
	@FindBy(xpath = "//div[@class='info']")
	private WebElement infoBox;
	@FindBy(xpath = "(//button[text()='Ok'])[1]")
	private WebElement okBtn;
	
	// Edit Seizure Elements
	@FindBy(xpath = "//span[text()='Generalized absence seizure ']")
	private WebElement typeDrpDwn;
	@FindBy(xpath = "(//span[text()='Focal aware seizure'])[1]")
	private WebElement modifySeizerTypeOption;
	@FindBy(xpath = "//div[text()='Save']")
	private WebElement saveAfterEditBtn;

    public HepilepsyManageSeizurePage(WebDriver driver) {
        super(driver);
    }	

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    
	public void clickSeizerBtn(){

		executor.executeScript("arguments[0].click();", seizerEventBtn);

	}

	public void selectType(){

		executor.executeScript("arguments[0].click();", seizerTypeDrpdwn);
	}

	public void selectTypeOption(){

		executor.executeScript("arguments[0].click();", selectSeizerTypeOption);
	}

	public void selectFeltOption(){
		executor.executeScript("arguments[0].click();", feltNoRadioBtn);
		
	}

	public void saveSeizer() {

		executor.executeScript("arguments[0].scrollIntoView();", saveSeizerBtn);
		forceSleep(2000);
		executor.executeScript("arguments[0].click();", saveSeizerBtn);
	}

	public String infoMessageValidation() {
		
		String infoMessage = infoBox.getText();
		System.out.println("Info message: " + infoMessage);
		return infoMessage;

	}
     
    public HepilepsyDashboardPage clickOkBtn(){
    	forceSleep(3000);
    	executor.executeScript("arguments[0].click();", okBtn);
    	return new HepilepsyDashboardPage(driver);
    	
    }
  
}
