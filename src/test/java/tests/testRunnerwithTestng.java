package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features ="src/test/java/features/Apitempltae.feature", plugin ="json:target/jsonReports/cucumber-report.json",glue = {"stepDefinations"},monochrome = true)

public class testRunnerwithTestng extends AbstractTestNGCucumberTests {

@Override
    @DataProvider(parallel =true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
