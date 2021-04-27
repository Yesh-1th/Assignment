package stepDefinations;

import Report.ReportConfig;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import utilities.browser;

import java.io.IOException;


public class Hooks {


    @Before
    public void init() {

        ReportConfig.config();


    }


    @After
    public void close(Scenario scenario) throws IOException {


        ReportConfig.newTest(scenario);
        ReportConfig.extent.flush();

    }
}
