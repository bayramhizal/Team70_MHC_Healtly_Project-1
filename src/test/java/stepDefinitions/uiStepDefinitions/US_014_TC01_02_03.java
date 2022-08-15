package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DoktorPage;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US_014_TC01_02_03 {

    DoktorPage doktorPage = new DoktorPage();


    @And("doktor inMyInpatients sayfasina gider")
    public void doktorInMyInpatientsSayfasinaGider() {
        doktorPage.myPagesButton.click();
        waitFor(1);
        doktorPage.myInPatientsButton.click();
    }

    @Then("Doktor inPatient Edit butonunu tiklar")
    public void doktor_edit_butonunu_tiklar() {
        doktorPage.myInPatientsEditButton.click();
    }



    @Then("doktor tarafindan {string} durumu guncellenebilmeli")
    public void doktorTarafindanDurumuGuncellenebilmeli() {

        doktorPage.myInPatientsStatusBox.click();

    }


    @Then("doktor tarafindan rezerve edilmis oda guncellenebilmeli")
    public void doktorTarafindanRezerveEdilmisOdaGuncellenebilmeli() {
        doktorPage.myInPatientsRoomSelectBox.click();
    }


    @Then("doktor inMyInpatients sayfasinda {string} basligini gorur")
    public void doktorInMyInpatientsSayfasindaBasliginiGorur(String id) {
        Driver.getDriver().navigate().back();
        waitFor(1);
        Assert.assertTrue(doktorPage.myInPatientsId.getText().contains(id));
    }

    @Then("doktor inMyInpatients sayfasinda {string} Start Date basligini gorur")
    public void doktorInMyInpatientsSayfasindaStartDateBasliginiGorur(String startDate) {
        Assert.assertTrue(doktorPage.myInPatientsStartDate.getText().contains(startDate));
    }

    @Then("doktor inMyInpatients sayfasinda {string} end Date basligini gorur")
    public void doktorInMyInpatientsSayfasindaEndDateBasliginiGorur(String end) {
        Assert.assertTrue(doktorPage.myInPatientsEndDate.getText().contains(end));
    }

    @Then("doktor inMyInpatients sayfasinda {string} status basligini gorur")
    public void doktorInMyInpatientsSayfasindaStatusBasliginiGorur(String status) {
        Assert.assertTrue(doktorPage.myInPatientsStatus.getText().contains(status));
    }

    @Then("doktor inMyInpatients sayfasinda {string} Description basligini gorur")
    public void doktorInMyInpatientsSayfasindaDescriptionBasliginiGorur(String description) {
        Assert.assertTrue(doktorPage.myInPatientsDescription.getText().contains(description));
    }

    @Then("doktor inMyInpatients sayfasinda {string} Created Date basligini gorur")
    public void doktorInMyInpatientsSayfasindaCreatedDateBasliginiGorur(String created) {
        Assert.assertTrue(doktorPage.myInPatientsCreatedDate.getText().contains(created));
    }

    @Then("doktor inMyInpatients sayfasinda {string} room basligini gorur")
    public void doktorInMyInpatientsSayfasindaRoomBasliginiGorur(String room) {
        Assert.assertTrue(doktorPage.myInPatientsRoom.getText().contains(room));
    }

    @Then("doktor inMyInpatients sayfasinda {string} Appointment basligini gorur")
    public void doktorInMyInpatientsSayfasindaAppointmentBasliginiGorur(String appointment) {
        Assert.assertTrue(doktorPage.myInPatientsAppointment.getText().contains(appointment));
    }

    @Then("doktor inMyInpatients sayfasinda {string} Patient basligini gorur")
    public void doktorInMyInpatientsSayfasindaPatientBasliginiGorur(String patient) {
        Assert.assertTrue(doktorPage.myInPatientsPatient.getText().contains(patient));
    }

    @Then("doktor inMyInpatients sayfasinda Status durumunu gorur")
    public void doktorInMyInpatientsSayfasindaStatusDurumunuGorur() {
        doktorPage.statusButton.isDisplayed();
    }
}
