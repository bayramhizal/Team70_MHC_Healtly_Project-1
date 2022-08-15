package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DoktorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static utilities.ReusableMethods.waitFor;

public class US_011 {

    DoktorPage doktorPage = new DoktorPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Given("kullanici {string} e gider.")
    public void kullanici_e_gider(String medunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("kullanici Sign In butonunu bulur ve tiklar")
    public void kullanici_sign_in_butonunu_bulur_ve_tiklar() {
        doktorPage.kullaniciResmibutonu.click();
        doktorPage.signInButton.click();
    }

    @Then("kullanici doktor plarak username ve password text boxlarina dogru bilgileri girer")
    public void kullanici_doktor_plarak_username_ve_password_text_boxlarina_dogru_bilgileri_girer() {
        doktorPage.usernameBox.sendKeys(ConfigReader.getProperty("doktorUsername"));
        doktorPage.passwordBox.sendKeys(ConfigReader.getProperty("doktorPassword"));
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
        waitFor(2);
        Assert.assertTrue(doktorPage.idButton.isDisplayed());
        Assert.assertTrue(doktorPage.endDateTimeButton.isDisplayed());
        Assert.assertTrue(doktorPage.startDateTimeButton.isDisplayed());
        Assert.assertTrue(doktorPage.statusButton.isDisplayed());
        Assert.assertTrue(doktorPage.physicianButton.isDisplayed());
        Assert.assertTrue(doktorPage.patientButton.isDisplayed());
    }


    @Then("Doktor hasta bilgilerinin dolu oldugunu test eder")
    public void doktor_hasta_bilgilerinin_dolu_oldugunu_test_eder() {
        waitFor(2);
        List<WebElement> hastaBilgileriGuncel = doktorPage.hastaBilgileriList;
        for (WebElement each : hastaBilgileriGuncel) {
            System.out.println(each.getText());
        }

    }

    @And("Doktor patent id,start and end date,Status textboxlarinin dolu oldugunu gorur.")
    public void doktorPatentIdStartAndEndDateStatusTextboxlarininDoluOldugunuGorur() {
        waitFor(2);
        doktorPage.patientAhmEditButton.click();
        Assert.assertFalse(doktorPage.IdStartEndTimesTextBoxList.isEmpty());


    }


    @Then("Doktor Anmnesis,Treatment ve Diagnosis sekmelerini gorur")
    public void doktor_anmnesis_treatment_ve_diagnosis_sekmelerini_gorur() {
        waitFor(2);
        Assert.assertTrue(doktorPage.anamnesisButton.isDisplayed());
        Assert.assertTrue(doktorPage.treatmentButton.isDisplayed());
        Assert.assertTrue(doktorPage.diagnosisButton.isDisplayed());
    }

    @Then("Doktor Anmnesis,Treatment ve Diagnosis alanlari doldurur ve bos olmadigi test eder.")
    public void doktor_anmnesis_treatment_ve_diagnosis_alanlari_doldurur_ve_bos_olmadigi_test_eder() {
        waitFor(2);
        doktorPage.anamnesisTextButton.sendKeys("..");
        doktorPage.treatmentTextButton.sendKeys("..");
        doktorPage.diagnosisTextButton.sendKeys("..");
        Assert.assertFalse(doktorPage.anamnesisTextButton.getText().isEmpty());
        Assert.assertFalse(doktorPage.treatmentTextButton.getText().isEmpty());
        Assert.assertFalse(doktorPage.diagnosisTextButton.getText().isEmpty());
    }

    @Then("bu alanlardan Diagnosis alani kasitli olarak bos birakir")
    public void bu_alanlardan_diagnosis_alani_kasitli_olarak_bos_birakir() {
        waitFor(2);
        doktorPage.diagnosisTextButton.clear();
    }

    @Then("Saved butonuna basar ve guncellemenin basarili olmadigini test eder")
    public void saved_butonuna_basar_ve_guncellemenin_basarili_olmadigini_test_eder() {
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", doktorPage.saveButton);
        jse.executeScript("arguments[0].click();", doktorPage.saveButton);
        // doktorPage.saveButton.click();
        waitFor(1);
        String expectedResult = "This field is required.";
        String actualResult = doktorPage.fielRequiredButton.getText();
        System.out.println(doktorPage.fielRequiredButton.getText());
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Then("Doktor Status sekmesini bulur")
    public void doktor_status_sekmesini_bulur() {
        doktorPage.statusButton.isDisplayed();
    }

    @Then("Doktor Status sekmesinden PENDING,COMPLETED,CANCELLED olarak secebilir")
    public void doktor_status_sekmesinden_pending_completed_cancelled_olarak_secebilir() {
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", doktorPage.statusSelectButton);
        jse.executeScript("arguments[0].click();", doktorPage.statusSelectButton);
        //doktorPage.statusSelectButton.click();
        waitFor(1);
        Select select = new Select(doktorPage.statusSelectButton);
       // doktorPage.statusSelectButton.click();
        List<WebElement> statusList = select.getAllSelectedOptions();
        //statusList.stream().forEach(t -> System.out.println(t.getText()));

        for (WebElement each : statusList
        ) {
            System.out.println(each.getText());
        }
        select.selectByVisibleText("PENDING");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();
        waitFor(4);
    }

    @Then("Doktor Status sekmesini CANCELLED olarak secer")
    public void doktor_status_sekmesini_cancelled_olarak_secer() {
        waitFor(2);
        // jse.executeScript("arguments[0].scrollIntoView(true);",doktorPage.statusSelectButton);
        waitFor(1);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.UP).perform();
        //jse.executeScript("arguments[0].click();",doktorPage.statusSelectButton);
        Select select = new Select(doktorPage.statusSelectButton);
        //  doktorPage.statusSelectButton.click();
        select.selectByVisibleText("CANCELLED");
        waitFor(1);
        String expectedResult = "CANCELLED";
        waitFor(2);
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("=====================================");
        System.out.println(doktorPage.statusSelectButton.getText());
    }


    @Then("Prescription ve Description alanlari bos birakilir.")
    public void prescription_ve_description_alanlari_bos_birakilir() {
        waitFor(2);
        doktorPage.prescriptionTextButton.clear();
        doktorPage.descriptionTextButton.clear();
    }

    @Then("Doktor Save butonunu bulup click yapar")
    public void doktor_save_butonunu_bulup_click_yapar() {
        jse.executeScript("arguments[0].scrollIntoView(true);", doktorPage.saveButton);
        jse.executeScript("arguments[0].click();", doktorPage.saveButton);
    }

    @Then("Doktor Appointments is updated yazisini dogrular")
    public void doktor_appointments_is_updated_yazisini_dogrular() {
        waitFor(2);
        String arananCumle = "Appointment is updated";
        String actualResult = doktorPage.upLoadButton.getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains(arananCumle));
    }

    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        // Driver.closeDriver();
    }


}
