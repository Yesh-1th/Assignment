package testcases;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.searchPage;

import java.io.IOException;

import static utilities.Utils.getGlobalValue;


public class searchTest extends baseTest {


    WebDriver drive;
    String search_Text = "Ampion";

    @Test
    public void search() throws IOException {

        drive = give();
        searchPage sp= new searchPage(drive);
        sp.openpage(getGlobalValue("Url"));



        sp.performSearch(search_Text);



    }
}
