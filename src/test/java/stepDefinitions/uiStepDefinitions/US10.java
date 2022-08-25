package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.PatientPage;

public class US10 {
    PatientPage patientpage = new PatientPage();

    @Then("Hasta randevularinin goruntulendigini dogrular")
    public void hasta_randevularinin_goruntulendigini_dogrular() {

        Assert.assertTrue(patientpage.dateTime.isDisplayed());
    }

    @Then("Hasta patient id, start date en date, status bilgilerini gorebilmelidir")
    public void hasta_patient_id_start_date_en_date_status_bilgilerini_gorebilmelidir() {
        Assert.assertTrue(patientpage.id.isDisplayed());
        Assert.assertTrue(patientpage.startDateTime.isDisplayed());
        Assert.assertTrue(patientpage.status.isDisplayed());
    }
}
