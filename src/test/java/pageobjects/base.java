package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class base {
    WebDriver driver;


    public base(WebDriver driver) {
        this.driver =driver;

    }

    //open url
    public void openUrl(String url) {

        driver.get(url);
    }

    // find web elements
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(String input, By locator)
    {
        find(locator).sendKeys(input);
    }

    // click
    public void click(By locator) {

        find(locator).click();
    }

    /** Get URL of current page from browser */
    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }




    }





