package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hepilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyDashboardPage;
import com.hepilepsy.pages.HepilepsyJournalPage;
import com.hepilepsy.pages.HepilepsyLoginPage;
import com.hepilepsy.pages.HepilepsyManageSeizurePage;
import com.hepilepsy.pages.HepilepsySettingsPage;
import com.hepilepsy.properties.FetchProperty;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyManageSeizureTest extends BaseTest {

    @Test(priority=1)
    public void addSeizureTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
		String saveMessage = fetchProperty.getMessage("saveInfoMessage");
		String warningMessage = fetchProperty.getMessage("selectTypeWarning");
		String journalPageUrl = fetchProperty.getUrl("journalUrl");
		
		HepilepsyManageSeizurePage manageSeizurePage = new HepilepsyManageSeizurePage(driver);
		//Nagative Test Case: Save without selecting Seizure Type
		manageSeizurePage.selectFeltOption();
		manageSeizurePage.saveSeizer();
		Assert.assertEquals(manageSeizurePage.warningMessageValidation(), warningMessage);
		manageSeizurePage.clickCloseWarningBtn();
		
		//Go back to journal page to Add Seizure again as save button is disabled(Seems to be bug)
		manageSeizurePage.clickBackBtn();
		HepilepsyDashboardPage dashboardPage = manageSeizurePage.clickWarningConfirmBtn();
		dashboardPage.clickAddBtn();
		dashboardPage.clickSeizureEventBtn();
		
		manageSeizurePage.selectType();
		manageSeizurePage.selectTypeOption();
		manageSeizurePage.selectFeltOption();
		manageSeizurePage.saveSeizer();
		Assert.assertEquals(manageSeizurePage.infoMessageValidation(), saveMessage);
		
		dashboardPage = manageSeizurePage.clickOkBtn();
    	Assert.assertEquals(dashboardPage.getPageUrl(), dashboardPageUrl);
    	
    	HepilepsyJournalPage journalPage = dashboardPage.clickDayBtn();
    	Assert.assertEquals(journalPage.getPageUrl(), journalPageUrl);
    	
    }
    
    @Test(priority=2)
    public void editSeizureTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
		String journalPageUrl = fetchProperty.getUrl("journalUrl");
		String settingsPageUrl = fetchProperty.getUrl("settingsUrl");
		String loginPageUrl = fetchProperty.getUrl("loginUrl");
		
		HepilepsyJournalPage journalPage = new HepilepsyJournalPage(driver);
		journalPage.clickpickSeizerBtn();
		
		HepilepsyManageSeizurePage manageSeizurePage = new HepilepsyManageSeizurePage(driver);
		manageSeizurePage.changeType();
		manageSeizurePage.modifyOptiontype();
		
		HepilepsyJournalPage journalPageAfterEdit = manageSeizurePage.clickSaveAfterEditBtn();
		Assert.assertEquals(journalPageAfterEdit.getPageUrl(), journalPageUrl);
		
		HepilepsyDashboardPage dashboardPage = journalPageAfterEdit.clickHomeBtn();
    	Assert.assertEquals(dashboardPage.getPageUrl(), dashboardPageUrl);	
    	
    	HepilepsySettingsPage settingsPage = dashboardPage.clickSettingsBtn();
    	Assert.assertEquals(settingsPage.getPageUrl(), settingsPageUrl);	
    	
    	HepilepsyLoginPage loginPage = settingsPage.clickLogout();
    	Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);
    }
    
}
