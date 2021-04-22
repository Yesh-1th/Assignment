package testcases;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.browser;

public class baseTest {
    WebDriver driver;

    @Parameters({"browser" })
    @BeforeMethod(alwaysRun = true)
    public WebDriver setUp(@Optional("chrome") String browser, ITestResult result ) {


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

        driver.quit();
    }

}
