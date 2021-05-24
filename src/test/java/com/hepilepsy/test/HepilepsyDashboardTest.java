package com.hepilepsy.test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hepilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyDashboardPage;
import com.hepilepsy.pages.HepilepsyManageSeizurePage;
import com.hepilepsy.properties.FetchProperty;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyDashboardTest extends BaseTest {

    @Test
    public void dashboardPageTests() throws IOException, InterruptedException {
    	
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String manageSeizerPageUrl = fetchProperty.getUrl("manageSeizerUrl");
		String addEventWindowTitle = fetchProperty.getMessage("addEventWindowTitle");
		
		HepilepsyDashboardPage dashboardPage = new HepilepsyDashboardPage(driver); 
		dashboardPage.clickAddBtn();
		
		// check Add Event pop-up window
		Assert.assertEquals(dashboardPage.validateAddEventWindowTitle(),addEventWindowTitle);
		
    	// click Seizure Event button
		HepilepsyManageSeizurePage addSeizurePage = dashboardPage.clickSeizureEventBtn();
		
		// check for manageseizer page url	
    	Assert.assertEquals(addSeizurePage.getPageUrl(), manageSeizerPageUrl);
    	
    }
    
}
