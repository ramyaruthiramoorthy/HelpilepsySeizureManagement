package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hepilepsy.core.BaseTest;
import com.hepilepsy.pages.HepilepsyHomePage;
import com.hepilepsy.pages.HepilepsyLoginPage;
import com.hepilepsy.properties.FetchProperty;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyHomeTest extends BaseTest {

    @Test
    public void homepageTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
		String appUrl = fetchProperty.getUrl("appUrl");
		String loginPageUrl = fetchProperty.getUrl("loginUrl");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
    	HepilepsyHomePage homepage = new HepilepsyHomePage(driver);
    	
    	// load home page
    	homepage.loadHomePage(appUrl);
    	
    	// test if the home page is loaded
    	Assert.assertEquals(homepage.getPageUrl(), fetchProperty.getUrl("homePageUrl"));
    	
    	// some time application doesn't show sliders
    	if(homepage.isClickSwipeBtnVisible()){
    		homepage.clickSwapButton();
    	} 
    	
    	// some time application doesn't show sliders
    	if(homepage.isLetsGoBtnVisible()){
    		homepage.clickLetsGoButton();
    	} 
    	
    	HepilepsyLoginPage loginPage = homepage.clickNavigateToLoginBtn();
    	Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);
    }
    
}
