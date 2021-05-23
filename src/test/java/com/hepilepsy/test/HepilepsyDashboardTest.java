package com.hepilepsy.test;
import java.io.IOException;
import org.testng.annotations.Test;
import com.helpilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyDashboardPage;
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
		
		HepilepsyDashboardPage dashboardPage = new HepilepsyDashboardPage(driver); 
		dashboardPage.clickAddBtn();
		
		// check pop-up window
		
		
		// click add event button
		
		// check for manageseizer page url
		
//		HepilepsyManageSeizurePage addSeizurePage = 
//		System.out.println(addSeizurePage.getPageUrl());
//		System.out.println(manageSeizerPageUrl);
//    	Assert.assertEquals(addSeizurePage.getPageUrl(), manageSeizerPageUrl);
    	
    }
    
}
