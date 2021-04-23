package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Result;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


public class ReportConfig {
    public static ExtentReports extent;
    public static ExtentSparkReporter extentSparkReporter;


    public static void config() {
        //report path
        String path = System.getProperty("user.dir") + "\\reports\\report.html";
        extentSparkReporter = new ExtentSparkReporter(path);//initializing the Extent report and providing the path to save the reports
        extent = new ExtentReports();
        extentSparkReporter.config().setReportName("Automation Results");
        extentSparkReporter.config().setDocumentTitle("Test results");

        extent.attachReporter(extentSparkReporter);


        //ExtentReports extent = new ExtentReports();

        extent.setSystemInfo("Tester", "Yeshwanth");        //return extent;

    }

   // public static void tname(ITestResult result)



    public static void newTest(Scenario scenario) throws IOException {
        if(scenario != null){
            String testName = getScenarioTitle(scenario);

            switch (scenario.getStatus()) {

                case PASSED:
                    extent.createTest(testName).pass("Passed");
                    break;

                case FAILED:
                    extent.createTest(testName).fail("failed");
                    break;

                default:
                    extent.createTest(testName).skip("Skipped");
            }
        }
    }

    public static void testngtest(ITestResult result)  {
        if(result != null){
            String testName = result.getTestClass().getXmlTest().getName();

            switch (result.getStatus()) {

                case ITestResult.SUCCESS:
                    extent.createTest(testName).pass("Passed");
                    break;

                case ITestResult.FAILURE:
                    extent.createTest(testName).fail("failed");
                    break;

                default:
                    extent.createTest(testName).skip("Skipped");
            }
        }
    }





    public void writeToReport() {
        if (extent != null) {
            extent.flush();

        }
    }


    private static String getScenarioTitle(Scenario scenario) {
        return scenario.getName();
    }


}