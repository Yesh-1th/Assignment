package tests;

import Report.demo;
import com.aventstack.extentreports.ExtentReports;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features ="src/test/java/features/Apitempltae.feature", plugin ={"Report.demo", "json:target/cucumber-report.json"},glue = {"stepDefinations"},monochrome = true)

public class TestngTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }




}
