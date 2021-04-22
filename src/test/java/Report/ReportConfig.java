package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

public class ReportConfig {
    public static ExtentReports extent;
    public static ExtentSparkReporter extentSparkReporter;


    public static void config()

    {
        //report path
        String path = System.getProperty("user.dir")+"\\reports\\report.html";
        extentSparkReporter  = new ExtentSparkReporter(path);//initializing the Extent report and providing the path to save the reports
        extent= new ExtentReports();
        extentSparkReporter.config().setReportName("Automation Results");
        extentSparkReporter.config().setDocumentTitle("Test results");

        extent.attachReporter(extentSparkReporter);


        //ExtentReports extent = new ExtentReports();

        extent.setSystemInfo("Tester","Yeshwanth");
        //return extent;
    }
    public void createTest(Scenario scenario){
        if(scenario!=null)
        {
            String testname =getScenarioTitle(scenario);
            switch ((scenario.getStatus())){
                case PASSED:
                    extent.createTest(testname);
                    break;
                case FAILED:
                    System.out.println("Test failes, under work");
                    break;
                default:
                    extent.createTest(testname).skip("skipped");
            }
        }
    }

    public void writeToReport()

    {
        if (extent != null) {
            extent.flush();

        }
    }


    private String getScenarioTitle(Scenario scenario)
    {
        return scenario.getName().replaceAll(" ","");
    }

}
