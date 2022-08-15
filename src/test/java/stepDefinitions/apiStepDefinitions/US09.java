package stepDefinitions.apiStepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.pojo_US_09.BookingDatesPojo;
import pojos.pojo_US_09.BookingPojo;

import static io.restassured.RestAssured.given;

public class US09 {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
    static BookingDatesPojo bookingDatesPojo;
    static BookingPojo bookingPojo;
    static Response response;
    static BookingPojo actualPojo;


    @Given("herokuapp base url e {string} ve {int} ekle")
    public void herokuapp_base_url_e_ve_ekle(String field, Integer num) {
        spec.pathParams("first",field,"second",num);
        response =given().spec(spec).when().get("/{first}/{second}");

    }
    @When("User sends a GET Request to the url")
    public void user_sends_a_get_request_to_the_url() {

        bookingDatesPojo=new BookingDatesPojo("2013-02-23","2014-10-23");
        bookingPojo=new BookingPojo("Sally","Brown",111,true,bookingDatesPojo,"Breakfast");
        actualPojo=response.as(BookingPojo.class);
    }
    @Then("HTTP Status Code should be {int}")
    public void http_status_code_should_be(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }
    @Then("Content Type should be JSON")
    public void content_type_should_be_json() {
        response.then().assertThat().contentType(ContentType.JSON);
    }
    @Then("Status Line should be {string}")
    public void status_line_should_be(String string) {
        response.then().assertThat().statusLine(string);
        response.prettyPrint();

    }

}

