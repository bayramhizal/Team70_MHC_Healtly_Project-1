package stepDefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojos.Registrant;
import pojos.pojo_US01.Registrant01;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US01_US02_api {

    RequestSpecification spec;
    Response response;
    Registrant01 registrant=new Registrant01();
    Faker faker;


    @Given("kullanici get islemi icin Medunna URLi olusturur")
    public void kullaniciGetIslemiIcinMedunnaURLiOlusturur() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("SMmedunnaEndPoint")).build();
        spec.pathParams("ilk" , "api" , "ikinci" , "users").queryParams("page", 1 , "size" , 6000);
    }


    @Given("kullanici request gonderir ve response datasi olusturur")
    public void kullanici_request_gonderir_ve_response_datasi_olusturur() {
         response=given().headers(  "Authorization",
                                    "Bearer " + generateToken("adminmerdan","123456"),
                                    "Content-Type",
                                     ContentType.JSON,
                                     "Accept",
                                     ContentType.JSON)
                 .spec(spec).when().get("/{ilk}/{ikinci}");
         response.prettyPrint();

    }

    @Then("kullanici responsedan gelen status codun {int} ve content tipin Json oldugunu dogrular")
    public void kullanici_responsedan_gelen_status_codun_ve_content_tipin_json_oldugunu_dogrular(Integer int1) {

        response.then().assertThat().statusCode(int1).contentType("application/json");
    }

    @Then("kullanici gelen data icindeki registrant bilgilerini dogrular")
    public void kullaniciGelenDataIcindekiRegistrantBilgileriniDogrular() {
        response.then().assertThat().body( "login" , Matchers.hasItem("memoli") ,
                "firstName" , Matchers.hasItem("mehmet"),
                "lastName" , Matchers.hasItem("merdan")             );
    }

    @Given("kullanici kayitli kisi olusturmak icin body ile expected data olusturur")
    public void kullanici_kayitli_kisi_olusturmak_icin_body_ile_expected_data_olusturur() {
        faker=new Faker();
        registrant.setActivated(true);
        registrant.setEmail(faker.internet().emailAddress());
        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setLogin(faker.name().username());
        registrant.setPassword(faker.internet().password(8,12,true,true,true));
        registrant.setSsn(faker.idNumber().ssnValid());
    }

    @When("kullanici post request yapar")
    public void kullanici_post_request_yapar() {
       response=given().
               contentType(ContentType.JSON).
               spec(spec)
               .auth().basic("adminmerdan" , "123456")
               .body(registrant)
               .when()
               .post("/{ilk}/{ikinci}");
    }

    @When("kullanici response alir")
    public void kullanici_response_alir() {
        response.then().assertThat().statusCode(201).contentType(ContentType.JSON);
        response.prettyPrint();
    }

    @Then("kullanici post edilen kisinin kayit oldugunu dogrular")
    public void kullanici_post_edilen_kisinin_kayit_oldugunu_dogrular() throws Exception {
        ObjectMapper obje=new ObjectMapper();
        Registrant01 actualData=obje.readValue(response.asString() , Registrant01.class);
        Assert.assertEquals(registrant.getFirstName() , actualData.getFirstName());
        Assert.assertEquals(registrant.getLastName() , actualData.getLastName());
        Assert.assertEquals(registrant.getEmail() , actualData.getEmail());
        Assert.assertEquals(registrant.getLogin() , actualData.getLogin());
        Assert.assertEquals(registrant.getSsn() , actualData.getSsn());
    }




    @Given("kullanici post islemi icin Medunna Urli olusturur")
    public void kullaniciPostIslemiIcinMedunnaUrliOlusturur() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("SMmedunnaEndPoint")).build();
        spec.pathParams("ilk" , "api" , "ikinci" , "register");
    }
//////////////////////////////////////// API-US02

    @Given("kullanici enpoint olusturur ve request yapar")
    public void kullaniciEnpointOlustururVeRequestYapar() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("SMmedunnaEndPoint")).build();
        spec.pathParams("ilk" , "api" , "ikinci" , "register");

    }

    @And("kullanici post islemi icin expected data olusturur")
    public void kullaniciPostIslemiIcinExpectedDataOlusturur(){

        faker=new Faker();

        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setSsn(faker.idNumber().ssnValid());
        registrant.setPassword(faker.internet().password(8,10,true,true));
        registrant.setLogin(faker.name().username());
        registrant.setEmail(faker.internet().emailAddress());


    }

    @Given("kullanici post request islemi yapar")
    public void kullaniciPostRequestIslemiYapar() {

        response=given()
                .contentType(ContentType.JSON)
                .spec(spec)
               // .auth()
                //.basic("adminmerdan" , "123456")
                .body(registrant)
                .when().post("/{ilk}/{ikinci}");

    }

    @Then("kullanici post yapilan kullanici adini dogrular")
    public void kullaniciPostYapilanKullaniciAdiniDogrular() throws IOException {

        ObjectMapper object = new ObjectMapper();
        Registrant01 actualData=object.readValue(response.asString() , Registrant01.class);
        Assert.assertEquals( registrant.getLogin() , actualData.getLogin()  );


    }

    @Then("kullanici post yapilan email adresini dogrular")
    public void kullaniciPostYapilanEmailAdresiniDogrular() throws IOException {


        ObjectMapper object = new ObjectMapper();
        Registrant01 actualData=object.readValue(response.asString() , Registrant01.class);
        Assert.assertEquals( registrant.getLogin() , actualData.getLogin()  );

        System.out.println( response.asString() );
        System.out.println( registrant.toString() );


    }


}