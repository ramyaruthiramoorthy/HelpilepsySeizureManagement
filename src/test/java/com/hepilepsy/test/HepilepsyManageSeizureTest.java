package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.helpilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyDashboardPage;
import com.hepilepsy.pages.HepilepsyManageSeizurePage;
import com.hepilepsy.properties.FetchProperty;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyManageSeizureTest extends BaseTest {

    @Test
    public void addSeizureTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
		String saveMessage = fetchProperty.getMessage("saveMessage");
		
		HepilepsyManageSeizurePage manageSeizurePage = new HepilepsyManageSeizurePage(driver);
		manageSeizurePage.clickSeizerBtn();
		manageSeizurePage.selectType();
		manageSeizurePage.selectTypeOption();
		manageSeizurePage.selectFeltOption();
		manageSeizurePage.saveSeizer();
		Assert.assertEquals(manageSeizurePage.infoMessageValidation(), saveMessage);
		
		HepilepsyDashboardPage DashboardPage = manageSeizurePage.clickOkBtn();
    	Assert.assertEquals(DashboardPage.getPageUrl(), dashboardPageUrl);
    }
    
//    @Test
//    public void editSeizureTests() throws IOException, InterruptedException {
//    	// retrieving application url
//    	FetchProperty fetchProperty = new FetchProperty();
//		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
//		String saveMessage = fetchProperty.getMessage("saveMessage");
//		
//		HepilepsyManageSeizurePage manageSeizurePage = new HepilepsyManageSeizurePage(driver);
//		manageSeizurePage.clickSeizerBtn();
//		manageSeizurePage.selectType();
//		manageSeizurePage.selectTypeOption();
//		manageSeizurePage.selectFeltOption();
//		manageSeizurePage.saveSeizer();
//		Assert.assertEquals(manageSeizurePage.infoMessageValidation(), saveMessage);
//		
//		HepilepsyDashboardPage DashboardPage = manageSeizurePage.clickOkBtn();
//    	Assert.assertEquals(DashboardPage.getPageUrl(), dashboardPageUrl);
//    }
    
}
