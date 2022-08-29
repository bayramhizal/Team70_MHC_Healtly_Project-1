package stepDefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class Us_016_ApiStepDefinition {
    Response response;
    @Given("kullanici delete request yapar {string}")
    public void kullanici_delete_request_yapar(String id) {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken("team70","team7044."),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete("https://medunna.com/api/rooms"+"/"+id);
    }
}
