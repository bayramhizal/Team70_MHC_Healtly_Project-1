package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static utilities.DBUtils.*;

public class Us_016_Db_StepDefinitions {
    static String query;
    static ResultSet resultSet;

    @Given("kullanici room database ile baglanti kurar")
    public void kullanici_room_database_ile_baglanti_kurar() {
        createConnection();
    }

    @When("kullanici room query tanimlar")
    public void kullanici_room_query_tanimlar() {
        query = "select room_number from room where id=237197";

    }

    @Then("kullanici oda bilgilerini gorebilmeli")
    public void kullanici_oda_bilgilerini_gorebilmeli() throws SQLException {
        String expectedData= String.valueOf(DBUtils.getQueryResultList(query).get(0));
        System.out.println(expectedData.toString());
        System.out.println(getColumnNames(query) + "\n");
        closeConnection();
        createConnection();
        query="select * from room";
      List<Object> idList = DBUtils.getColumnData(query, "id");
        System.out.println(idList);
      int count = 0;
      for (Object id : idList) {
          if (id != "237197") {
              count++;

          }

      }
      System.out.println("count :"+count);

      // //   Object expectedData=getQueryResultList(query).get(count);
      // List<List<Object>> data = getQueryResultList(query);
      // System.out.println("aga bu ne :" + data);
      // List<String> expectedData = new ArrayList<>();

    }


}

