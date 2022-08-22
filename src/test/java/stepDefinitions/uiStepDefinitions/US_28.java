package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.PatientPage;

public class US_28 {
    PatientPage life = new PatientPage();

    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {

    }

    @When("Accounta gider tiklar")
    public void accounta_gider_tiklar() {
        life.accountTikla.click();
    }

    @When("Birinci SIgnIn e tiklar")
    public void birinci_s_ign_in_e_tiklar() {
        life.firstSignIn.click();
    }

    @When("Username ve password girer")
    public void username_ve_password_girer() {
        life.firstUserName.sendKeys("team70");
        life.firstpassword.sendKeys("team7044.");
    }

    @When("SignIn e tiklar")
    public void sign_in_e_tiklar() {
        life.SecondSignIn.submit();
    }

    @When("Items Title tiklar")
    public void items_title_tiklar() {
        life.ItemsTitleTikla.click();
    }

    @When("Country e tiklar")
    public void country_e_tiklar() {
        life.CountryTikla.click();
    }

    @When("Create butonuna tiklar")
    public void create_butonuna_tiklar() {
        life.CreateNewCountry.click();
    }

    @When("Ulke name girer")
    public void ulke_name_girer() {
        life.CountryNameGir.sendKeys("Spain");
    }

    @When("Save tiklar")
    public void save_tiklar() {
        life.SaveTikla.click();
    }

    @Then("Kayit oldugunu gosterir")
    public void kayit_oldugunu_gosterir() {
        Assert.assertTrue(life.SaveTextGorunurlugu.isDisplayed());

    }
    //TC_02
    @Given("Kull Anasayfa ya gider")
    public void Kull_anasayfaYaGider () {
    }

    @When("Kull hesabina tiklar")
    public void Kull_hesabinaTiklar() {
        life.accountTikla.click();

    }
    @And("Kull Sign In yapar")
    public void Kull_signInYapar() {
        life.firstSignIn.click();
    }
    @And("Kull UserName ve password girer")
    public void Kull_userName_ve_password_girer () {
        life.firstUserName.sendKeys("team70");
        life.firstpassword.sendKeys("team7044.");

    }
    @And("Kull Ikinci SignIn e tiklar")
    public void Kull_ikinci_Sign_in_e_tiklar () {
        life.SecondSignIn.submit();

    }
    @And("Kull Ikinci Items Title gider")
    public void Kull_ikinci_Items_Title_gider () {
        life.ItemsTitleTikla.click();
    }

    @And("Kull State_City tiklar")
    public void Kull_state_city_tiklar () {
        life.StateCityTiklar.click();

    }

    @And("Kull Create a new state_city")
    public void Kull_create_a_new_state_city () {
        life.CreateNewCity.click();
        life.StateName.sendKeys("Miami");
        life.StateState.sendKeys("Germany");
    }

    @And("Kull Save butonuna tiklar")
    public void Kull_save_butonuna_tiklar () {
        life.SaveEntity.click();

    }

    @Then("Kull Kayit yapildigini dogrular")
    public void Kull_kayit_yapildigini_dogrular () {
        Assert.assertTrue(life.HataYazisi.isDisplayed());

    }

}


