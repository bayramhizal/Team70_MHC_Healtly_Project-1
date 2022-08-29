package stepDefinitions.apiStepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import pojos.pojo_US_27.MessagesPojo;
import utilities.ApiUtils;
import utilities.Authentication;
import utilities.ConfigReader;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.Matchers.*;
import static utilities.JsonUtil.convertJsonToJavaObject;

public class US27_ApiStepDefinitions {
    Response response;
    MessagesPojo expectedMessages=new MessagesPojo();
    JsonPath jsonPath;
    public static List<Object> id;
    @Given("{string} message icin URLe post istegi gonderir")
    public void message_icin_ur_le_post_istegi_gonderir(String string) {

        expectedMessages=new MessagesPojo("aliveli@gmail.com","doktorlar cok yogun randevu alamiyorum","ali","randevu");

        response= ApiUtils.postRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"),ConfigReader.getProperty("adminPW")),"https://medunna.com/api/c-messages",expectedMessages);
        response.prettyPrint();



    }

    @Given("{string} message icin URLe alma istegi gonderir")
    public void messageIcinURLeAlmaIstegiGonderir(String arg0) {

        response= ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"),ConfigReader.getProperty("adminPW")),"https://medunna.com/api/c-messages?size=10000");
        response.prettyPrint();
        jsonPath=response.jsonPath();
        id=jsonPath.getList("findAll{it.email=='aliveli@gmail.com'}.id");
        System.out.println("id = " + id);
        List<Object> ids=jsonPath.getList("id");
        System.out.println("ids.size() = " + ids.size());
    }

    @And("Admin message bilgisini kontrol eder")
    public void adminMessageBilgisiniKontrolEder() {

        response.then().assertThat().body("id",hasItem(id.get(ThreadLocalRandom.current().nextInt(id.size()))),"name",hasItem("ali"));

    }

    @And("Admin olusturulan message bilgisini kontrol eder")
    public void adminOlusturulanMessageBilgisiniKontrolEder() {

        MessagesPojo actualMessage=convertJsonToJavaObject(response.asString(),MessagesPojo.class);
        Assert.assertEquals(expectedMessages.getEmail(),actualMessage.getEmail());
        Assert.assertEquals(expectedMessages.getMessage(),actualMessage.getMessage());
        Assert.assertEquals(expectedMessages.getName(),actualMessage.getName());
        Assert.assertEquals(expectedMessages.getSubject(),actualMessage.getSubject());

    }

    @Then("Kullanici messages icin Status Code {int} oldugunu dogrular")
    public void kullaniciMessagesIcinStatusCodeOldugunuDogrular(int stCode) {

        response.then().assertThat().statusCode(stCode);


    }
}
