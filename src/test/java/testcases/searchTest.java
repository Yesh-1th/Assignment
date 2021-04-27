package testcases;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.searchPage;



public class searchTest extends baseTest {


    WebDriver drive;
    Logger log;
    @Test
    public void search()
    {

        drive = give();
        log = givelog();
        searchPage sp= new searchPage(drive,log);
        sp.openpage("https://www.onesearch.com/");
        sp.performSearch("Ampion");



    }
}
