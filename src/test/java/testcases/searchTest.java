package testcases;
import Report.Listeners;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.base;
import pageobjects.searchPage;



public class searchTest extends baseTest {
   String url = "https://www.onesearch.com/";
   String text = "Ampion";



    @Test
    public void search()

    {
        WebDriver drive = give();
        searchPage sp= new searchPage(drive);
        sp.openpage(url);
        sp.performSearch(text);
        sp.click_search();

    }
}
