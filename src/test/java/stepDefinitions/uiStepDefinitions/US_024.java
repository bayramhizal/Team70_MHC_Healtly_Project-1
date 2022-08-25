package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_024 {
    PatientPage patientPage=new PatientPage();
    SoftAssert softAssert=new SoftAssert();


    @Given("user goes to medunna home page")
    public void user_goes_to_medunna_home_page() {
        Driver.getDriver().get( ConfigReader.getProperty( "medunnaUrl" ) );


    }

    @Given("user click the Sign In button")
    public void user_click_the_sign_in_button() {
        patientPage.kullaniciIkonu.click();
        patientPage.signInAccount.click();


    }

    @Given("user enter valid username")
    public void user_enter_valid_username() {

        patientPage.patientUsernameAccount.sendKeys( "hastamed" );


    }

    @Given("user enter valid password")
    public void user_enter_valid_password() {

        patientPage.patientPasswordAccount.sendKeys( "qwer.1234" );


    }

    @Given("user enter Sign In button")
    public void user_enter_sign_in_button() {
       patientPage.signInPatientAccount.click();
    }

    @Given("user clicks the MY PAGES button")
    public void user_clicks_the_my_pages_button()  {

        patientPage.patientMyPagesButton.click();


    }

    @Given("user clicks the My Appointments button")
    public void user_clicks_the_my_appointments_button() {
        patientPage.patientMyApponitmentButton.click();


    }

    @Given("user clicks the Shows Test button")
    public void user_clicks_the_shows_test_button() {
        patientPage.patientShowTestsButton.click();


    }

    @Given("user clicks the View Results button")
    public void user_clicks_the_view_results_button() {


        patientPage.patientViewResultsButton.click();
    }

    @Then("user verify test results")
    public void user_verify_test_results() {
      softAssert.assertTrue( patientPage.patientResultsId.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResultsName.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResults.isDisplayed() );
      softAssert.assertTrue( patientPage.patientsTestDefMinValue.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResultsMaxVALUE.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResultsTest.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResultsDescriptions.isDisplayed() );
      softAssert.assertTrue( patientPage.patientResultsDate.isDisplayed() );
      softAssert.assertAll();


    }
    @When("user clicks the Show Invoice Button")
    public void user_clicks_the_show_invoice_button(){
       Driver.getDriver().navigate().back();


        patientPage.patientMyPagesButton.click();
        patientPage.patientMyApponitmentButton.click();
        Driver.getDriver().manage().window().fullscreen();

        patientPage.patientShowInvoice.click();
    }

    @Then("user verifies their Invoice")
    public void user_verifies_their_invoice() {
        softAssert.assertTrue( patientPage.invoiceDateResults.isDisplayed() );
        softAssert.assertTrue( patientPage.invoiceSSNResults.isDisplayed() );
        softAssert.assertTrue( patientPage.invoiceNameResults.isDisplayed() );
        softAssert.assertTrue(patientPage.invoicePaymentsMethodResults.isDisplayed() );
       softAssert.assertTrue( patientPage.invoiceTotalCostResults.isDisplayed() );
       softAssert.assertAll();

    }

}
