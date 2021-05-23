package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.helpilepsy.core.BaseTest;
import com.helpilepsy.properties.FetchProperty;
import com.hepilepsy.pages.HepilepsyDashboardPage;
import com.hepilepsy.pages.HepilepsyLoginPage;

/***
 * class HepilepsyLoginTest implements test cases for home page
 * @author Ramya
 *
 */
public class HepilepsyLoginTest extends BaseTest {

    @Test
    public void homepageTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String emailId = fetchProperty.getCredential("LoginId");
		String password = fetchProperty.getCredential("LoginPassword");
		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
		
		// negative test case - Login
		
		// positive test case - Login
		HepilepsyLoginPage loginPage = new HepilepsyLoginPage(driver);
		loginPage.setUserId(emailId);
		loginPage.setUserPassword(password);
  
		HepilepsyDashboardPage DashboardPage = loginPage.clickLoginBtn();
		System.out.println("DashboardPage.getPageUrl(): " + DashboardPage.getPageUrl());
    	Assert.assertEquals(DashboardPage.getPageUrl(), dashboardPageUrl);
    }
    
}
