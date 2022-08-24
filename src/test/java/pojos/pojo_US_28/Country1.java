package pojos.pojo_US_28;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country1 {
    Response response;
    @Given("Kullanici country icin get request yapar")
    public void kullanici_country_icin_get_request_yapar() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("team70", "team7044."),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(ConfigReader.getProperty("url"))
                .then()
                .extract()
                .response();
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

    }

    //TC_02
    @Given("kullanici api end point {string} den {string} ve {string} kullanarak ulke olusturur")
    public void kullanici_api_end_point_den_ve_kullanarak_ulke_olusturur (String url, String type, String country){


        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("team70", "team7044."),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"" + type + "\":\"" + country + "\"}")
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
    //TC_03
    @Given("kullanici api end point {string} den {string} ve {string} kullanarak guncelleme yapar")
    public void kullanici_api_end_point_den_ve_kullanarak_guncelleme_yapar (String endPoint, String id, String name)
    {

        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("team70", "team7044."),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"id\": " + id + ",\"name\": \"" + name + "\"}")
                .put(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
    //TC_04
    @Given("kullanici endpoint {string} ve id ile {string} ulke siler")
    public void kullanici_endpoint_ve_id_ile_ulke_siler (String endPoint, String id){

        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("team70", "team7044."),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .delete(endPoint + id)
                .then()
                .extract()
                .response();
    }



}