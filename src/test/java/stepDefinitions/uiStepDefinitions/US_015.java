package stepDefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.MedunnaPage;

public class US_015 {

    AdminPage admin=new AdminPage();
    MedunnaPage medunna=new MedunnaPage();
    Actions actions;
    Select select;
    Faker faker;


    @Given("kullanici sisteme {string} olarak giris yapar")
    public void kullaniciSistemeOlarakGirisYapar(String arg0) {
    }

    @And("kullanici Item&Title sekmesinden Patient elementine tiklar")
    public void kullaniciItemTitleSekmesindenPatientElementineTiklar() {
    }

    @Then("kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular")
    public void kullaniciCreateANewPatientSekmesininGorunurOldugunuDogrular() {
    }

    @Then("kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular")
    public void kullaniciCreateANewPatientSekmesininErisilebilirOldugunuDogrular() {
    }

    @When("kullanici Create a new Patient sekmesine tiklar")
    public void kullaniciCreateANewPatientSekmesineTiklar() {
    }

    @Then("kullanici hasta olusturma sayfasina yonlendirildigini dogrular")
    public void kullaniciHastaOlusturmaSayfasinaYonlendirildiginiDogrular() {
    }

    @And("kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner")
    public void kullaniciAlttaBulunanBackButonunaTiklarVePatientSayfasinaDoner() {
    }

    @Then("kullanici yeni hasta kaydinin yapilamadigini dogrular")
    public void kullaniciYeniHastaKaydininYapilamadiginiDogrular() {
    }

    @When("kullanici Patients tablosundaki sutun basliklarini alir")
    public void kullaniciPatientsTablosundakiSutunBasliklariniAlir() {
    }

    @Then("kullanici tum basliklarin gorunur oldugunu dogrular")
    public void kullaniciTumBasliklarinGorunurOldugunuDogrular() {
    }

    @And("kullanici tum hasta bilgilerini dogrular")
    public void kullaniciTumHastaBilgileriniDogrular() {
    }


}
