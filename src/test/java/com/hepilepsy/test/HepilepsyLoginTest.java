package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hepilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyDashboardPage;
import com.hepilepsy.pages.HepilepsyLoginPage;
import com.hepilepsy.properties.FetchProperty;

/***
 * class HepilepsyLoginTest implements test cases for home page
 * @author Ramya
 *
 */
public class HepilepsyLoginTest extends BaseTest {

	@Test
    public void loginTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String emailId = fetchProperty.getCredential("loginId");
		String password = fetchProperty.getCredential("loginPassword");
		String dashboardPageUrl = fetchProperty.getUrl("dashboardUrl");
		
		// positive test case - Login
		HepilepsyLoginPage loginPage = new HepilepsyLoginPage(driver);
		loginPage.setUserId(emailId);
		loginPage.setUserPassword(password);
  
		HepilepsyDashboardPage DashboardPage = loginPage.clickLoginBtn();
		System.out.println("DashboardPage.getPageUrl(): " + DashboardPage.getPageUrl());
    	Assert.assertEquals(DashboardPage.getPageUrl(), dashboardPageUrl);
    }
    
}
