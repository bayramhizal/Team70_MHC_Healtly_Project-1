package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import stepDefinitions.apiStepDefinitions.US_017_Api_StepDefinitions;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.*;


public class US17_DataBase_StepDefinition {
    private static Connection connection;

    static String query;

    @Given("Admin Medunna veri tabanina baglanir")
    public void admin_medunna_veri_tabanina_baglanir() {
        createConnection();
    }

    @Then("Admin {string} tablosundaki verileri alir")
    public void admin_tablosundaki_verileri_alir(String account) {
        query = "Select * from " + account;
        System.out.println(getColumnNames(query) + "\n");
    }

    @Then("Admin Test Item tablosundaki olusturdugu testi dogrular")
    public void admin_test_item_tablosundaki_olusturdugu_testi_dogrular() {
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList.toString().contains("132000"));
        System.out.println("idList = " + idList + "\n");
        System.out.println("US_017_Api_StepDefinitions.id = " + US_017_Api_StepDefinitions.id);
        assertTrue(idList.toString().contains(US_017_Api_StepDefinitions.id.toString()));
    }


    //      String patientsIds="src/test/resources/testData/PatientsID.txt";
    //     WriteToTxt.saveAccountIds(patientsIds,idList);

    //      List<Object> actualPatientIds= ReadTxt.returnAccontIDsList(patientsIds);
    //      List<Object> expectedPatienIds=new ArrayList<>(Arrays.asList(16565,169375,160154));
    //      Assert.assertTrue("IDLER KAYITLI DEGIL",actualPatientIds.containsAll(expectedPatienIds));


}
