package options;


import io.cucumber.junit.Cucumber;


import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/features", plugin ="json:target/jsonReports/cucumber-report.json",glue = {"stepDefinations"},monochrome = true)
public class testRunner {


}