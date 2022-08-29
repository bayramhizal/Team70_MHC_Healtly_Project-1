package stepDefinitions.jdbcsStepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.ReadTxt;
import utilities.WriteToTxt;
import java.util.List;

public class US27_JdbcStepDefinitions {

    public static List<Object> allDBIDs;
    String messageIds;

    @Given("kullanici DB e messages ile ilgili {string} sorgusu gonderir ve column data {string} i alir")
    public void kullaniciDBEMessagesIleIlgiliSorgusuGonderirVeColumnDataIAlir(String query, String columnName) {
        allDBIDs = DBUtils.getColumnData(query, columnName);
        System.out.println(allDBIDs);
        messageIds="src/test/resources/testData/MessageID.txt";
        WriteToTxt.saveAccountIds(messageIds,allDBIDs);

    }


 @Then("kullanici DB de messages ile ilgili kayit bilgilerini dogrular")
    public void kullaniciDBDeMessagesIleIlgiliKayitBilgileriniDogrular() {
     List<Object> actualMessageIds= ReadTxt.returnAccontIDsList(messageIds);
     Object expectedID = 235539;
     Assert.assertTrue("IDLER KAYITLI DEGIL",actualMessageIds.contains(expectedID));

 }


    @And("Baglantiyi sonlandirir")
    public void baglantiyiSonlandirir() {

        DBUtils.closeConnection();
    }
}
