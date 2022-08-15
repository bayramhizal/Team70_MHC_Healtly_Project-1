package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.DoktorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utilities.ReusableMethods.waitFor;

public class US_011 {

    DoktorPage doktorPage = new DoktorPage();
    Select select;

    @Given("kullanici {string} e gider.")
    public void kullanici_e_gider(String medunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("kullanici Sign In butonunu bulur ve tiklar")
    public void kullanici_sign_in_butonunu_bulur_ve_tiklar() {
        doktorPage.signInButton.click();
    }

    @Then("kullanici doktor plarak username ve password text boxlarina dogru bilgileri girer")
    public void kullanici_doktor_plarak_username_ve_password_text_boxlarina_dogru_bilgileri_girer() {
        doktorPage.usernameBox.sendKeys(ConfigReader.getProperty("doktorUsername"));
        doktorPage.usernameBox.sendKeys(ConfigReader.getProperty("doktorPassword"));
    }

    @Then("Sign in butonunu tiklar")
    public void sign_in_butonunu_tiklar() {
        doktorPage.signInButton2.click();
    }

    @Then("Doktor MYPAGES segmentine gider ve tiklar")
    public void doktor_mypages_segmentine_gider_ve_tiklar() {
        doktorPage.myPagesButton.click();
    }

    @Then("Ve MYPAGES altindaki My Appointments sekmesini tiklar")
    public void ve_mypages_altindaki_my_appointments_sekmesini_tiklar() {
        doktorPage.myAppointmentUstButton.click();
    }

    @Then("Doktor Edit butonunu tiklar")
    public void doktor_edit_butonunu_tiklar() {
        doktorPage.patientAhmEditButton.click();
    }

    @Then("Doktor patent id,start and end date,Status,physician and patient butonlarini gorur")
    public void doktor_patent_id_start_and_end_date_status_physician_and_patient_butonlarini_gorur() {
        Driver.getDriver().navigate().back();
        Assert.assertTrue(doktorPage.idButton.isDisplayed());
        Assert.assertTrue(doktorPage.endDateTimeButton.isDisplayed());
        Assert.assertTrue(doktorPage.startDateTimeButton.isDisplayed());
        Assert.assertTrue(doktorPage.statusButton.isDisplayed());
        Assert.assertTrue(doktorPage.physicianButton.isDisplayed());
        Assert.assertTrue(doktorPage.patientButton.isDisplayed());
    }


    @Then("Doktor hasta bilgilerinin dolu oldugunu test eder")
    public void doktor_hasta_bilgilerinin_dolu_oldugunu_test_eder() {
        List<WebElement> hastaBilgileriGuncel = doktorPage.hastaBilgileriList;
        for (WebElement each : hastaBilgileriGuncel) {
            System.out.println(each.getText());
        }

    }

    @And("Doktor patent id,start and end date,Status textboxlarinin dolu oldugunu gorur.")
    public void doktorPatentIdStartAndEndDateStatusTextboxlarininDoluOldugunuGorur() {
        doktorPage.patientAhmEditButton.click();
        List<WebElement> textBoxKontrolList = doktorPage.IdStartEndTimesTextBoxList;
        for (WebElement each : textBoxKontrolList) {
            Assert.assertFalse(each.getText().isEmpty());


        }

    }


    @Then("Doktor Anmnesis,Treatment ve Diagnosis sekmelerini gorur")
    public void doktor_anmnesis_treatment_ve_diagnosis_sekmelerini_gorur() {
        Assert.assertTrue(doktorPage.anamnesisButton.isDisplayed());
        Assert.assertTrue(doktorPage.treatmentButton.isDisplayed());
        Assert.assertTrue(doktorPage.diagnosisButton.isDisplayed());
    }

    @Then("Doktor Anmnesis,Treatment ve Diagnosis alanlari doldurur ve bos olmadigi test eder.")
    public void doktor_anmnesis_treatment_ve_diagnosis_alanlari_doldurur_ve_bos_olmadigi_test_eder() {
        doktorPage.anamnesisTextButton.sendKeys("..");
        doktorPage.treatmentTextButton.sendKeys("..");
        doktorPage.diagnosisTextButton.sendKeys("..");
        Assert.assertFalse(doktorPage.anamnesisTextButton.getText().isEmpty());
        Assert.assertFalse(doktorPage.treatmentTextButton.getText().isEmpty());
        Assert.assertFalse(doktorPage.diagnosisTextButton.getText().isEmpty());
    }

    @Then("bu alanlardan Diagnosis alani kasitli olarak bos birakir")
    public void bu_alanlardan_diagnosis_alani_kasitli_olarak_bos_birakir() {
        doktorPage.diagnosisTextButton.clear();
    }

    @Then("Saved butonuna basar ve guncellemenin basarili olmadigini test eder")
    public void saved_butonuna_basar_ve_guncellemenin_basarili_olmadigini_test_eder() {
        doktorPage.saveButton.click();
        String expectedResult = "This field is required.";
        String actualResult = doktorPage.fielRequiredButton.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Then("Doktor Status sekmesini bulur")
    public void doktor_status_sekmesini_bulur() {
        doktorPage.statusButton.isDisplayed();
    }

    @Then("Doktor Status sekmesinden PENDING,COMPLETED,CANCELLED olarak secebilir")
    public void doktor_status_sekmesinden_pending_completed_cancelled_olarak_secebilir() {
        select = new Select(doktorPage.statusSelectButton);
        List<WebElement> statusList = select.getAllSelectedOptions();
        statusList.forEach(t -> System.out.println(t.getText()));
        select.deselectByVisibleText("PENDING");
    }

    @Then("Doktor Status sekmesini CANCELLED olarak secer")
    public void doktor_status_sekmesini_cancelled_olarak_secer() {
        select = new Select(doktorPage.statusSelectButton);
        select.deselectByVisibleText("CANCELLED");
        String expectedResult = "CANCELLED";
        String actualResult=doktorPage.statusSelectButton.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Then("Prescription ve Description alanlari bos birakilir.")
    public void prescription_ve_description_alanlari_bos_birakilir() {
        doktorPage.prescriptionTextButton.clear();
        doktorPage.descriptionTextButton.clear();
    }

    @Then("Doktor Save butonunu bulup click yapar")
    public void doktor_save_butonunu_bulup_click_yapar() {
      doktorPage.saveButton.click();
    }

    @Then("Doktor Appointments is updated yazisini dogrular")
    public void doktor_appointments_is_updated_yazisini_dogrular() {
      // Driver.getDriver().navigate().back();
       doktorPage.upLoadButton.click();
       waitFor(1);
       String arananCumle="Appointments is updated";
       String actualResult = doktorPage.upLoadButton.getText();
       Assert.assertTrue(actualResult.contains(arananCumle));
    }

    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
       Driver.closeDriver();
    }


}
