package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class US_19 {

    static String query;
    static String deletequery;

    @Then("Kullanici {string} tablosundaki verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String string) {

        query="select * from "+ string;


        System.out.println(DBUtils.getColumnNames(query));


        System.out.println(DBUtils.getColumnData(query,"id"));
    }


    @And("staff tablosunda silinen {string} bilgisini kontrol eder")
    public void staffTablosundaSilinenBilgisiniKontrolEder(String expectedData) {

        List<Object> list=DBUtils.getColumnData(query,"id");
        //     deletequery="delete from cmessage where id='232670'";
        System.out.println(list);
        //     DBUtils.getStatement().execute(deletequery);
        //     System.out.println(list);

        Assert.assertFalse("listede bulundu",list.contains(expectedData));
    }

    @And("Baglantiyi sonlandir")
    public void baglantiyiSonlandir() {

        DBUtils.closeConnection();
    }
}