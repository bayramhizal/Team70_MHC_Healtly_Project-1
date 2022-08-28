package stepDefinitions.apiStepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.TestItem;
import pojos.TestItemPut;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_017_Api_StepDefinitions {

    public static RequestSpecification spec;
    TestItem testItem;
    TestItemPut testItemPut;
    Response response;
    Map<String, Object> expectedDataMap;
    public static Map<String, Object> actualDataMap;
    public static Object id;

    @Given("Admin Test Item icin gerekli parametreleri set eder")
    public void admin_test_item_icin_gerekli_parametreleri_set_eder() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "c-test-items");
    }

    @Then("Admin expected Datalari set eder {string}, {string}, {int}, {string}, {string}")
    public void admin_expected_datalari_set_eder(String name, String description, int price, String defaultValMin, String defaultValMax) {
        testItem = new TestItem(name, description, price, defaultValMin, defaultValMax);
        expectedDataMap = new HashMap<>();
        expectedDataMap.put("name", name);
        expectedDataMap.put("description", description);
        expectedDataMap.put("price", price);
        expectedDataMap.put("defaultValMin", defaultValMin);
        expectedDataMap.put("defaultValMax", defaultValMax);
    }

    @And("Admin post request talep eder ve 201 Status kodunu dogrular")
    public void adminPostRequestTalepEderVeCevapAlir() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("adminahmpar","Adana01"))
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testItem)
                .when()
                .post("/{first}/{second}");
        response.prettyPrint();
        assertEquals("hatali status kodu",201,response.getStatusCode());
        JsonPath jsonPath=response.jsonPath();
        id=jsonPath.getInt("id");
        System.out.println("jsonPath.getInt(\"id\") = " + jsonPath.getInt("id"));
        actualDataMap=response.as(HashMap.class);
    }

    @And("Admin expected data ile actual datanin ayni oldugunu dogrular")
    public void adminExpectedDataIleActualDataninAyniOldugunuDogrular() {

//********************************************* 1. Weg mit ObjectMapper ********************

        ObjectMapper obj = new ObjectMapper();
        TestItem actualTestItem;
        try {
            actualTestItem = obj.readValue(response.asString(), TestItem.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        gelen response data once String'e sonrada bizim Pojo class formatina cevrilir
        Boylece expected ile actual data ayni formatta olacagindan kiyaslama imkanimiz olacak
        */
        System.out.println(actualTestItem);
//TestItem{name='zuckerValue', description='letzte drei Tage', price=785, defaultValMin='30', defaultValMax='130'
        assertEquals(testItem.getName(), actualTestItem.getName());
        assertEquals(testItem.getDescription(), actualTestItem.getDescription());
        assertEquals(testItem.getPrice(), actualTestItem.getPrice());
        assertEquals(testItem.getDefaultValMin(), actualTestItem.getDefaultValMin());
        assertEquals(testItem.getDefaultValMax(), actualTestItem.getDefaultValMax());

        //********************************************* 2. Weg mit Deserialization (iki Map) ********************
        actualDataMap = response.as(HashMap.class);

        assertEquals("Dogrulama Hatasi", expectedDataMap.get("name"), actualDataMap.get("name"));
        assertEquals("Dogrulama Hatasi", expectedDataMap.get("description"), actualDataMap.get("description"));
        assertEquals("Dogrulama Hatasi", expectedDataMap.get("price"), actualDataMap.get("price"));
        assertEquals("Dogrulama Hatasi", expectedDataMap.get("defaultValMin"), actualDataMap.get("defaultValMin"));
        assertEquals("Dogrulama Hatasi", expectedDataMap.get("defaultValMax"), actualDataMap.get("defaultValMax"));

    }


    @Given("Admin Id no ile GET yaparak olusturdugu Test Item'i gorur ve {int} Status kodunu alir")
    public void adminIdNoIleGETYaparakOlusturduguTestItemIGorurVeStatusKodunuAlir(int statusKod) {
        response = given()
                .headers("Authorization","Bearer " + Authentication.generateToken("adminahmpar","Adana01"))
                .when()
                .get("https://www.medunna.com//api/c-test-items/" + actualDataMap.get("id"));
        response.prettyPrint();
       assertEquals("Hatali status kodu",statusKod,response.getStatusCode());
    }

    @And("Admin Id no ile PUT yaparak olusturdugu Test Item'i gunceller ve {int} Status kodunu alir")
    public void adminIdNoIlePUTYaparakOlusturduguTestItemIGuncellerVeStatusKodunuAlir(int expected) {
        testItemPut= new TestItemPut(actualDataMap.get("id"),"ZuckerErsatz","sattZucker weniger",600,"60","150");
        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken("adminahmpar","Adana01"))
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testItemPut)
                .when()
                .put("/{first}/{second}");
        response.prettyPrint();
       assertEquals("hatali status kodu",expected,response.getStatusCode());
        JsonPath jsonPath=response.jsonPath();
        assertEquals(testItemPut.getName(),jsonPath.get("name"));
        assertEquals(testItemPut.getId(),jsonPath.get("id"));
        assertEquals(testItemPut.getDescription(),jsonPath.get("description"));
        assertEquals(testItemPut.getPrice(),jsonPath.getInt("price"));
        assertEquals(testItemPut.getDefaultValMin(),jsonPath.getString("defaultValMin"));
        assertEquals(testItemPut.getDefaultValMax(),jsonPath.getString("defaultValMax"));
    }
    @And("Admin olusturdugu Test Itemi siler ve 204 kodu ile silindigini dogrular")
    public void adminOlusturduTestItemiSiler() {
        response = given()
                .headers("Authorization","Bearer " + Authentication.generateToken("adminahmpar","Adana01"))
                .when()
                .delete("https://www.medunna.com//api/c-test-items/" + actualDataMap.get("id"));
        assertEquals("Hatali status kodu",204,response.getStatusCode());
        System.out.println("actualDataMap.get(\"id\") = " + actualDataMap.get("id"));


        response = given()
                .headers("Authorization","Bearer " + Authentication.generateToken("adminahmpar","Adana01"))
                .when()
                .get("https://www.medunna.com//api/c-test-items/" + actualDataMap.get("id"));
        response.prettyPrint();
        String actualDataStr= response.asString();
        assertTrue("SILME ISLEMI BASARISIZ",actualDataStr.contains("Not Found"));
        assertEquals("silme islemi basarisiz",404,response.getStatusCode());
    }


}


