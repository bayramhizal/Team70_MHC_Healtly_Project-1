package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_025 {
    PatientPage patientPage=new PatientPage();
    SoftAssert softAssert=new SoftAssert();
    @Given("User goes to medunna website for patient appointment")
    public void user_goes_to_medunna_website_for_patient_appointment() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Given("user click Sign In button for validation criteria")
    public void user_click_sign_in_button_for_validation_criteria() {
        patientPage.kullaniciIkonu.click();
        patientPage.signInAccount.click();

    }

    @Given("user enter valid username for patient account")
    public void user_enter_valid_username_for_patient_account() {
        patientPage.patientUsernameAccount.sendKeys("hastamed");

    }

    @Given("user enter valid password for patient account")
    public void user_enter_valid_password_for_patient_account() {
        patientPage.patientPasswordAccount.sendKeys("qwer.1234");

    }

    @Given("user click the Sign In button for reach their account")
    public void user_click_the_sign_in_button_for_reach_their_account() {
        patientPage.signInPatientAccount.click();

    }

    @Given("user click the MY PAGES button for a new appointment")
    public void user_click_the_my_pages_button_for_a_new_appointment() {
        patientPage.patientMyPagesButton.click();

    }

    @Given("user click make an appoinment button")
    public void user_click_make_an_appoinment_button() {
        patientPage.patientMakeAppointmentButton.click();

    }

    @Given("user enter valid Phone number {string}")
    public void user_enter_valid_phone_number(String string) {
        patientPage.patientAppointmentPhone.sendKeys(string);

    }

    @Given("user click the send an Appointment Request")
    public void user_click_the_send_an_appointment_request() {
        patientPage.patientNewAppointmenSendButton.click();

    }

    @Then("user verify sees registration saved! toast container")
    public void user_verify_sees_registration_saved_toast_container() {
        softAssert.assertTrue(patientPage.patientAppointmenttoastContainer.isEnabled());
        softAssert.assertAll();

    }



}
