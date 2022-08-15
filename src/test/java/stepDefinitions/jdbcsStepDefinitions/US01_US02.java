package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.Given;
import utilities.DBUtils;

import static utilities.DBUtils.createConnection;

public class US01_US02 {

    DBUtils database=new DBUtils();



    @Given("kullanici database baglanir")
    public void kullanici_database_baglanir() {

        createConnection();

    }





















}
















