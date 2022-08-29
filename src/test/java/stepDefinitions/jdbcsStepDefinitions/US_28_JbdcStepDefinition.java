package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.*;

public class US_28_JbdcStepDefinition {

    static String query;
    List<Object> IdList;
    List<Object> expectedIDList;


    @Given("Kullanici database connect olur")
    public void kullanici_database_connect_olur() {
        createConnection();
    }

    @Given("Kullanici id nolari alir")
    public void kullanici_id_nolari_alir() {
        query = "select * from jhi_user";
        System.out.println(getColumnNames(query) +"\n");

        IdList = getColumnData(query, "IdList");
        System.out.println(IdList + "\n");

        String countryId="src/test/resources/testData/countryId.txt";
        WriteToTxt.saveAccountIds(countryId,IdList);

        expectedIDList=new ArrayList<>();
        expectedIDList.add("990-525-7755");
        expectedIDList.add("990-524-7755");
        expectedIDList.add("990-523-7755");



    }

    @Then("Kullanici id nolari dogrular")
    public void kullanici_id_nolari_dogrular() {
        Assert.assertFalse("Id listede yok",IdList.containsAll(expectedIDList));
    }
}
