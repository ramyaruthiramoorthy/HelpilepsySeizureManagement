package com.hepilepsy.test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.helpilepsy.core.BaseTest;
import com.helpilepsy.properties.FetchProperty;
import com.hepilepsy.pages.HepilepsyJournalPage;
import com.hepilepsy.pages.HepilepsyManageSeizurePage;

/***
 * 
 * @author Ramya
 *
 */
public class HepilepsyJournalTest extends BaseTest {

    @Test
    public void journalPageTests() throws IOException, InterruptedException {
    	// retrieving application url
    	FetchProperty fetchProperty = new FetchProperty();
    	String manageSeizerPageUrl = fetchProperty.getUrl("manageSeizerUrl");
		
		HepilepsyJournalPage journalPage = new HepilepsyJournalPage(driver);
		
		HepilepsyManageSeizurePage editSeizurePage = journalPage.clickpickSeizerBtn();
		Assert.assertEquals(editSeizurePage.getPageUrl(), manageSeizerPageUrl);
    }
    
}
