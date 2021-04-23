package stepDefinations;

import Report.ReportConfig;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import pageobjects.searchPage;
import pojo.addPodcast;
import sun.security.krb5.Config;
import testcases.baseTest;

import utilities.*;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class stepDefinations extends  Utils{
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    String browser = "chrome";

    TestDatabuild data = new TestDatabuild();
    browser br = new browser("chrome");
    WebDriver drive = br.createDriver();
    searchPage sp= new searchPage(drive);
    payload pd = new payload();
    HashMap<String, Object> pay_load = pd.dataDriven();

    public stepDefinations() throws IOException {
    }

//    ExtentTest test = ReportConfig.extent.createTest("API Post Test");
//    ExtentTest test1 = ReportConfig.extent.createTest("UI Test");




    @Given("Add  podcast with {string} {string} {int}")
    public void add_podcast(String id,String image,int listen_score) throws IOException {
        res = given().spec(requestSpecification()).body(pay_load);
//        test.info("Adding the payload data");





    }

@When("Use {string} method to {string}")
public void use_method_to(String method, String resource) {
    APIResources Ar =  APIResources.valueOf(resource);
    System.out.println(Ar.getResource());

    if(method.equalsIgnoreCase("POST")) {
        response = res.when().post(Ar.getResource());
//        test.info(" performing Post method");

    }
    else if(method.equalsIgnoreCase("GET"))
        response =res.when().get(Ar.getResource());

}
    @Then("assert the data with status code {int}")
    public void assert_the_data(Integer status) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
//        test.info("Performing assertion");
    }

    @Then("assert {string} in response body is {string}")
    public void assert_in_response_body_is(String keyValue, String expectedvalue) {

        assertEquals(getJsonPath(response, keyValue),expectedvalue);
//        test.info("performed body assertion");

    }

    @Then("use Get method to display the podacst {string}")
    public void use_method_to_display_the_podacst(String id) {
        APIResources Ar =  APIResources.valueOf("GETpodcast");
        response =given().queryParam("id",id).spec(req).when().get(Ar.getResource());
//        test.info("Getting the podcast with id number"+id);
//        test.pass("API test pass");


    }

    @Given("open Url")
    public void open_url() {

        sp.openpage("https://www.onesearch.com/");
//        test1.info("opening webpage");
    }



    @When("enter test in search bar")
    public void enter_test_in_search_bar() {

       sp.performSearch("Ampion");
//        test1.info("Entered text in the search bar");




    }
    @Then("press click button to get results")
     public void press_click_button_to_get_results() {

        sp.click_search();
//        test1.info("performed search");
    }

    @Then("close browser")
    public void close_browser() {
        drive.quit();
//        test1.info("Closed browser");
//        test1.pass("ui test passed");


    }




}
