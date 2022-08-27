package stepDefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utilities.ReusableMethods.waitFor;

public class US_015 {

    AdminPage admin=new AdminPage();
    MedunnaPage medunna=new MedunnaPage();
    Actions action;
    Select select;
    Faker faker;
    JavascriptExecutor js;
    SoftAssert soft=new SoftAssert();


    @Given("kullanici sisteme {string} olarak giris yapar")
    public void kullaniciSistemeOlarakGirisYapar(String girenKisi) {
        action=new Actions(Driver.getDriver());
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty(girenKisi),
                Keys.TAB,ConfigReader.getProperty("tumgirislerpassword"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }

    @And("kullanici Item&Title sekmesinden Patient elementine tiklar")
    public void kullaniciItemTitleSekmesindenPatientElementineTiklar() {
       // select=new Select(admin.itemsTitlesDropdownButon);
       // select.selectByVisibleText("Patient");
        admin.itemsTitlesDropdownButon.click();
        admin.itemsTitlesPatientButon.click();
    }

    @Then("kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular")
    public void kullaniciCreateANewPatientSekmesininGorunurOldugunuDogrular() {
       soft.assertTrue(admin.createANewButton.isDisplayed() , "create butonu gorulemiyor");
    }

    @Then("kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular")
    public void kullaniciCreateANewPatientSekmesininErisilebilirOldugunuDogrular() {
        soft.assertTrue(admin.createANewButton.isEnabled() , "create butonu erisilemiyor");
    }

    @When("kullanici Create a new Patient sekmesine tiklar")
    public void kullaniciCreateANewPatientSekmesineTiklar() {
        admin.createANewButton.click();
    }

    @Then("kullanici hasta olusturma sayfasina yonlendirildigini dogrular")
    public void kullaniciHastaOlusturmaSayfasinaYonlendirildiginiDogrular() {
       soft.assertEquals ( Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("createpatientsayfasi") );
    }

    @And("kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner")
    public void kullaniciAlttaBulunanBackButonunaTiklarVePatientSayfasinaDoner() {
       js = (JavascriptExecutor) Driver.getDriver();
       js.executeScript("arguments[0].scrollIntoView()", admin.createPatientBackButon);
       js.executeScript("arguments[0].click();", admin.createPatientBackButon);
       waitFor(3);
       soft.assertEquals(Driver.getDriver().getCurrentUrl() , ConfigReader.getProperty("patienttablosayfasi"));
       soft.assertAll();
    }

    @Then("kullanici yeni hasta kaydinin yapilamadigini dogrular")
    public void kullaniciYeniHastaKaydininYapilamadiginiDogrular() {

        try {
            Assert.assertTrue( "buton gorunur",admin.createANewButton.isDisplayed());
            Assert.assertTrue( "buton erisilir",admin.createANewButton.isEnabled());
        } catch (Exception e ) {
            System.out.println("create a new patient butonu gozukmediginden hasta kaydı yapılamadı");
            medunna.accountMenu.click();
            medunna.signOut.click();
        }

    }


    @Then("kullanici tum basliklarin gorunur ve erisilebilir oldugunu dogrular")
    public void kullaniciTumBasliklarinGorunurVeErisilebilirOldugunuDogrular() {

        for (WebElement e:admin.hastaBilgileriSutunBasliklari
             ) {
            Assert.assertTrue(e.isDisplayed());
            Assert.assertTrue(e.isEnabled());
        }

    }


    @When("kullanici {string} basliginin oldugunu dogrular")
    public void kullaniciBasligininOldugunuDogrular(String hastaBilgisi) {

        List<String> hastaBilgileriTumSutunBasliklari=new ArrayList<>();

        for (WebElement e:admin.hastaBilgileriSutunBasliklari
             ) {
            hastaBilgileriTumSutunBasliklari.add(e.getText().toString() );
        }

       // Assert.assertTrue( hastaBilgileriTumSutunBasliklari.contains(hastaBilgisi) );

        try {
            Assert.assertTrue( hastaBilgileriTumSutunBasliklari.contains(hastaBilgisi) );
        } catch (Exception e ) {
            js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView()", admin.hastaBilgileriSutunBasliklari);
            System.out.println("Web Element bulunamadı");
        }



    }














}
