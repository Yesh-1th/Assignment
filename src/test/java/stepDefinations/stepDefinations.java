package stepDefinations;

import Report.ReportConfig;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import io.cucumber.java.StepDefinitionAnnotation;
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

    TestDatabuild data = new TestDatabuild();

    WebDriver drive = Hooks.give();
    searchPage sp= new searchPage(drive);
    payload pd = new payload();
   String pay_load = pd.dataDriven();

    public stepDefinations() throws IOException {
    }


    @Given("Add  podcast with {string} {string} {int}")
    public void add_podcast(String id,String image,int listen_score) throws IOException {
        res = given().spec(requestSpecification()).body(pay_load);

    }


    @When("Use {string} method to {string}")
        public void use_method_to(String method, String resource) {
        APIResources Ar =  APIResources.valueOf(resource);
        response = res.when().post(Ar.getResource());

    }

    @Then("assert the data with status code {int}")
    public void assert_the_data(Integer status) {
        assertEquals(response.getStatusCode(),200);


    }

    @Then("assert {string} in response body is {string}")
    public void assert_in_response_body_is(String keyValue, String expectedvalue) {

        assertEquals(getJsonPath(response, keyValue),expectedvalue);

    }

    @Then("use Get method to display the podacst {string}")
    public void use_method_to_display_the_podacst(String id) {
        APIResources Ar =  APIResources.valueOf("GETpodcast");
        response =given().queryParam("id",id).spec(req).when().get(Ar.getResource());


    }

    @Given("open {string}")
    public void open(String url) {
        sp.openUrl(url);

    }



    @When("enter {string} in search bar")
    public void enter_in_search_bar(String text) {

       sp.performSearch(text);


    }

    @Then("press click button to get results")
     public void press_click_button_to_get_results() {

        sp.click_search();
    }

    @Then("close browser")
    public void close_browser() {
        drive.quit();


    }




}
