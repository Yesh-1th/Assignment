package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ReportConfig {
    ExtentReports extent;

    public static ExtentReports config()

    {
        //report path
       String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);//initializing the Extent report and providing the path to save the reports
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Yeshwanth");
        return extent;
    }

}
