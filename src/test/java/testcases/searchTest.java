package testcases;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.searchPage;



public class searchTest extends baseTest {


    @Test
    public void search()
    {
        WebDriver drive =  give();
        searchPage sp= new searchPage(drive);
        sp.openpage("https://www.onesearch.com/");
        sp.performSearch("Ampion");
        sp.click_search();
    }
}
