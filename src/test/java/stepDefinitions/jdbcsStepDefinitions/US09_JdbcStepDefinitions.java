package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.*;
import utilities.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.DBUtils.*;

public class US09_JdbcStepDefinitions {
    static String query;
    @Given("Kullanici Medunna veri tabanina baglanir")
    public void kullanici_medunna_veri_tabanina_baglanir() {

        createConnection();
    }

    @Then("Kullanici {string} tablosundaki verileri alir")
    public void kullaniciTablosundakiVerileriAlir(String account) {
        query = "Select * from "+account;
        System.out.println(getColumnNames(query)+"\n");

    }


    @And("Kullanici {string} tablosundaki hastalari dogrular")
    public void kullaniciTablosundakiHastalariDogrular(String account) {

        List<Object> idList=getColumnData(query,"id");
        System.out.println("idList = " + idList+"\n");
        String patientsIds="src/test/resources/testData/PatientsID.txt";
        WriteToTxt.saveAccountIds(patientsIds,idList);

        List<Object> actualPatientIds= ReadTxt.returnAccontIDsList(patientsIds);
        List<Object> expectedPatienIds=new ArrayList<>(Arrays.asList(16565,169375,160154));
        Assert.assertTrue("IDLER KAYITLI DEGIL",actualPatientIds.containsAll(expectedPatienIds));
    }
}
