package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminPage;

public class us18 {
    AdminPage adminPage = new AdminPage();

    @Then("kullanici item&title sekmesinden Physicians sekmesine tiklar")
    public void kullanici_item_title_sekmesinden_physicians_sekmesine_tiklar() throws InterruptedException {
        adminPage.ItemsTitle.click();
        adminPage.PhysicianDropdownButton.click();

        Thread.sleep(5000);
    }

    @Given("kullanici doktorlarin gorunurlugunu kontrol eder")
    public void kullanici_doktorlarin_gorunurlugunu_kontrol_eder() {
        Assert.assertTrue(adminPage.PhysicianPageVisible.isDisplayed());


    }


    @Given("kullanici bir doktor secer")
    public void kullanici_bir_doktor_secer() {
        adminPage.PhysicianPageViewButton.click();

    }


    @Given("kullanici physiciansda edit tusuna basar")
    public void kullanici_physiciansda_edit_tusuna_basar() {
        adminPage.PhysicianPageEditButton.click();

    }


    @Then("bilgileri doldurabilecegini kontrol eder")
    public void bilgileri_doldurabilecegini_kontrol_eder() {

        Assert.assertTrue(adminPage.PhysicianEditPageVisible.isDisplayed());
    }



    @Then("Speciality kismindan uzmanlik secer")
    public void speciality_kismindan_uzmanlik_secer() {
        Assert.assertTrue(adminPage.examFeeBox.isEnabled());

    }


    @Then("image kismindan fotograf ayarlayabilir")
    public void image_kismindan_fotograf_ayarlayabilir() {
        Assert.assertTrue(adminPage.imageButton.isDisplayed());

    }



    @Then("doktor ucretini degistirebilir")
    public void doktor_ucretini_degistirebilir() {
        Assert.assertTrue(adminPage.examFeeBox.isEnabled());
    }


    @Given("kullanicilar arasindan doktoru secer")
    public void kullanicilar_arasindan_doktoru_secer() {
        adminPage.PhysicianPageViewButton.click();
    }



    @Given("Physicians listesinde delete butonuna tiklar")
    public void physicians_listesinde_delete_butonuna_tiklar() {
        adminPage.PhysicianPageDeleteButton.click();

    }
}
