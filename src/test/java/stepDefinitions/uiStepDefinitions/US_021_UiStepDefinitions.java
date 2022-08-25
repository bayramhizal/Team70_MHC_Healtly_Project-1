package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.StaffPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static io.cucumber.messages.internal.com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static utilities.ReusableMethods.getElementsText;
import static utilities.ReusableMethods.waitFor;

public class US_021_UiStepDefinitions {

    StaffPage staffPage = new StaffPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    int yil;

    @Then("Kullanici  Valid username ve Password girerek Staff olarak sisteme girer")
    public void kullanici_valid_username_ve_password_girerek_staff_olarak_sisteme_girer() {
        staffPage.usernameStaff.sendKeys(ConfigReader.getProperty("staffUsername"));
        staffPage.passwordStaff.sendKeys(ConfigReader.getProperty("staffPassword"));
        staffPage.signInButton2.click();
    }

    @Then("Kullanici MYPAGES butonu altinda ki Search Patient sekmmesine tiklar")
    public void kullanici_mypages_butonu_altinda_ki_search_patient_sekmmesine_tiklar() {
        staffPage.myPage.click();
        staffPage.searchPatient.click();
    }

    @Then("Kullanici Patient SSN text box ina guncellemek istedigi hastanin ssn numarasini girer")
    public void kullanici_patient_ssn_text_box_ina_guncellemek_istedigi_hastanin_ssn_numarasini_girer() {
        staffPage.patientSSN.sendKeys(ConfigReader.getProperty("patienttSSN"));

    }

    @Then("Kullanici cikan ekranda Show Appointments butonunu tiklar")
    public void kullanici_cikan_ekranda_show_appointments_butonunu_tiklar() {
        jse.executeScript("arguments[0].scrollIntoView(true);", staffPage.showAppointments);
        jse.executeScript("arguments[0].click();", staffPage.showAppointments);
    }

    @Then("Kullanici tekrar Edit butonuna tiklar")
    public void kullanici_tekrar_edit_butonuna_tiklar() {
        jse.executeScript("arguments[0].scrollIntoView(true);",staffPage.EditButton);
        staffPage.EditButton.click();
        waitFor(3);
    }

    @Given("Kullanici Start date guncelleyebilir")
    public void kullanici_start_date_guncelleyebilir() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        // DateTimeFormatter formatterSaat=DateTimeFormatter.ofPattern("h:mm");
        String dateStr = formatter.format(date);
        //  String dateStrSaat=formatterSaat.format(date);

        staffPage.startDate.sendKeys(dateStr);
        waitFor(3);

    }

    @Then("kullanici End date guncelleyebilir")
    public void kullanici_end_date_guncelleyebilir() {

        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd-YYYY h:mm");
        date1 = date1.plusDays(5);
        String dateStr1 = formatter1.format(date1);
        System.out.println("date2 " + dateStr1);
        staffPage.endDate.sendKeys(dateStr1);
        waitFor(2);
    }

    @Given("Kullanici Status secenegini bulup butun opsiyonlari secebilmeli")
    public void kullaniciStatusSeceneginiBulupButunOpsiyonlariSecebilmeli() {
        Select select = new Select(staffPage.statusSelectButton);
        System.out.println("Butun opsiyonlar " + getElementsText(select.getOptions())); //Reusable methoddan
        select.selectByVisibleText("PENDING");
        String expectedResult = "PENDING";
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult, actualResult);

        select.selectByVisibleText("UNAPPROVED");
        String expectedResult1 = "UNAPPROVED";
        String actualResult1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult, actualResult);

        select.selectByVisibleText("CANCELLED");
        String expectedResult2 = "CANCELLED";
        String actualResult2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Then("Kullanici COMPLETED opsiyonu secememeli")
    public void kullaniciCOMPLETEDOpsiyonuSecememeli() {
        Select select = new Select(staffPage.statusSelectButton);
        select.selectByVisibleText("COMPLETED");
        String expectedResult = "COMPLETED";
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertFalse(expectedResult == actualResult);
    }

    @Then("Kullanici Saved butonuna basip,secilen statunun basariyla degistirildigini gormelidir")
    public void kullaniciSavedButonunaBasipSecilenStatununBasariylaDegistirildiginiGormelidir() {
        Select select = new Select(staffPage.statusSelectButton);
        select.selectByVisibleText("PENDING");
        jse.executeScript("arguments[0].scrollIntoView(true);", staffPage.savedButton);
        jse.executeScript("arguments[0].click();", staffPage.savedButton);
        waitFor(3);
        Assert.assertTrue(staffPage.savedButton.isDisplayed());
    }


    @Given("Kullanici Anamnesis alanina {string} girisi yapip yapamadigi test edebilmeli")
    public void kullaniciAnamnesisAlaninaGirisiYapipYapamadigiTestEdebilmeli(String Veri1) {
        staffPage.anamnesisButton.clear();
        staffPage.anamnesisButton.sendKeys(ConfigReader.getProperty("Veri1"));
        Assert.assertFalse(staffPage.anamnesisButton.getText().isEmpty());
    }

    @Then("Kullanici Treatment alannina {string} girisi yapip yapamadigi test edebilmeli")
    public void kullaniciTreatmentAlanninaGirisiYapipYapamadigiTestEdebilmeli(String Veri2) {
        staffPage.treatmentButton.clear();
        staffPage.treatmentButton.sendKeys(ConfigReader.getProperty("Veri2"));
        Assert.assertFalse(staffPage.treatmentButton.getText().isEmpty());
    }

    @Then("Kullanici Diagnosis alanina {string} girisi yapip yapamadigi test edebilmeli")
    public void kullaniciDiagnosisAlaninaGirisiYapipYapamadigiTestEdebilmeli(String Veri3) {
        staffPage.diagnosisButton.clear();
        staffPage.diagnosisButton.sendKeys(ConfigReader.getProperty("Veri3"));
        Assert.assertFalse(staffPage.diagnosisButton.getText().isEmpty());
    }

    @Given("Kullanici gerekli doktoru secer")
    public void kullaniciGerekliDoktoruSecer() {
        jse.executeScript("arguments[0].scrollIntoView(true);",staffPage.physicianButton);
        Select select = new Select(staffPage.physicianButton);
        waitFor(2);
        select.selectByValue("154300");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Then("Saved butonuna tiklar")
    public void savedButonunaTiklar() {
        jse.executeScript("arguments[0].scrollIntoView(true);", staffPage.savedButton);
        jse.executeScript("arguments[0].click();", staffPage.savedButton);

    }

    @And("kullanici guncellemenin basarili oldugunu gorur")
    public void kullaniciGuncellemeninBasariliOldugunuGorur() {
        //https://medunna.com/search-patient?page=1&sort=id,asc
        waitFor(3);
        String expectedResult = "https://www.medunna.com/search-patient?page=1&sort=id,asc";
        String actualResult = Driver.getDriver().getCurrentUrl();
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("Start yil ve End yil {string}den buyuk olmamali")
    public void startYilVeEndYilDenBuyukOlmamali(String yil) {
       staffPage.startDate.getAttribute("value").substring(0,5);
       int expectedResult=2022;
       int actualResult= Integer.parseInt(staffPage.startDate.getAttribute("value").substring(0,5));
       Assert.assertTrue((expectedResult==actualResult)||(expectedResult>actualResult));


    }
}
