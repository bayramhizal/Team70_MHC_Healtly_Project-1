package stepDefinitions.jdbcsStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.DBUtils.*;

public class US01_US02 {


    static String query;
    List<Object> ssnList;
    List<Object> expectedSsnList;
    List<Object> emailList;
    List<Object> expectedEmailList;

    @Given("kullanici database baglanir")
    public void kullanici_database_baglanir() {
        createConnection();
    }


    @And("kullanici SSN kimliklerini alir")
    public void kullaniciSSNKimlikleriniAlir() {

        query = "select * from jhi_user";
        System.out.println(getColumnNames(query) + "\n");

        ssnList = getColumnData(query , "ssn") ;
        System.out.println(ssnList + "\n");

        String ssnID="src/test/resources/testData/ssn.txt";
        WriteToTxt.saveAccountIds(ssnID ,ssnList);

       // List <Object> actualSsnList= ReadTxt.returnAccontIDsList(ssnID);
        expectedSsnList= new ArrayList<>();
        expectedSsnList.add("856-45-6788");
        expectedSsnList.add("828-37-5088");
        expectedSsnList.add("542-59-8193");
    }


    @Then("kullanici SSN kimliklerini dogrular")
    public void kullaniciSSNKimlikleriniDogrular() {
        Assert.assertTrue("SSN içerde yok" , ssnList.containsAll(expectedSsnList));
    }


    @And("kullanici Email verilerini alir")
    public void kullaniciEmailVerileriniAlir() {

        query = "select * from jhi_user";
        System.out.println(getColumnNames(query) + "\n");

        emailList = getColumnData(query , "email") ;
        System.out.println(emailList + "\n");

        String email="src/test/resources/testData/email.txt";
        WriteToTxt.saveAccountIds(email ,emailList);

        expectedEmailList= new ArrayList<>();
        expectedEmailList.add("anonymous@localhost");



    }


    @Then("kullanici Email verilerini dogrular")
    public void kullaniciEmailVerileriniDogrular() {
        Assert.assertTrue("Email içerde yok" , emailList.containsAll(expectedEmailList));
    }






}
















