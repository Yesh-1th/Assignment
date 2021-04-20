package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.openqa.selenium.WebDriver;
import pageobjects.searchPage;
import pojo.addPodcast;
import testcases.baseTest;
import testcases.searchTest;
import utilities.APIResources;
import utilities.TestDatabuild;
import utilities.Utils;
import utilities.browser;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class stepDefinations extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    String browser = "chrome";

    TestDatabuild data = new TestDatabuild();
    baseTest bt = new baseTest();
    WebDriver drive = bt.setUp(browser);
    searchPage sp= new searchPage(drive);



    @Given("Add  podcast with {string} {string} {int}")
    public void add_podcast(String id,String image,int listen_score) throws IOException {
        res = given().spec(requestSpecification()).body(data.addPodcastPayLoad(id,image,listen_score));

    }

@When("Use {string} method to {string}")
public void use_method_to(String method, String resource) {
    APIResources Ar =  APIResources.valueOf(resource);
    System.out.println(Ar.getResource());

    if(method.equalsIgnoreCase("POST"))
        response = res.when().post(Ar.getResource());
    else if(method.equalsIgnoreCase("GET"))
        response =res.when().get(Ar.getResource());

}
    @Then("assert the data with status code {int}")
    public void assert_the_data(Integer status) {
        // Write code here that turns the phrase above into concrete actions
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


    @Given("open Url")
    public void open_url() {

        sp.openpage("https://www.onesearch.com/");
    }



    @When("enter test in search bar")
    public void enter_test_in_search_bar() {

       sp.performSearch("Ampion");



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
