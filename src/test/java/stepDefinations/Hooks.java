package stepDefinations;

import Report.ReportConfig;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import testcases.baseTest;
import utilities.browser;

import java.io.IOException;


public class Hooks {

    static WebDriver driver;
    String browser = "edge";

    @Before("@Ui_test")
    public void init() {

        baseTest bt = new baseTest();
        driver = bt.setUp(browser);

        ReportConfig.config();


    }

    public static WebDriver give()

    {
        return driver;

    }


    @After("@Ui_test")
    public void close(Scenario scenario) throws IOException {
        if(driver!= null)
            driver.quit();

        ReportConfig.newTest(scenario);
        ReportConfig.extent.flush();

    }
}
