package stepDefinitions.apiStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.pojo_US_09.PatientsSearchInPojo;
import pojos.pojo_US_09.PatientsSearchPojo;
import utilities.ApiUtils;
import utilities.Authentication;
import utilities.ConfigReader;
import java.io.IOException;
import java.util.*;

public class US09_ApiStepDefinitions {

    static Response response;
    @Given("{string} URLe alma istegi gonderir")
    public void urleAlmaIstegiGonderir(String account) {

       switch (account){
           case "Admin" :
               response= ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"),ConfigReader.getProperty("adminPW")),"https://medunna.com/api/patients?=size=300");
               response.prettyPrint();
               break;
           case "Staff" :
                response= ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("staffUN"),ConfigReader.getProperty("staffPW")),"https://medunna.com/api/patients?=size=10000");
                response.prettyPrint();
               break;
       }
    }

    @Then("{string} Status Code {int} oldugunu dogrular")
    public void statusCodeOldugunuDogrular(String account, int stCode) {

        switch (account){
            case "Admin" :
                Assert.assertEquals(stCode,response.getStatusCode());
                break;
            case "Staff" :
                Assert.assertEquals(stCode,response.getStatusCode());
                break;
        }
    }

    @And("Admin Hasta kayitlarini kontrol eder")
    public void adminHastaKayitlariniKontrolEder() {

        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("id");
        List<String> firstName = json.getList("firstName");
        List<String> userEmail = json.getList("user.email");
        System.out.println("ids.size() = " + ids.size());
        Assert.assertTrue(firstName.contains("Physician"));
        Assert.assertTrue(userEmail.contains(ConfigReader.getProperty("userEM")));

        //Assert.assertEquals(firstName.size(),200);

    }

    @And("Staff Hasta kayitlarini kontrol eder")
    public void staffHastaKayitlariniKontrolEder() {
        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("id");
        List<String> firstName = json.getList("firstName");
        List<String> login = json.getList("login");
        System.out.println("ids.size() = " + ids.size());
        Assert.assertTrue(firstName.contains("Denis"));
        Assert.assertTrue(login.contains(ConfigReader.getProperty("PATIENT51")));
    }

    @Given("{string} URLe silme istegi gonderir.")
    public void urleSilmeIstegiGonderir(String account) {

        response = ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"), ConfigReader.getProperty("adminPW")), "https://medunna.com/api/patients?=size=20000");
        JsonPath json = response.jsonPath();
        int id=json.getInt("find{it.email=='dannette.jaskolski@gmail.com'}.id");
        System.out.println("id = " + id);
       Response response1;
        switch (account) {
            case "Admin":
                response1 = ApiUtils.deleteRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"), ConfigReader.getProperty("adminPW")), "https://medunna.com/api/patients/" + id);
                break;
            case "Staff":
                response1 = ApiUtils.deleteRequest(Authentication.generateToken(ConfigReader.getProperty("staffUN"), ConfigReader.getProperty("staffPW")), "https://medunna.com/api/patients/" + id);
                break;
        }
    }

    @And("Admin Hastanin silindigini kontol eder kontrol eder")
    public void adminHastaninSilindiginiKontolEderKontrolEder() {

        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println("actualMap = " + actualMap);
        Assert.assertTrue(actualMap.isEmpty());
    }
    @Given("{string} URLe arama istegi gonderir")
    public void ur_le_arama_istegi_gonderir(String account) {

        switch (account) {
            case "Admin":
                response = ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("adminUN"), ConfigReader.getProperty("adminPW")),
                        "https://medunna.com/api/patients/search?ssn=" + ConfigReader.getProperty("physicianSSN"));
                response.prettyPrint();
                break;
            case "Staff":
                response = ApiUtils.getRequest(Authentication.generateToken(ConfigReader.getProperty("staffUN"), ConfigReader.getProperty("staffPW")),
                        "https://medunna.com/api/patients/search?ssn=" + ConfigReader.getProperty("physicianSSN"));
                response.prettyPrint();
                break;
        }
        }
    @Then("Staff SSN kayitlarini kontorl eder")
    public void staff_ssn_kayitlarini_kontorl_eder() throws IOException {

        PatientsSearchPojo[] actualArray;
        PatientsSearchInPojo user=new PatientsSearchInPojo("anonymousUser","2022-08-01T22:23:54.754787Z",152963,"physician51","Physician51","PROJECT51","physician51@gmail.com",true,"en",null,null,"865-12-6357");
        PatientsSearchPojo patient=new PatientsSearchPojo("anonymousUser","2022-08-03T09:49:56.874400Z",154150,"Physician","PROJECT",null,"5555555555",null,null,null,"physician51@gmail.com",null,user,null,null,null,null);
        PatientsSearchPojo [] expectedData={patient};
        System.out.println("patientList = " + expectedData);
        ObjectMapper obj =new ObjectMapper();
        actualArray=obj.readValue(response.asString(),PatientsSearchPojo[].class);
        
          Assert.assertEquals(expectedData [0].getEmail(),actualArray[0].getEmail());
          Assert.assertEquals(expectedData [0].getUser().getSsn(),actualArray[0].getUser().getSsn());

       
    }




}







