package pageobjects;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testcases.baseTest;
import utilities.browser;


public class searchPage extends base{
    By searchbar = By.xpath("//*[@id='yschsp']");
    By click_Search = By.xpath("//*[@id='sf']/button");


    public searchPage(WebDriver driver) {

        super(driver);
    }

    public void openpage(String url){

        openUrl(url);

    }

    public  void performSearch(String search_text){
        //log.info("Searching for results on "+search_text);
        type(search_text,searchbar);

    }

    public void click_search()
    {
        click(click_Search);
    }


}
