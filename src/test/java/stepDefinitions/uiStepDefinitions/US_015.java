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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static utilities.ReusableMethods.clickWithJScript;
import static utilities.ReusableMethods.waitFor;

public class US_015 {

    AdminPage admin=new AdminPage();
    MedunnaPage medunna=new MedunnaPage();
    Actions action;
    Select select;
    Faker faker;
    JavascriptExecutor js;
    DateTimeFormatter date;
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


        try {
            Assert.assertTrue( hastaBilgileriTumSutunBasliklari.contains(hastaBilgisi) );
        } catch (Exception e ) {
            js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView()", admin.hastaBilgileriSutunBasliklari);
            System.out.println("Web Element bulunamadı");
        }


    }


    @And("kullanici hasta first name kutucugunu doldurur")
    public void kullaniciHastaFirstNameKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientFirstName.sendKeys(faker.name().firstName());
    }

    @And("kullanici hasta last name kutucugunu doldurur")
    public void kullaniciHastaLastNameKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientLastName.sendKeys(faker.name().lastName());
    }

    @And("kullanici hasta birth date kutucugunu doldurur")
    public void kullaniciHastaBirthDateKutucugunuDoldurur() {
        faker=new Faker();
        //date=DateTimeFormatter.ofPattern(ConfigReader.getProperty("birthDate"));
        admin.patientBirthDate.sendKeys( ConfigReader.getProperty("birthDatee") ,
                Keys.TAB, ConfigReader.getProperty("birthDateTimee") , Keys.TAB,Keys.DELETE );
    }

    @And("kullanici hasta email kutucugunu doldurur")
    public void kullaniciHastaEmailKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientEmail.sendKeys(faker.internet().emailAddress() , Keys.TAB,Keys.DELETE );
    }

    @And("kullanici hasta phone kutucugunu doldurur")
    public void kullaniciHastaPhoneKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientPhone.sendKeys(faker.phoneNumber().subscriberNumber(10));
    }

    @And("kullanici hasta gender dropdown menusunden cinsiyet secer")
    public void kullaniciHastaGenderDropdownMenusundenCinsiyetSecer() {
        faker=new Faker();
        select=new Select(admin.patientGender);
        select.selectByIndex(faker.random().nextInt(0 , 2));

    }

    @And("kullanici hasta blood group dropdown menusunden kan grubu secer")
    public void kullaniciHastaBloodGroupDropdownMenusundenKanGrubuSecer() {
        faker=new Faker();
        select=new Select(admin.patientBloodGroup);
        select.selectByIndex(faker.random().nextInt(0,7));
    }

    @And("kullanici hasta address kutucugunu doldurur")
    public void kullaniciHastaAddressKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientAdress.sendKeys(faker.address().fullAddress());
    }

    @And("kullanici hasta description kutucugunu doldurur")
    public void kullaniciHastaDescriptionKutucugunuDoldurur() {
        faker=new Faker();
        admin.patientDescription.sendKeys(faker.business().creditCardType() );
    }

    @And("kullanici hasta user dropdown menusunden kullanici secer")
    public void kullaniciHastaUserDropdownMenusundenKullaniciSecer() {
        faker=new Faker();
        select=new Select(admin.patientUserSelect);
        select.selectByIndex(faker.random().nextInt(0,11));
    }

    @And("kullanici hasta country dropdown menusunden ulke secer")
    public void kullaniciHastaCountryDropdownMenusundenUlkeSecer() {

        select=new Select(admin.patientCountry);
        select.selectByValue("80065");
        // diger USA Value = 238484
        select.getFirstSelectedOption().click();
    }

    @And("kullanici hasta state dropdown menusunden sehir secer")
    public void kullaniciHastaStateDropdownMenusundenSehirSecer() {

        select=new Select(admin.patientStateCity);

        try {
            select.selectByValue("43522");
        } catch (Exception e) {
            try{
                select.selectByVisibleText("California");
            } catch (Exception f ){
                select.selectByIndex(0);
            }
        }
        waitFor(1);
    }


    @Then("kullanici A Patient is created yazisinin goruldugunu dogrular")
    public void kullaniciAPatientIsCreatedYazisininGoruldugunuDogrular() {
            Assert.assertTrue( admin.alertYazisiGenel.isDisplayed() );
            waitFor(2);
    }

    @When("kullanici Patients tablosundaki hastanin Edit butonuna tiklar")
    public void kullaniciPatientsTablosundakiHastaninEditButonunaTiklar() {
        admin.patientEditButtonn.click();
    }


    @Then("kullanici edit a Patient sayfasinda Save butonuna basar")
    public void kullaniciEditAPatientSayfasindaSaveButonunaBasar() {
            js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", admin.patientSaveButtonn);
    }

    @Then("kullanici A Patient is updated yazisinin goruldugunu dogrular")
    public void kullaniciAPatientIsUpdatedYazisininGoruldugunuDogrular() {
        Assert.assertTrue( admin.alertYazisiGenel.isDisplayed() );
        waitFor(2);
    }


    @Then("kullanici doktor atama sekmesini bulur ve doktor atamasi yapilabildigini test eder")
    public void kullaniciDoktorAtamaSekmesiniBulurVeDoktorAtamasiYapilabildiginiTestEder() {


        List<String> hastaDuzenlemeBilgileriBasliklari=new ArrayList<>();

        for (WebElement e:admin.hastaDuzenlemeBilgileriSutunBasliklari
        ) {
            hastaDuzenlemeBilgileriBasliklari.add( e.getText() );
        }

        Assert.assertTrue( "Hastaya doktor atamasi icin bir sekme bulunamadi",
                           hastaDuzenlemeBilgileriBasliklari.contains("Physician"));



    }

    @And("kullanici hasta country dropdown menusunu bos birakir")
    public void kullaniciHastaCountryDropdownMenusunuBosBirakir() {

       // action=new Actions(Driver.getDriver());
       // action.click(admin.patientCountry).perform();
           clickWithJScript(admin.patientCountry);

    }

    @And("kullanici hasta state dropdown menusunu bos birakir")
    public void kullaniciHastaStateDropdownMenusunuBosBirakir() {
       //    action=new Actions(Driver.getDriver());
         // action.click(admin.patientStateCity).perform();

        clickWithJScript(admin.patientStateCity);

    }

    @Then("kullanici A Patient is created yazisinin gorulmedigini dogrular")
    public void kullaniciAPatientIsCreatedYazisininGorulmediginiDogrular() {

        Assert.assertFalse("Alert yazisi gorunur,Patient kaydi yapildi",admin.alertYazisiGenel.isDisplayed());
        Assert.assertFalse( "Alert yazisi erisilebilir,Patient kaydi yapildi",admin.alertYazisiGenel.isEnabled());

    }


    @When("kullanici Patients tablosundaki hastanin Delete butonuna tiklar")
    public void kullaniciPatientsTablosundakiHastaninDeleteButonunaTiklar() {

        admin.patientDeleteButtonn.click();
        admin.patientDeleteConfirmButtonn.click();

    }

    @Then("kullanici A Patient is deleted yazisinin goruldugunu dogrular")
    public void kullaniciAPatientIsDeletedYazisininGoruldugunuDogrular() {

      //  Assert.assertFalse( "Internal Server hatasi" ,admin.deleteAlertErrorYazisi.isDisplayed()  );
        Assert.assertTrue("A Patient is Deleted yazisi gorunmuyor",admin.deleteAlertSuccessYazisi.isEnabled());

    }

}
