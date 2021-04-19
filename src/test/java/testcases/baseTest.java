package testcases;

import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Utils;
import utilities.browser;

public class baseTest {
    WebDriver driver;

    @Parameters({"browser" })
    @BeforeMethod(alwaysRun = true)
    public WebDriver setUp(@Optional("chrome") String browser,ITestContext ctx) {

        String testName = ctx.getCurrentXmlTest().getName();

        browser br = new browser(browser);
        driver = br.createDriver();
        driver.manage().window().maximize();
        return driver;

    }
    public WebDriver give()

    {
        return driver;

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //log.info("Close driver");
        // Close the browser
        driver.quit();
    }

}
