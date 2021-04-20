package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.browser;

public class base {
    WebDriver driver;


    public base(WebDriver driver) {
        this.driver =driver;
       // this.log = log;
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
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(input);
    }

    // click
    public void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /** Get URL of current page from browser */
    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    //waiting logic

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }



}

