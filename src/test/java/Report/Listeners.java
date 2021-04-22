package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    //ExtentReports extent = ReportConfig.config();
    ExtentTest test;



    @Override
    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName());//dynamically get the test name at the start of the test
//        extentTest.set(test);
//        test.assignCategory(result.getTestClass().getXmlTest().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

//        extentTest.get().log(Status.PASS,"Successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        extentTest.get().fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        //ReportConfig.config();


    }

    @Override
    public void onFinish(ITestContext context) {

     //ReportConfig.extent.flush();


    }
}
