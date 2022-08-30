package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.StaffPage;

public class us22 {

    StaffPage staffPage = new StaffPage();

    @Then("Kullanici show ests butonuna tiklar")
    public void kullanici_show_tests_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(2000);

        staffPage.showTestsButton.click();

    }
    @Then("kullanici gelen sayfada view results butonuna tiklar")
    public void kullanici_gelen_sayfada_view_results_butonuna_tiklar() throws InterruptedException {

        Thread.sleep(2000);
        staffPage.viewTestResultsButton.click();
    }


    @And("kullanici patientin edit butonuna tiklar")
    public void kullaniciPatientinEditButonunaTiklar() {
        staffPage.patientEditButton.click();

    }

    @And("kullanici edit sayfasinda oldugunu ve bilgileri guncelleyebilecegini kontrol eder")
    public void kullaniciEditSayfasindaOldugunuVeBilgileriGuncelleyebileceginiKontrolEder() {
        //String expectedYazi = "Create or edit a Patient";
        Assert.assertTrue(staffPage.EditSayfasiKontrol.isDisplayed());
        //Driver.getDriver().getCurrentUrl();

    }
}
