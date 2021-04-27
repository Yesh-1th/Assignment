package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;

import java.io.IOException;


public class ReportConfig implements EventListener {
    public static ExtentReports extent;
    public static ExtentSparkReporter extentSparkReporter;
    static ExtentTest test;


    public static void config()  {
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
                    test =extent.createTest(testName).pass("Passed");


                    break;

                case FAILED:
                    test = extent.createTest(testName).fail("failed");
                    break;

                default:
                    test= extent.createTest(testName).skip("Skipped");
            }
        }
    }



    private static String getScenarioTitle(Scenario scenario) {
        return scenario.getName();
    }


    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {


    }
}