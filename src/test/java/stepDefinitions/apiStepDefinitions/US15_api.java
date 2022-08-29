package stepDefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.pojo_US15.*;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US15_api {

    RequestSpecification spec;
    Response response;
    Faker faker=new Faker();
    PatientsPut patient=new PatientsPut();
    User user=new User();
    Cstate cstate=new Cstate();
    Country__1 country1=new Country__1();
    Country country=new Country();
    public static Map<String, Object> actualDataMap;
    Map<String, Object> expectedDataMap;
    public static Object id;


    @Given("Admin hasta POST islemi icin endpointi olusturur")
    public void adminHastaPOSTIslemiIcinEndpointiOlusturur() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("SMmedunnaEndPoint")).build();
        spec.pathParams("ilk" , "api" , "ikinci", "patients");

    }

    @When("Admin hasta POST islemi icin expected data olusturur")
    public void adminHastaPOSTIslemiIcinExpectedDataOlusturur() {

        patient.setFirstName(faker.name().firstName());
        patient.setLastName(faker.name().lastName());
        patient.setEmail(faker.internet().emailAddress());
        patient.setPhone(faker.phoneNumber().subscriberNumber(10));
        patient.setGender("MALE");
        patient.setBirthDate("1989-01-01T10:45:00Z");
        patient.setBloodGroup("Apositive");
        patient.setAdress(faker.address().streetAddress());
        patient.setDescription(faker.programmingLanguage().creator());


    }

    @And("Admin POST request islemi yapar ve response alir")
    public void adminPOSTRequestIslemiYaparVeResponseAlir() {

        response=given().headers("Authorization",
                         "Bearer " + generateToken("adminmerdan" , "123456"))
                .contentType(ContentType.JSON)
                .spec(spec)
                .body(patient)
                .when()
                .post("/{ilk}/{ikinci}");
        response.prettyPrint();


        JsonPath json = response.jsonPath();   // responsedan gelen IDyi jsonPathe aldım
        id=json.getInt("id");                 // IT yi konteynıra attım

        System.out.println( json.getInt("id") );
        actualDataMap=response.as(HashMap.class);
    }

    @Then("Admin status kodunun {int} oldugunu dogrular")
    public void adminStatusKodununOldugunuDogrular(int kod) {
        Assert.assertEquals( "hatalı kod", 201 , response.getStatusCode() );
    }

    @Then("Admin POST expected data ile actual datanin ayni oldugunu dogrular")
    public void adminPOSTExpectedDataIleActualDataninAyniOldugunuDogrular() throws IOException {

        ObjectMapper obj = new ObjectMapper();
        PatientsPut actualData=obj.readValue(response.asString() , PatientsPut.class);
        Assert.assertEquals( patient.getFirstName() , actualData.getFirstName() );
        Assert.assertEquals(patient.getLastName() , actualData.getLastName());
        Assert.assertEquals(patient.getEmail() , actualData.getEmail());
        Assert.assertEquals(patient.getPhone() , actualData.getPhone());
        Assert.assertEquals(patient.getGender() , actualData.getGender());
        Assert.assertEquals(patient.getBloodGroup() , actualData.getBloodGroup());
        Assert.assertEquals(patient.getAdress() , actualData.getAdress());

      //////////////////////////////////////////////////////////////////////////////////




    }


    @Then("Admin ID no ile GET yaparak olusturdugu hastayi gorur ve {int} Status kodunu alir")
    public void adminIDNoIleGETYaparakOlusturduguHastayiGorurVeStatusKodunuAlir(int kod) {

        response=given()
                .headers("Authorization",
                          "Bearer " + generateToken("adminmerdan" , "123456"))
                .contentType(ContentType.JSON)
                .when()
                .get("https://medunna.com/api/patients/" + actualDataMap.get("id"));
        response.prettyPrint();

        response.then().assertThat().statusCode(kod);


    }


    @And("Admin ID no ile PUT yaparak olusturdugu hastayi gunceller ve {int} Status kodunu alir")
    public void adminIDNoIlePUTYaparakOlusturduguHastayiGuncellerVeStatusKodunuAlir(int arg0) {

    }


    @And("Admin olusturdugu hastayi siler ve {int} kodu ile silindigini dogrular")
    public void adminOlusturduguHastayiSilerVeKoduIleSilindiginiDogrular(int arg0) {

    }



}
