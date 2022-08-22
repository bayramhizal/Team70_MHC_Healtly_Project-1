package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import pages.StaffPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static io.cucumber.messages.internal.com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static utilities.ReusableMethods.waitFor;

public class US_021_UiStepDefinitions {

    StaffPage staffPage = new StaffPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

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
        staffPage.EditButton.click();
        waitFor(3);
    }

    @Given("Kullanici Start date guncelleyebilir")
    public void kullanici_start_date_guncelleyebilir() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy H:mm");
        Date date = new Date();
       // date.after()
        System.out.println(dateFormat.format(date));



    }

    @Then("kullanici End date guncelleyebilir")
    public void kullanici_end_date_guncelleyebilir() {
        System.out.println(staffPage.endDate.getText());
    }

}
