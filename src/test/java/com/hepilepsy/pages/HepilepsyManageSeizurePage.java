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
public class HepilepsyManageSeizurePage extends BasePage {
	
	// Add Seizure Elements
	@FindBy(xpath = "//span[text()='Select type']")
	private WebElement seizerTypeDrpdwn;
	@FindBy(xpath = "(//span[text()='Generalized absence seizure '])[1]")
	private WebElement selectSeizerTypeOption;
	@FindBy(xpath = "//input[@id='felt_no']")
	private WebElement feltNoRadioBtn;
	@FindBy(xpath = "//span[text()='Save Seizure']")
	private WebElement saveSeizerBtn;
	
	//select type Warning elements
	@FindBy(xpath = "//div[@class='info']")
	private WebElement warningBox;
	@FindBy(xpath = "(//button[@class='btn-dark'][text()='Close'])[2]")
	private WebElement warningCloseBtn;
	
	//Navigate back to dashboard - Elements
	@FindBy(xpath = "//div[text()='Back']")
	private WebElement backBtn;
	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement confirmBtn;
    
	//Add seizure Element
	@FindBy(xpath = "//div[text()='Add']")
	private WebElement addBtn;
	@FindBy(xpath = "//div[text()='Seizure']")
	private WebElement seizerEventBtn;
	
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
    
    // Add Seizure Methods
	public void selectType(){
		waitForElementToAppear(seizerTypeDrpdwn);
		executor.executeScript("arguments[0].click();", seizerTypeDrpdwn);
		// force sleep to see what value is selected
		forceSleep(3000);
	}

	public void selectTypeOption(){
		executor.executeScript("arguments[0].click();", selectSeizerTypeOption);
		// force sleep to see what value is selected
		forceSleep(3000);
	}

	public void selectFeltOption(){
		executor.executeScript("arguments[0].click();", feltNoRadioBtn);
		// force sleep to see what value is selected
		forceSleep(3000);
	}
	
	public String warningMessageValidation() {
		String warningMessage = warningBox.getText();
		forceSleep(3000);
		return warningMessage;
	}
	
	public void clickCloseWarningBtn() {
    	executor.executeScript("arguments[0].click();", warningCloseBtn);
    	// force sleep for service to respond
    	forceSleep(3000);
	}
	
	public void clickBackBtn() {
    	executor.executeScript("arguments[0].click();", backBtn);
    	// force sleep for service to respond
    	forceSleep(3000);
	}
	
	public void clickWarningConfirmBtn() {
    	executor.executeScript("arguments[0].click();", confirmBtn);
    	forceSleep(3000);
	}
	
    public void clickAddBtn(){
    	addBtn.click();
    	forceSleep(3000);
    }
    
    public void clickSeizureEventBtn(){
	  	executor.executeScript("arguments[0].click();", seizerEventBtn);
	  	forceSleep(3000);
  }

	public void saveSeizer() {
		executor.executeScript("arguments[0].scrollIntoView();", saveSeizerBtn);
		forceSleep(3000);
		executor.executeScript("arguments[0].click();", saveSeizerBtn);
		forceSleep(3000);
	}

	public String infoMessageValidation() {
		String infoMessage = infoBox.getText();
		return infoMessage;
	}
     
    public HepilepsyDashboardPage clickOkBtn(){
    	forceSleep(3000);
    	executor.executeScript("arguments[0].click();", okBtn);
    	forceSleep(3000);
    	return new HepilepsyDashboardPage(driver);
    }
    
    // Edit Seizure Methods
	public void changeType() {
		executor.executeScript("arguments[0].click();", typeDrpDwn);
		forceSleep(3000);
	}

	public void modifyOptiontype() {
		executor.executeScript("arguments[0].scrollIntoView();", modifySeizerTypeOption);
		forceSleep(3000);
		executor.executeScript("arguments[0].click();", modifySeizerTypeOption);
		forceSleep(3000);
	}
	
    public HepilepsyJournalPage clickSaveAfterEditBtn(){
    	executor.executeScript("arguments[0].click();", saveAfterEditBtn);
    	forceSleep(3000);
    	return new HepilepsyJournalPage(driver);
    }
  
	
}
