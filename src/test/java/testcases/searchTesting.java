package testcases;
//import Report.Listeners;
import Report.ReportConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.base;
import pageobjects.searchPage;


@Test
public class searchTesting extends baseTest {
   String url = "https://www.onesearch.com/";
   String text = "Ampion";



    public void search( )


    {
        //ExtentTest test= ReportConfig.extent.createTest(result.getMethod().getMethodName() );
       // test.assignCategory(result.getTestClass().getXmlTest().getName());

        WebDriver drive = give();
        searchPage sp= new searchPage(drive);

        sp.openpage(url);

        sp.performSearch(text);
        sp.click_search();
        //ReportConfig.extent.createTest("UI Test").log(Status.PASS,"the test has passed");



    }
}
