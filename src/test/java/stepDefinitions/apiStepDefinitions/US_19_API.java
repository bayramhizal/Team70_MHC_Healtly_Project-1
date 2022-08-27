package stepDefinitions.apiStepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtils;
import utilities.Authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class US_19_API {

    Response response;
    JsonPath jsonPath;
    List<Integer> list;

    @Given("Admin herhangi bir staff bilgisini alir")
    public void adminHerhangiBirStaffBilgisiniAlir() {

        response= ApiUtils.getRequest(Authentication.generateToken("DzKKaya","Sword1234."),"https://medunna.com/api/staff?=size=1000");

        jsonPath=response.jsonPath();

         list=jsonPath.getList("id");
        System.out.println(list);



    }

    @Then("Admin URL'e silme istegi gonderir")
    public void adminURLESilmeIstegiGonderir() {

        response= ApiUtils.deleteRequest(Authentication.generateToken("DzKKaya","Sword1234."),
                "https://medunna.com/api/staff/"+list.get(ThreadLocalRandom.current().nextInt(0,list.size())));


    }


    @Then("Admin silinen Staff bilgisini kontrol eder")
    public void admin_silinen_staff_bilgisini_kontrol_eder() {

        Map<String, Object> actualMap = response.as(HashMap.class);


        Assert.assertTrue(actualMap.size()==0);

        Assert.assertTrue(actualMap.isEmpty());



    }


}